package br.com.bb.ditec.gesit.capacidade.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.repositories.StatusRecomendacaoTecnicaRepository;

@Service
public class StatusRecomendacaoService  {

    @Autowired
    private StatusRecomendacaoTecnicaRepository statusRecomendacaoTecnicaRepository;
    
    
    public StatusRecomendacaoTecnicaRepository getSRecomendacaoTecnicaRepository() {
		return statusRecomendacaoTecnicaRepository;
	}
    

}
