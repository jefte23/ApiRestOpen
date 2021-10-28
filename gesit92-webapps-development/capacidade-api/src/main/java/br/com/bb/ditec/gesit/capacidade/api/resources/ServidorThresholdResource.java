package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.services.ServidorThresholdService;

@RestController
@RequestMapping("/servidorThreshold")
public class ServidorThresholdResource {

	@Autowired
	private ServidorThresholdService servidorThresholdService;
		
	
	
	@GetMapping
	public ResponseEntity<Object> listarServidorAcimaThreshold() {
		try {
			return new ResponseEntity<Object>(servidorThresholdService.listarServidorAcimaThreshold(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	



}
