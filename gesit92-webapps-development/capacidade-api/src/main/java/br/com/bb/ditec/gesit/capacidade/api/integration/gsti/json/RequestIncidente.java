package br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 14/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */
@Getter @Setter
@NoArgsConstructor
public class RequestIncidente {

   
	private BbIncidente bbincidente;

	public RequestIncidente(BbIncidente bbincidente) {
		this.bbincidente = bbincidente;
	}
	
	
	

}




