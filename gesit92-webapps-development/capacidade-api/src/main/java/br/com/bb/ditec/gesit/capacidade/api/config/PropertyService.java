package br.com.bb.ditec.gesit.capacidade.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.config.properties.ApplicationProperties;
import br.com.bb.ditec.gesit.capacidade.api.config.properties.IntegracaoDevProperties;
import br.com.bb.ditec.gesit.capacidade.api.config.properties.IntegracaoProperties;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.model.UsuarioGSTI;
import lombok.Getter;

/**
 * fonte:
 * https://dzone.com/articles/spring-core-diving-into-the-propertyplaceholdercon
 * 
 * @author Lucas.carvalho - C1279457
 * @since 16/042018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */
@Service
public class PropertyService {
	
	@Autowired
	@Getter
	private  ApplicationProperties applicationProperties;
	
	@Autowired @Getter
	private IntegracaoDevProperties integracaoDevProperties;
	
	@Autowired @Getter
	private IntegracaoProperties integracaoProperties;
	
	
	public PropertyService() {}
	
	public boolean isProdruca() {
		return this.applicationProperties.isProducao();
	}
	
     public UsuarioGSTI usuarioGstiFactory() throws RuntimeException {
    	 if( isProdruca() ) new UsuarioGSTI( this.integracaoProperties.getUsername() , this.integracaoProperties.getPassword() );
		return  new UsuarioGSTI( this.integracaoDevProperties.getUsername(), this.integracaoDevProperties.getPassword() );
	}
	

}
