package br.com.bb.ditec.gesit.capacidade.api.security;

import lombok.Getter;

public enum UsuarioAcesso {

	ADMIN(1), USER(2), CAPACIDADE(338679), CONECTIVIDADE(451148), EXECUTIVO(338643), CONFIG(338643), CONECTIVIDADE_SP(451146);
	
    private UsuarioAcesso(Integer codi ) {
	   this.acesso = codi;
	}
    
    @Getter	
	private Integer acesso;
	
}
