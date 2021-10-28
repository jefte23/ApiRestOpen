package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.config.PropertyService;

/**
 * @author Lucas.carvalho - C1279457
 * @since 13/04/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

@RestController
@RequestMapping("/config")
public class ConfigAplicativoResource {
	@Autowired
	private PropertyService propService;
	
	@GetMapping
	public ResponseEntity<?> getConfig() {
		try {
			return ResponseEntity.ok( propService.getApplicationProperties() );
		}catch(Exception ex) {
		   return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/integracao")
	public ResponseEntity<?> getIntegracao() {
		try {
			return ResponseEntity.ok( 
					this.propService.getApplicationProperties() );
		}catch(Exception ex) {
		   return ResponseEntity.badRequest().build();
		}
	}
	
}
