package br.com.gesit.capacidade;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.HttpClientGSTI;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.UsuarioGSTIService;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.RequestIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.ResponseIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.model.UsuarioGSTI;
import br.com.bb.ditec.gesit.capacidade.api.services.GSTIService;
import br.com.gesit.capacidade.mock.RequestIncidenteMock;

public class IntegracaoGSTITeste {

	private static final String RDI_PARAM = "RDI20180058627";
	private static final int INCIDENTE_OK = 0;
	private static final String userName = "CAPACIDADE";
	private static final String password = "#teste#123";
	
	
	private GSTIService gSTIService =  new GSTIService(
			new HttpClientGSTI(  new UsuarioGSTIService( new UsuarioGSTI(userName, password)) )
			) ;
    
    
	@Test
	public void cadastraIncidente() {
		RequestIncidente mock = RequestIncidenteMock.criarRequestIncidente();
	    System.err.println( HttpClientGSTI.toJson(mock) );
		ResponseIncidente responseIncidente   = gSTIService.cadastrarIncidente(mock);
        System.out.println( responseIncidente );
        assertTrue( responseIncidente.getReturnCode() == INCIDENTE_OK );
	}
	
	
	@Test
	public void buscarIncidente() {
		ResponseIncidente responseIncidente = gSTIService.buscarIncidentete(RDI_PARAM);
		System.out.println( responseIncidente );
        assertTrue( responseIncidente.getBbincidente().getIDIncidente().equals(RDI_PARAM) );
	}
	
	
}


