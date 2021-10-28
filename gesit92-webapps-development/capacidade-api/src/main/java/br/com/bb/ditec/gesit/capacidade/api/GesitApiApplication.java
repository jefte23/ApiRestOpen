package br.com.bb.ditec.gesit.capacidade.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import br.com.bb.ditec.gesit.capacidade.api.config.AnotationConfigApplication;
import br.com.bb.ditec.gesit.capacidade.api.config.properties.ApplicationProperties;

@SpringBootApplication
public class GesitApiApplication {

	private static ApplicationProperties applicationProperties;

	public static void main(String[] args) {

		try {
			SpringApplication application = new SpringApplication(GesitApiApplication.class);
			ConfigurableEnvironment environment = new StandardEnvironment();
			applicationProperties = new AnotationConfigApplication().getApplicationProperties();
			environment.setActiveProfiles( applicationProperties.isProducao() ? ApplicationProperties.PROD : ApplicationProperties.DEV);
			application.setEnvironment(environment);
			application.run(args);
		} catch (Exception e) {
         //  System.out.println(" Erro ao inicializar  Application ! " + e.getMessage() );
		}

	}
	
	
	
}
