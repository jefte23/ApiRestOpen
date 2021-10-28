package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.entities.ListaThreshold;
import br.com.bb.ditec.gesit.capacidade.api.repositories.ServidorThresholdRepository;

@Service
public class ServidorThresholdService {

	@Autowired
	private  ServidorThresholdRepository service;
    

	public ServidorThresholdService( ) {}

	
	public  List<ListaThreshold>  listarServidorAcimaThreshold() {
		try {
			return  this.service.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Listar Servidores Acima do Threshold" + ComentarioService.class.getSimpleName());
		}
	}
}
