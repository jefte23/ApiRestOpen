package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.bb.ditec.gesit.capacidade.api.dto.Paginacao;
import br.com.bb.ditec.gesit.capacidade.api.entities.ComentarioGrupo;
//import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.ComentarioHE;
//import br.com.bb.ditec.gesit.capacidade.api.repositories.ComentarioHERepository;
import br.com.bb.ditec.gesit.capacidade.api.repositories.ComentarioGrupoRepository;

@Service
public class ComentarioService {

   
	@Autowired
	private ComentarioGrupoRepository comentarioGrupoRepository;
	
	/*@Autowired
	private ComentarioHERepository comentarioHERepository;
    */

	public ComentarioService() {}


	public  List<ComentarioGrupo>  listarComentarioGrupo() {
		try {
			return  this.comentarioGrupoRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao lista comentárioGrupo" + ComentarioService.class.getSimpleName());
		}

	}
	/*
	public  List<ComentarioHE>  listarComentarioHE( Paginacao param ) {
		try {
			return  this.comentarioHERepository.listarComentarioHE( param );
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao lista comentárioHE" + ComentarioService.class.getSimpleName());
		}

	}*/

	

}
