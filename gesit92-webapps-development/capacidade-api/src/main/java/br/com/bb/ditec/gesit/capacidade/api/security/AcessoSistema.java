package br.com.bb.ditec.gesit.capacidade.api.security;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name="TB_PORTA_ACESSO") @Entity
public class AcessoSistema {

	@Id @Column(name="ID")
	 private Integer id;
	 
	 @Column(name="DESCRICAO")
	 private String desc;
	 
	 @Column(name="COD_EQUIPE")
	 private Long codEquipe;
	 
	 @Column(name="ID_PAPEL")
	 private Integer codigoAcessso;

	public boolean isAdmin() {
		return  this.codigoAcessso == UsuarioAcesso.ADMIN.getAcesso();
	}
	
	public boolean isConectividade() {
		
		if (this.codEquipe.intValue() == UsuarioAcesso.CONECTIVIDADE.getAcesso()){ 
			return true; 
		}else if (this.codEquipe.intValue() == UsuarioAcesso.CONECTIVIDADE_SP.getAcesso()) {
			return true;
		}else {
			return false;
		}
	}
		
	public boolean isCapacidade() {
		return this.codEquipe.intValue() == UsuarioAcesso.CAPACIDADE.getAcesso();
	}
	
	public boolean isGerenteSolucao() {
		return this.codEquipe.intValue() == UsuarioAcesso.EXECUTIVO.getAcesso();
	}
	
}
