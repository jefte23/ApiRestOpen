package br.com.bb.ditec.gesit.capacidade.api.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 16/042018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 *        Proprideade do application.properties.
 */
@Configuration 
@ConfigurationProperties
public class ApplicationProperties{
	
	public static final String DEV = "dev";
	public static final String PROD = "prod";
	
	
	@Value("${capacidade.servidor.em-producao}")
	@Getter
	private boolean producao;


	
	

	
	

	


}
