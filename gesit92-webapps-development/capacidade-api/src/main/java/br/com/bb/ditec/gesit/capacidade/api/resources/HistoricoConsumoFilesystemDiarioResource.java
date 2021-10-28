package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoFilesystemDiario;
import br.com.bb.ditec.gesit.capacidade.api.services.HistoricoConsumoFileSystemDiarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jefferson.Maciel - F4684108
 * @since 28/06/2018
 * @email - jeffmaciel@bb.com.br
 * 
 */
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Histórico de consumo diário de filesystem recuperado com sucesso"),
        @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
        @ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
        
})


@RestController
@RequestMapping("/historicoConsumoFilesystemDiario")
public class HistoricoConsumoFilesystemDiarioResource {

	@Autowired
	private HistoricoConsumoFileSystemDiarioService hConsumoServidorDispositivoFileSistemService;
		
	@ApiOperation(value = "Retorna o histórico de consumo diário do(s) filesystem(s) do servidor requerido", notes = "Consulta síncrona",response = HistoricoConsumoFilesystemDiario.class, produces = "application/json")
	@PostMapping
	public ResponseEntity<Object>listarHistoricoConsumoFilesystemDiario(@ApiParam(required=true, type="String", value="Parâmetros")  @RequestBody  Parametros parametro) {
		try {
			return ResponseEntity.ok( hConsumoServidorDispositivoFileSistemService.historicoConsumoServidorFileSistemDosUtimos30dias(parametro) );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	



}
