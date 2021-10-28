package br.com.bb.ditec.gesit.capacidade.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.ditec.gesit.capacidade.api.repositories.AnomaliaQueryRepository;

@RestController
@RequestMapping("/anomalia")
public class AnomaliaResource {

   @Autowired
   private AnomaliaQueryRepository anomaliaQueryRepository ;
   
   public AnomaliaResource() {
    }
	
   @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll( )  {
	   return   ResponseEntity.ok(anomaliaQueryRepository.findAll().list());
	}
}
