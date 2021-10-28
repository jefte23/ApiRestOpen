package br.com.bb.ditec.gesit.capacidade.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bb.ditec.gesit.capacidade.api.email.EmailService;
import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import br.com.bb.ditec.gesit.capacidade.api.entities.RecomendacaoTecnica;
import br.com.bb.ditec.gesit.capacidade.api.services.RecomendacaoTecnicaService;
import br.com.bb.ditec.gesit.capacidade.api.entities.StatusRecomendacaoTecnica;
import br.com.bb.ditec.gesit.capacidade.api.services.StatusRecomendacaoService;
import br.com.bb.ditec.gesit.capacidade.api.services.UsuarioService;
import br.com.bb.ditec.gesit.capacidade.api.services.EquipeService;
import br.com.bb.ditec.gesit.capacidade.api.entities.NivelCriticidade;
import br.com.bb.ditec.gesit.capacidade.api.services.NivelCriticidadeService;
import br.com.bb.ditec.gesit.capacidade.api.enuns.STATUS_RECOMEN;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { @ApiResponse(code = 200, message = "rtc gravado com sucesso"),
		@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
		@ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
		@ApiResponse(code = 404, message = "O empreendimento que você estava tentando acessar não foi encontrado"),
		@ApiResponse(code = 500, message = "Erro interno do servidor")

})
@Api("Recuperando um empreendimento por id")
@RestController
//@RequestMapping("/empreendimento")
public class RecomendacaoTecnicaResource {

	@Autowired
	private RecomendacaoTecnicaService rtcService;

	@Autowired
	private StatusRecomendacaoService statusRecomendacaoService;

	@Autowired
	private NivelCriticidadeService nivelCriticidadeService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EquipeService equipeService;

	@Autowired
	private EmailService emailService;

	// ----------------------------------- Insere novo  -----------------------------------
	@ApiOperation(value = "Inserir novo RTC no banco de dados", notes = "insert da tabela", response = RecomendacaoTecnica.class, produces = "application/json")
	@GetMapping
	@JsonFormat
	@RequestMapping("/rtc/saveExterno")
	public ResponseEntity<?> cadastrar(String matriculaCriador, String matriculaResponsavel, Long nivelCriticidade,
			Integer codigoEquipe, String nomeEquipe, String comentario) {

		RecomendacaoTecnica rtc = new RecomendacaoTecnica();

		rtc.setNivelCriticidade(getNivelCriticidade(nivelCriticidade));
		rtc.setNumeroRTC(rtcService.gerarNumeroRecomendacaoTecnica());
		rtc.setStatusRecomendacaoTecnica(getStatusRTC(STATUS_RECOMEN.EMCAMINHADO.getCodigo()));

		rtc.setMatriculaCriador(matriculaCriador);
		rtc.setMatriculaResponsavel(matriculaResponsavel);
		rtc.setNomeEquipe(nomeEquipe);
		rtc.setCodigoEquipe(codigoEquipe);

		rtc.getDescricaoRTC().setStatus(rtc.getStatusRecomendacaoTecnica().getNomeStatus());
		rtc.getDescricaoRTC().setComentario(comentario);
		rtc.getDescricaoRTC().setRtc(rtc);
		rtc.getDescricaoRTC().setMatriculaCriador(matriculaCriador);

		try {

			rtc = rtcService.save(rtc);
			enviarEmail(rtc);

			return ResponseEntity.ok(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

	private StatusRecomendacaoTecnica getStatusRTC(Long id) {
		if (id == null)
			return null;
		return statusRecomendacaoService.getSRecomendacaoTecnicaRepository().findOne(id);
	}

	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

	private NivelCriticidade getNivelCriticidade(Long id) {
		if (id == null)
			return null;
		return nivelCriticidadeService.getNivelCriticidadeRepository().findOne(id);
	}

	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

	private void enviarEmail(RecomendacaoTecnica rtc) {

		// Envia e-mail para a equipe
		List<String> emails = usuarioService.getEmails(rtc.getCodigoEquipe());

		// Busca e insere emails da equipe de capadidade
		emails.addAll(usuarioService.getEmails(usuarioService.getCodigoEquipe(rtc.getMatriculaCriador())));

		Funcionario funci = usuarioService.getUser(rtc.getMatriculaCriador());

		// busca emails de Gerente de divisao da Capacidade e insere na lista
		int CapPrefivo = usuarioService.getPrefixo(rtc.getMatriculaResponsavel());
		String divCap = usuarioService.getDivisaoGesit(funci.getMatricula()); // consulta divisão do Funcionario

		emails.addAll(usuarioService.getEmailsGerenteGesit(divCap, CapPrefivo));

		// Consulta o prefixo da equipe
		int bbPrefixo = equipeService.findCodDivByCodEquipe(rtc.getCodigoEquipe());

		// Envia Email para equipe responsavel + gerentes de divisão - GESIT
		if (bbPrefixo == 9905) {
			String div = equipeService.findDivByCodEquipe(rtc.getCodigoEquipe()); // consulta divisão da equipe se GESIT
			if (null != div) {
				emails.addAll(usuarioService.getEmailsGerenteGesit(div, bbPrefixo));
				emailService.enviarEmailRTC(rtc, funci, emails);
			}
		}
		// Envia Email para equipe responsavel + gerentes de divisão - GESAT
		else if (bbPrefixo == 9916) {
			String div = equipeService.findDivByCodEquipe(rtc.getCodigoEquipe()); // consulta divisão da equipe se GESAT
			if (null != div) {
				emails.addAll(usuarioService.getEmailsGerenteGesat(div, bbPrefixo));
				emailService.enviarEmailRTC(rtc, funci, emails);
			}
		} else {
			// Envia Emails
			emailService.enviarEmailRTC(rtc, funci, emails);
		}

		return;
	}
}
