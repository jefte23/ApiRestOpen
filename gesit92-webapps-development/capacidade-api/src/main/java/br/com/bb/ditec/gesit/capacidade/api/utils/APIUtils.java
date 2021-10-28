package br.com.bb.ditec.gesit.capacidade.api.utils;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Lucas.carvalho - C1279457
 * @since 27/03/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */
public class APIUtils {
	
	public static final int ULTIMOS_30_DIAS = 30;
	
	public static URI getURI(final String codigo){
		return ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(codigo)
				.toUri();
		
	}
	
	
	//TODO:....
	
	public static boolean ehFuncionario(final String matricula){
		if(matricula == null || matricula.equals("")) return false;  
		return matricula.toUpperCase().contains("F");
	}
	
	  public static int getDias(int dias) {
			return (dias > 0 ) ? ULTIMOS_30_DIAS : dias  ;
		} 

}
