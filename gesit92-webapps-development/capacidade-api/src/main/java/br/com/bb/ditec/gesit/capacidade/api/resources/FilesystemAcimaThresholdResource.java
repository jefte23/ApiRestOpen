package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.services.FileSystemAcimaThresholdService;

@RestController
@RequestMapping("/fileSystemThreshold")
public class FilesystemAcimaThresholdResource {

	@Autowired
	private FileSystemAcimaThresholdService fileSystemAcimaThresholdService;
		

	@PostMapping
	public ResponseEntity<Object> listarServidorAcimaThreshold( @RequestBody  Parametros param) {
		try {
			return ResponseEntity.ok( fileSystemAcimaThresholdService.buscarFileSystemComConsumoAcimaDoThresholdNosUltimos30Dias( param ) );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
}
