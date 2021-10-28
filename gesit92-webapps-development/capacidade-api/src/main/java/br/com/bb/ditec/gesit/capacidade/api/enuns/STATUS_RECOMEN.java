package br.com.bb.ditec.gesit.capacidade.api.enuns;

public enum STATUS_RECOMEN {

	
	EMCAMINHADO(1L),EM_ATENDIMENTO(2L),EM_AVALIACAO(3L),PENDENTE(4L),CONCLUIDO(5L);
	private long codigo;
	
	private STATUS_RECOMEN(long cod) {
		this.codigo = cod;
	}
	
	public long getCodigo() {
		return codigo;
	}
}
