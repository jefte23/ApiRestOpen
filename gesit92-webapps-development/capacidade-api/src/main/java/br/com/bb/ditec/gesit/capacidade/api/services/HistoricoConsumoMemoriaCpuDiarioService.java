package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoMemoriaCpuDiario;
import br.com.bb.ditec.gesit.capacidade.api.repositories.HistoricoConsumoMemoriaCpuDiarioRepository;

@Service
public class HistoricoConsumoMemoriaCpuDiarioService {

	@Autowired
	private  HistoricoConsumoMemoriaCpuDiarioRepository service;
    

	public HistoricoConsumoMemoriaCpuDiarioService( ) {}

	
	public  List<HistoricoConsumoMemoriaCpuDiario>  historicoConsumoNosUltimos30Dias(Parametros param ) {
		try {
			return  this.service.historicoConsumoNosUltimos30Dias(param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar " + ComentarioService.class);
		}

	}
	
	

}
