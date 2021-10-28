package br.com.bb.ditec.gesit.capacidade.api.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

/**
 * @author Lucas.carvalho - C1279457
 * @since 15/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */


@Configuration
@PropertySource("classpath:integracao.properties")
@Getter
public class IntegracaoProperties  {
	
	@Value("${integracao.capacidade.gsti.bbincidentes.url}")
	private String  buscarFucnionario;
	
	@Value("${integracao.capacidade.gsti.bbincidentes.url}")
	private String bbincidentesUrl;
	
	@Value("${integracao.capacidade.gsti.bbincidentes.username}")
	private String username;
	
	@Value("${integracao.capacidade.gsti.bbincidentes.password}")
	private String password;
	
	

}
