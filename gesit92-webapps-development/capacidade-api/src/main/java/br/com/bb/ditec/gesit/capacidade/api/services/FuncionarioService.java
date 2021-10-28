package br.com.bb.ditec.gesit.capacidade.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.config.properties.MensagemProperties;
import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import br.com.bb.ditec.gesit.capacidade.api.repositories.FuncionarioRepository;
import lombok.Getter;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
   
	@Autowired
	@Getter
	private  MensagemProperties mensagemProperties;
    

	public FuncionarioService( ) {
	  
	}

	public Funcionario buscarFuncionarioPorChave(String chave){
		try {
			return  this.funcionarioRepository.findOne( chave.toUpperCase() );
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Funcionario não localizado! :" + chave);
		}

	}
	
	

}
