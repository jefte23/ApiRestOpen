package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter
@Entity @Table(name="V_APL_LST_THR")
@AllArgsConstructor @NoArgsConstructor
public class ListaThreshold implements Serializable {

  private static final long serialVersionUID = 1L;
   
    @EmbeddedId
  	private ListaThresholdId listaThresholdId;
  	
    @JsonFormat(shape = JsonFormat.Shape.NATURAL, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    @Column(name="ULTIMOCONSUMO")
	private Calendar ultimoCosumo;
    
    @JsonFormat(shape = JsonFormat.Shape.NATURAL, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    @Column(name="ULTIMAACAO")
	private Calendar ultimaAcao;
    
    @Column(name="RDI",nullable=true)
	private Character rdi; 
	
	@JsonFormat(shape = JsonFormat.Shape.NATURAL, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	
	@Column(name="RESOLUCAORDI")
	private Calendar resolucaoRdi;
	
	@Column(name="IDSERVICO",nullable=false)
	private Integer idServico; 

	@Column(name="IDGRUPO",nullable=false)
	private Integer idGrupo;
	
	@Column(name="IDSERVIDOR",nullable=false)
	private Integer idServidor; 

	
}




