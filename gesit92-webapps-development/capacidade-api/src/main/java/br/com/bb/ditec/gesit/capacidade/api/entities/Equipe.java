package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "TB_PORTAL_EQUIPES_GESIT", schema = "ORAIIT")
@Data @NoArgsConstructor @AllArgsConstructor
public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_UOR")
	private Integer codigoEquipe;

	@Column(name = "NM_UOR")
	private String nomeEquipe;
	
	@Column(name = "CD_DIV")
	private Integer codDivisao;
	
	@Column(name = "DIV")
	private String divisao;	

}
