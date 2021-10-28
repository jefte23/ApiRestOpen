package br.com.bb.ditec.gesit.capacidade.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data @Getter @Setter
@AllArgsConstructor @NoArgsConstructor 
@ToString @EqualsAndHashCode(callSuper=false)
@Table(name="TB_STATUS_REC_TECNICA")
public class StatusRecomendacaoTecnica{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    
	@Column(name="NME_STATUS", nullable = false, length = 40)
	private String nomeStatus;
    	 
}
