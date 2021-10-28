package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.services.HistoricoConsumoServicoMensalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Histórico de consumo de recurso do serviço recuperado com sucesso"),
        @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
        @ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
        
})
@Api("Recuperando histórico de consumo de recurso(cpu, memória, disco) por serviço")
@RestController
@RequestMapping("/historicoConsumoServicoMensal")
public class HistoricoConsumoServicoMensalResource {

	@Autowired
	private HistoricoConsumoServicoMensalService consumoService;
		

	@GetMapping
	@RequestMapping("/{parametro}")
	public ResponseEntity<Object> listarHistoricoConsumoServicoMensal(@ApiParam(required=true, type="String", value="Nome do Serviço. Exemplo: plataforma bb web")  @PathVariable String parametro) {
		try {
			return ResponseEntity.ok( consumoService.historicoConsumoMensal(parametro) );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	



}
