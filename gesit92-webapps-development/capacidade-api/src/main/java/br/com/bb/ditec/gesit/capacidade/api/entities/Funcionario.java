package br.com.bb.ditec.gesit.capacidade.api.entities;

/**
 * @author Lucas.carvalho - C1279457
 * @since 14/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "V_FUNCI", schema = "ORAIIT")
@Data @NoArgsConstructor @AllArgsConstructor
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String AVATAR_HUMANOGRAMA = "http://humanograma.intranet.bb.com.br/avatar/";
	
	@Id
	@Column(name = "USER_ID", length = 140)
	@ApiModelProperty(notes = "Matrícula do Funcionário",required=true)
	private String matricula;

	@Column(name = "FULL_NAME", length = 140)
	@JsonProperty("nome")
	private String nomeCompleto;

	@Column(name = "CONTACT_PHONE", length = 80)
	private String telefone;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "TITLE", length = 140)
	private String funcao;

	@Column(name = "PORTABLE_PHONE", length = 140)
	private String celular;

	@Column(name = "COMPANY", length = 140)
	private String empresa;

	@Column(name = "BB_PREFIXO")
	private Integer prefixo;

	@Column(name = "BB_UOR_PREFIXO")
	@JsonProperty("uor")
	private Integer uorPrefixo;

	@Column(name = "BB_COD_DIVISAO")
	@JsonProperty("codigoDivisao")
	private Integer codigoDivisao;

	@Column(name = "BB_COD_EQUIPE")
	private Integer codigoEquipe;

	@Column(name = "BB_NOME_EQUIPE")
	private String nomeEquipe;
	
	@Transient
	private String avatar = AVATAR_HUMANOGRAMA;
	
	public String getAvatar() {
		return avatar + this.matricula;
	}

}
