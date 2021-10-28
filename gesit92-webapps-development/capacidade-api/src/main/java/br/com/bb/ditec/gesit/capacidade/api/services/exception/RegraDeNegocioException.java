package br.com.bb.ditec.gesit.capacidade.api.services.exception;


/**
 * @author Lucas.carvalho - C1279457
 * @since 20/03/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */


public class RegraDeNegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RegraDeNegocioException(String mensagem) {
		super(mensagem);
	}
	
	public RegraDeNegocioException(String mensagem , Throwable causa) {
		super(mensagem, causa);
	}

}
