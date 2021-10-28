package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Anotacoes lambok
@Data @Getter @Setter
@AllArgsConstructor @NoArgsConstructor 
//Anotacoes da JPA
@Entity
@Table(name="TB_PORTAL_HISTORICO_MENSAGENS")
public class DescricaoRTC implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ID_SEQ", sequenceName = "TB_PORTAL_HISTORICO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
	@Column(name="ID", nullable = false, length = 40 ,updatable = false)
    private Long id;
	
	@Column(name="DTE_COMENTARIO", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true, length = 40 ,updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	@OrderBy("dataComentario ASC")
    private Calendar dataComentario = Calendar.getInstance();
	
	@Column(name="COMENTARIO", nullable = false, length = 40 ,updatable = false)
    private String comentario;
	
	@Column(name="STATUS", nullable = false, length = 40 ,updatable = false)
    private String status;
	
	@Column(name="MATRICULA_CRIADOR", nullable = false, length = 40 ,updatable = false)
    private String  matriculaCriador;
	
	@OneToOne
	@JoinColumn(name="ID_RTC")
	private RecomendacaoTecnica rtc;
	
	
}
