package br.com.bb.ditec.gesit.capacidade.api.enuns;

import lombok.Getter;

public enum TEMPLATE_EMAIL {

	TEMPLATE_ABRIR_EMAIL_RTC(1L), TEMPLATE_NOVA_ETAPA_RTC(2L);

	@Getter private Long id;

	private TEMPLATE_EMAIL(Long id) {
		this.id = id;
	}

}
