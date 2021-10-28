package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoDiscoMensal;
import br.com.bb.ditec.gesit.capacidade.api.services.HistoricoConsumoDiscoMensalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Histórico de consumo de disco mensal recuperado com sucesso"),
        @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
        @ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
        
})

@RestController
@RequestMapping("/historicoConsumoDiscoMensal")
public class HistoricoConsumoDiscoMensalResource {

	@Autowired
	private HistoricoConsumoDiscoMensalService consumoService;
		

	@GetMapping
	@ApiOperation(value = "Retorna o histórico de consumo mensal de disco do servidor requerido",produces="aplication/json" , notes = "Consulta síncrona",response= HistoricoConsumoDiscoMensal.class)
	@RequestMapping("/{nomeServidor}")
	public ResponseEntity<Object> listarHistoricoConsumoDiscoMensal(@ApiParam(required=true, type="String", value="Nome do Servidor. Exemplo: pbws2009") @PathVariable String nomeServidor) {
		try {
			return ResponseEntity.ok( consumoService.historicoConsumoMensal(nomeServidor) );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	



}
