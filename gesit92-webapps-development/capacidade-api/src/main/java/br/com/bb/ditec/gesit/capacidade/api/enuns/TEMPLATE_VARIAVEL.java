package br.com.bb.ditec.gesit.capacidade.api.enuns;

import lombok.Getter;

public enum TEMPLATE_VARIAVEL {

	CHAVE_RESP("{respChave}"), NOME_RESP("{respNome}"), NUMERO_RTC("{rtcNumero}"), DATA("{data}"), DATA_HORA("{dataHora}"), RTC_STATUS("{rtcStatus}"), RTC_COMENTARIO("{rtcComentario}");

	@Getter private String nome;
	
	private TEMPLATE_VARIAVEL(String nome) {
		this.nome = nome;
	}
	

}
