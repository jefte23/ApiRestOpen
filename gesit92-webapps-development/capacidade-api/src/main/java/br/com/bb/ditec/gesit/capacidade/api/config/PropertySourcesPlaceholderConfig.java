package br.com.bb.ditec.gesit.capacidade.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

	/**
	 * fonte:
	 * https://dzone.com/articles/spring-core-diving-into-the-propertyplaceholdercon
	 * 
	 * @author Lucas.carvalho - C1279457
	 * @since 16/042018
	 * @email - lucas.carvalho@capgemeni.com.br
	 * 
	 * Configuração de  do bean Placeholder.
	 */


@Configuration
public class PropertySourcesPlaceholderConfig {

	private static final String APPLICATION_PROPERTIES = "application.properties";
 
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource(APPLICATION_PROPERTIES));
		return propertySourcesPlaceholderConfigurer;
	}

}
