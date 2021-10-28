package br.com.bb.ditec.gesit.capacidade.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  br.com.bb.ditec.gesit.capacidade.api.repositories.NivelCriticidadeRepository;

@Service
public class NivelCriticidadeService  {

    
    @Autowired
    private NivelCriticidadeRepository nivelCriticidadeRepository;
    
	public NivelCriticidadeRepository getNivelCriticidadeRepository() {
		return nivelCriticidadeRepository;
	}
    
}
