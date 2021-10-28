package br.com.bb.ditec.gesit.capacidade.api.services;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.HttpClientGSTI;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.RequestIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.ResponseIncidente;
import lombok.Setter;

/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 12/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 *        classe serviço de integração com o GSTI.
 */

@Service
@Validated
public class GSTIService {
	
	@Autowired 	@Setter
	private HttpClientGSTI httpClient;
	
	public GSTIService() {}


	public GSTIService(HttpClientGSTI httpClient) {
		this.httpClient = httpClient;
	}

	
			
	public ResponseIncidente buscarIncidentete(@Size(min = 5, max = 20) String rdi) {
	  return httpClient.buscarIncidente(rdi);
	}
	
	public ResponseIncidente cadastrarIncidente(final RequestIncidente inicidente) {
	  return httpClient.cadastrarIncidente(inicidente);
	}


}




