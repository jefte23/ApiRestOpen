package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import br.com.bb.ditec.gesit.capacidade.api.services.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author Lucas.carvalho - C1279457
 * @since 15/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Funcionário recuperada com sucesso"),
        @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
        @ApiResponse(code = 403, message = "O recurso que você está tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
        
})
@Api("Recuperando um funcionário por matrícula")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;
		
	
	@ApiOperation(value = "Consulta o funcionário por matrícula", notes = "Consulta síncrona",response = Funcionario.class, produces = "application/json")
	@GetMapping
	@RequestMapping("/{matricula}")
	public ResponseEntity<?> buscarFuncionarioPorChave(@ApiParam(required=true, type="String", value="Matrícula Funcionario", format="F110011")   @PathVariable("matricula") String matricula) {
		try {
			 Funcionario funci = funcionarioService.buscarFuncionarioPorChave( matricula );
		   return ResponseEntity.ok(funci);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	


}
