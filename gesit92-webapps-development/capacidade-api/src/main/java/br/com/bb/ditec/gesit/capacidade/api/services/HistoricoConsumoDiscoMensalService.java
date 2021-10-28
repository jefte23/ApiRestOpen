package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoDiscoMensal;
import br.com.bb.ditec.gesit.capacidade.api.repositories.HistoricoConsumoDiscoMensalRepository;

@Service
public class HistoricoConsumoDiscoMensalService {

	@Autowired
	private  HistoricoConsumoDiscoMensalRepository repositorio;
    

	public HistoricoConsumoDiscoMensalService( ) {}

	
	public  List<HistoricoConsumoDiscoMensal>  historicoConsumoMensal(String servidor) {
		try {
			return  repositorio.historicoConsumoDiscoMensal(servidor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar " + ComentarioService.class);
		}

	}
	
	

}
