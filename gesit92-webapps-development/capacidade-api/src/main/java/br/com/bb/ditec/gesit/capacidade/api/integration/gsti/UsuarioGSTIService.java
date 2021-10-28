package br.com.bb.ditec.gesit.capacidade.api.integration.gsti;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.config.PropertyService;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.model.UsuarioGSTI;
import lombok.Getter;


@Service 
public class UsuarioGSTIService {
  
	@Autowired @Getter
	private PropertyService propertyService;
	
	protected UsuarioGSTI usuarioGSTI;
	
	public UsuarioGSTIService() {
	}
	

	public UsuarioGSTIService(UsuarioGSTI usuarioGSTI) {
		this.usuarioGSTI = usuarioGSTI;
	}


	public UsuarioGSTI getUsuarioGSTI() {
		if( null == this.usuarioGSTI ) this.usuarioGSTI =  propertyService.usuarioGstiFactory();
		return this.usuarioGSTI;
	}


	public void setUsuarioGSTI(UsuarioGSTI usuarioGSTI) {
		this.usuarioGSTI = usuarioGSTI;
	}

	



	
	
	
}
