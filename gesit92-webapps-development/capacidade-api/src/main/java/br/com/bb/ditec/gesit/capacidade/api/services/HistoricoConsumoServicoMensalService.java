package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoServicoMensal;
import br.com.bb.ditec.gesit.capacidade.api.repositories.HistoricoConsumoServicoMensalRepository;

@Service
public class HistoricoConsumoServicoMensalService {

	@Autowired
	private  HistoricoConsumoServicoMensalRepository service;
    

	public HistoricoConsumoServicoMensalService( ) {}

	
	public  List<HistoricoConsumoServicoMensal>  historicoConsumoMensal(String nomeGrupo) {
		try {
			return  this.service.historicoConsumoServicoMensal(nomeGrupo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar " + ComentarioService.class);
		}

	}
	
	

}
