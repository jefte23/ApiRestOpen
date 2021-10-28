package br.com.bb.ditec.gesit.capacidade.api.entities;


import java.util.Date;

/**
 * @author Lucas.carvalho - C1279457
 * @since 14/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TAB_CMTR_GR")
@Data @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ComentarioGrupo {
	
	@Id
    @Column(name="CD_GR")
	private Integer id;
	
	@Column(name="CD_TIP_RCS")
	private Integer codigoTipoRecurso;
	
	@Column(name="TX_CMTR")
	private String texto;
	
	@Column(name="NM_RDI",columnDefinition = "char")
	private String rdi;
	
	@Column(name="NM_RDP")
	private String rdp;
	
	@Column(name="DT_CMTR")
	private Date dataComentario;
	
	@Column(name="DT_INCL")
	//@Temporal(TemporalType.DATE)
	private Date dataInclusao;
	

	


}
