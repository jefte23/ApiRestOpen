package br.com.bb.ditec.gesit.capacidade.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import br.com.bb.ditec.gesit.capacidade.api.dto.ComentarioHEParam;
import br.com.bb.ditec.gesit.capacidade.api.dto.Paginacao;
import br.com.bb.ditec.gesit.capacidade.api.entities.Grupo;
import br.com.bb.ditec.gesit.capacidade.api.entities.Recurso;
import br.com.bb.ditec.gesit.capacidade.api.entities.Servico;
import br.com.bb.ditec.gesit.capacidade.api.repositories.GrupoRepository;
import br.com.bb.ditec.gesit.capacidade.api.repositories.RecursoRepository;
import br.com.bb.ditec.gesit.capacidade.api.repositories.ServicoRepository;*/
import br.com.bb.ditec.gesit.capacidade.api.services.ComentarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/comentariohe")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Todos os comentáriosHE recuperados com sucesso"),
		@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
		@ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
		@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
public class ComentarioHEResource {

	@Autowired
	private ComentarioService service;
	
	/*@Autowired
	private GrupoRepository  grupoRepository ;
	
	@Autowired
	private ServicoRepository servicoRepositiry;
	
	@Autowired
	private RecursoRepository recursoRepositiry;
	
	@GetMapping("/recurso/{servico}")
	@ApiOperation(value = "Recurso comentario HE", produces = "aplication/json", response = Grupo.class)
	public ResponseEntity<List<Recurso>> listaRecuros(@PathVariable String servico  ) {
		try {
			
			boolean heDataCenter = servico.equalsIgnoreCase( Recurso.DATACENTER ) ; 
			List<Recurso> lista = ( heDataCenter ) ? this.recursoRepositiry.listDataCenter() : this.recursoRepositiry.listar();
			 
			return ResponseEntity.ok( lista  );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@GetMapping("/grupo/{servico}")
	@ApiOperation(value = "Grupo comentario HE", produces = "aplication/json", response = Grupo.class)
	public ResponseEntity<List<Grupo>> listaGrupo(@PathVariable String servico  ) {
		try {
			List<Grupo> lista = this.grupoRepository.list( servico );
			return ResponseEntity.ok( lista   );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@GetMapping("/servico")
	@ApiOperation(value = "servico comentario HE", produces = "aplication/json", response = Grupo.class)
	public ResponseEntity<List<Servico>> listaServico() {
		try {
			return ResponseEntity.ok( this.servicoRepositiry.list()  );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	

	@GetMapping("/{first}/{pageSize}")
	@ApiOperation(value = "listar os comentáriosHE", produces = "aplication/json", notes = "${ComentarioHEResource.listaComentario()}", response = ComentarioHEParam.class)
	public ResponseEntity<ComentarioHEParam> listaComentario(@PathVariable String first, @PathVariable String pageSize ) {
		try {
			
				Paginacao page = new Paginacao( first , pageSize );
				ComentarioHEParam comentario = new ComentarioHEParam(page, this.service.listarComentarioHE(page) );
			
			return ResponseEntity.ok( comentario    );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}*/

}
