package br.com.bb.ditec.gesit.capacidade.api.integration.gsti;


import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.RequestIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.ResponseIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.model.UsuarioGSTI;
import lombok.Getter;
/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 12/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 * classe de configuração de integração com os servicos do GSTI.
 *        
 * https://stackoverflow.com/questions/21920268/basic-authentication-for-rest-api-using-spring-resttemplate
 * https://o7planning.org/en/11647/spring-boot-restful-client-with-resttemplate-example
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-resttemplate
 * */

@Service @Component @Configuration
public class HttpClientGSTI {
	
	private static final String BASIC_HEADER = " Basic ";
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	//http://172.17.189.110:13081/SM/9/rest/bbincidentes/RDI20180058627
	
	@Autowired 
	private UsuarioGSTIService usuarioGSTIService; 
	
	@Getter
	public int httpStatus;

	private ResponseIncidente retorno;
	
	public HttpClientGSTI(UsuarioGSTIService usuarioGSTIService) {
		this.usuarioGSTIService = usuarioGSTIService;
	}
	
	public HttpClientGSTI() {}
	
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().rootUri( rootUri() )
				.basicAuthorization( this.usuarioGSTIService.getUsuarioGSTI().getUserName() , this.usuarioGSTIService.getUsuarioGSTI().getPassword() ).build();
	}

	public ResponseIncidente buscarIncidente(final String rdi) {
		try {
			ResponseEntity<String> response = restTemplate().getForEntity("/{rdi}", String.class, rdi);
			retorno = new Gson().fromJson(response.getBody(), ResponseIncidente.class);
			httpStatus = response.getStatusCodeValue();
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public ResponseIncidente cadastrarIncidente(final RequestIncidente body) {
		try {

			Response response = ClientBuilder.newClient().target( rootUri() ).request("application/json").header(AUTHORIZATION_HEADER, criarAuthorizationHeaderValue( this.usuarioGSTIService.getUsuarioGSTI() ) )
					.post( Entity.json( toJson(body) ) );
			System.out.println( toJson(body) );
			httpStatus = response.getStatus();
			retorno = new Gson().fromJson( response.readEntity(String.class) , ResponseIncidente.class );
			System.out.println( retorno );
			return retorno ;
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
		}
	}

	public static String toJson(final Object body) {
		return new Gson().toJson(body);
	}
	
	public static <T> T fromJson(String json, Class<T> classOfT) {
		return new Gson().fromJson( json, classOfT );
	}

	private static String criarAuthorizationHeaderValue(UsuarioGSTI usuarioGSTI) {
		return BASIC_HEADER + java.util.Base64.getEncoder().encodeToString((usuarioGSTI.getUserName() + ":" + usuarioGSTI.getPassword()).getBytes());
	}

	private String rootUri() {
		return "http://172.17.189.110:13081/SM/9/rest/bbincidentes/";
//		return integracaoProperties.getAppProperties().getProducao() 
//				? integracaoProperties.gsti : integracaoProperties.getIntegracaoDevProperties().gsti;
	}

}

