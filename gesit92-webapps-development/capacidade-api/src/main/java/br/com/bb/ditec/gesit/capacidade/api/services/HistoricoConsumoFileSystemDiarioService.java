package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoFilesystemDiario;
import br.com.bb.ditec.gesit.capacidade.api.repositories.HistoricoConsumoFileSystemDiarioRepository;

@Service
public class HistoricoConsumoFileSystemDiarioService {

	@Autowired
	private  HistoricoConsumoFileSystemDiarioRepository dispositivoFileSistemRepository;
    

	public HistoricoConsumoFileSystemDiarioService( ) {}

	
	public List<HistoricoConsumoFilesystemDiario> historicoConsumoServidorFileSistemDosUtimos30dias(   Parametros param   ) {
		try {
			return  this.dispositivoFileSistemRepository.historicoConsumoServidorFileSistemDosUtimos30dias(param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar " + ComentarioService.class);
		}

	}
	
	

}
