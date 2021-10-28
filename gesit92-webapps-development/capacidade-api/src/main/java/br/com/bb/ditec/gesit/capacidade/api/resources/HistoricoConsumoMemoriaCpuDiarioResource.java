package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoMemoriaCpuDiario;
import br.com.bb.ditec.gesit.capacidade.api.services.HistoricoConsumoMemoriaCpuDiarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Histórico de consumo mensal de Memória e CPU recuperado com sucesso"),
        @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
        @ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
        
})
@RestController
@RequestMapping("/historicoConsumoMmrCpuDiario")
public class HistoricoConsumoMemoriaCpuDiarioResource {

	@Autowired
	private HistoricoConsumoMemoriaCpuDiarioService consumoService;
		
	@ApiOperation(value = "Retorna o histórico do consumo diário de cpu e memória do servidor requerido", notes = "Consulta síncrona",response = HistoricoConsumoMemoriaCpuDiario.class, produces = "application/json")
	@PostMapping
	public ResponseEntity<Object> listarHistoricoConsumoMemoriaCpuDiario(@RequestBody  Parametros parametro) {
		try {
			return ResponseEntity.ok( consumoService.historicoConsumoNosUltimos30Dias( parametro ) );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	



}
