package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoServicoDiario;
import br.com.bb.ditec.gesit.capacidade.api.repositories.HistoricoConsumoServicoDiarioRepository;

@Service
public class HistoricoConsumoServicoDiarioService {

	@Autowired
	private  HistoricoConsumoServicoDiarioRepository service;
    

	public HistoricoConsumoServicoDiarioService( ) {}

	
	public  List<HistoricoConsumoServicoDiario>  historicoConsumoNosUltimos30Dias(Parametros param ) {
		try {
			return  this.service.historicoConsumoNosUltimos30Dias(param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar " + ComentarioService.class);
		}

	}
	
	

}
