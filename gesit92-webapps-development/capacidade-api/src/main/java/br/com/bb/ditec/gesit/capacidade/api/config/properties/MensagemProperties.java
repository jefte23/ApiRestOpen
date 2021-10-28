package br.com.bb.ditec.gesit.capacidade.api.config.properties;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author Lucas.carvalho - C1279457
 * @since 15/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

@Configuration
@PropertySource("classpath:mensagens.properties")
public class MensagemProperties {
	
	@Autowired
    private Environment env;
	
	public  String get(String key) {
		 return env.getProperty(key);
    }
	
	public String get(String key,  Object...msg) {
        return MessageFormat.format(env.getProperty(key), msg) ;
    }

}
