package br.com.bb.ditec.gesit.capacidade.api.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.bb.ditec.gesit.capacidade.api.config.properties.ApplicationProperties;

/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 16/042018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 *        Configuração dos bens spring ao iniciar aplicação.
 */

@Configuration
@EnableWebMvc
public class AnotationConfigApplication {
   
	
	private ConfigurableApplicationContext getConfigurableApplicationContext(Class<?>...clazz) {
		return new AnnotationConfigApplicationContext(clazz);
	}

	@Bean
	public ApplicationProperties getApplicationProperties() {
		return getConfigurableApplicationContext( PropertySourcesPlaceholderConfig.class, ApplicationProperties.class)
				.getBean( ApplicationProperties.class );
	}
	

	
}
