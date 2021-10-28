package br.com.bb.ditec.gesit.capacidade.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.repositories.EquipeRepository;
import lombok.Getter;

@Service
public class EquipeService{


	@Autowired @Getter
    private EquipeRepository equipeRepository;

    public int findCodDivByCodEquipe(Integer codigoEquipe) {
    	return this.equipeRepository.getCodDiv(codigoEquipe);
    }
    
    public String findDivByCodEquipe(Integer codigoEquipe) {
    	return this.equipeRepository.getDiv(codigoEquipe);
    }
    
}
