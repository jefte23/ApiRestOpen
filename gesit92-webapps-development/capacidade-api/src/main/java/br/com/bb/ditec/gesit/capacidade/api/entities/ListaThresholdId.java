package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class ListaThresholdId implements Serializable {

  private static final long serialVersionUID = 1L;
   
	private String  servico;

	private String grupo;
	
	private String servidor;

	@Column(name="RECURSO",columnDefinition="varchar(4)",length=4)
	private Character recurso;

	
	public ListaThresholdId() {
	}

	

}
