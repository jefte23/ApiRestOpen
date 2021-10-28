package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoMemoriaCpuMensal;
import br.com.bb.ditec.gesit.capacidade.api.repositories.HistoricoConsumoMemoriaCpuMensalRepository;

@Service
public class HistoricoConsumoMemoriaCpuMensalService {

	@Autowired
	private  HistoricoConsumoMemoriaCpuMensalRepository service;
    

	public HistoricoConsumoMemoriaCpuMensalService( ) {}

	
	public  List<HistoricoConsumoMemoriaCpuMensal>  historicoConsumoMensal(String servidor) {
		try {
			return  this.service.historicoConsumoMensal(servidor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar " + ComentarioService.class);
		}

	}
	
	

}
