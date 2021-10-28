package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoServicoDiario;
import br.com.bb.ditec.gesit.capacidade.api.services.HistoricoConsumoServicoDiarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Histórico de consumo recuperado com sucesso"),
        @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
        @ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
        
})
@RestController
@RequestMapping("/historicoConsumoServicoDiario")
public class HistoricoConsumoServicoDiarioResource {

	@Autowired
	private HistoricoConsumoServicoDiarioService consumoService;
		
	@ApiOperation(value = "Retorna o histórico do consumo diário de recursos (cpu, memória e disco) do serviço requerido", notes = "Consulta síncrona",response = HistoricoConsumoServicoDiario.class, produces = "application/json")
	@PostMapping
	public ResponseEntity<Object> listarHistoricoConsumoServicoDiario(@RequestBody  Parametros parametro) {
		try {
			return ResponseEntity.ok( consumoService.historicoConsumoNosUltimos30Dias( parametro ) );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	



}
