package br.com.bb.ditec.gesit.capacidade.api.security;

import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UsuarioSistem {

	private Funcionario funci = new Funcionario();
	private AcessoSistema acesso = new AcessoSistema();

	public UsuarioSistem(Funcionario funci) {
		this.funci = funci;
	}

	public boolean isAdmin() {
		return acesso.isAdmin();
	}

	public boolean isConectividade() {
		return acesso.isConectividade();
	}

	public boolean isCapacidade() {
		return acesso.isCapacidade();
	}
	
    public boolean isGerSolucao() {
	  
		 boolean config = funci.getCodigoEquipe() == 338643; boolean solucao =
				acesso.isGerenteSolucao();
	  
		 if (solucao && config) { 
			 return true;
		 } 
		 else { 
			 return false; 
		 } 
	 }
	 
	

	public UsuarioSistem() {
	}

}
