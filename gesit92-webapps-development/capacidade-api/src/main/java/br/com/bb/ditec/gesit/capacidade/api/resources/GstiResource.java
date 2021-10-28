package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.HttpClientGSTI;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.RequestIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.ResponseIncidente;
import br.com.bb.ditec.gesit.capacidade.api.services.GSTIService;


@RestController
@RequestMapping("/bbincidente")
public class GstiResource {

	@Autowired
	private GSTIService gstiService;

	@GetMapping
	@RequestMapping("/{rdi}")
	public ResponseEntity<ResponseIncidente> buscarIncidente(@PathVariable("rdi")  String rdi) {
		try {
			ResponseIncidente response = gstiService.buscarIncidentete(rdi);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody  @NotEmpty String  requestIncidente) {
		try {
			RequestIncidente req = HttpClientGSTI.fromJson(requestIncidente, RequestIncidente.class);
			ResponseIncidente response = gstiService.cadastrarIncidente( req );
			return ResponseEntity.ok( response );
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
