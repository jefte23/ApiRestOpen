package br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 14/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */
 
@Getter
@Setter
public class ResponseIncidente {

	private ArrayList<String> Messages;
	private BbIncidente bbincidente;
	private int ReturnCode;

	public ResponseIncidente(ArrayList<String> messages, BbIncidente bbincidente, int returnCode) {
		Messages = messages;
		this.bbincidente = bbincidente;
		ReturnCode = returnCode;
	}

	public ResponseIncidente() {
	}

	@Override
	public String toString() {
		return "ResponseIncidente [Messages=" + Messages + ", bbincidente=" + bbincidente + ", ReturnCode=" + ReturnCode
				+ "]";
	}
	
	
}


