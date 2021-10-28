package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.bb.ditec.gesit.capacidade.api.enuns.STATUS_RECOMEN;
import br.com.bb.ditec.gesit.capacidade.api.utils.CapacidadeUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor 
@Table(name="TB_RECOMENDACAO_TECNICA")
public class RecomendacaoTecnica extends AbstractModel<Long> {

	private static final long serialVersionUID = 1L;
	
	@Column(name="MATRICULA_RESPONSAVEL", nullable = false, length = 40 ,updatable = true)
    private String matriculaResponsavel;

    @Column(name="NUM_RTC", nullable = false, length = 40,  updatable = false, unique=true)
	private String numeroRTC;
    
    @Column(name="MATRICULA_INTERVENIENTE", nullable = true, length = 40 , updatable = true)
	private String matriculaInterveniente;
    
    @Column(name="UOR_COD_EQUIPE", nullable = false, length = 40, updatable = true)
	private Integer codigoEquipe;
    
    @Column(name="NME_EQUIPE", nullable = false, length = 40, updatable = true)
	private String nomeEquipe;
    
    @Column(name="DTE_RESOLUCAO", nullable = true, length = 40)
    @Temporal(value = TemporalType.TIMESTAMP)
	private Calendar dataResolucao;
    
    @Column(name = "DTE_CADASTRO", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar dataCadastro;
    
    @Column(name="MATRICULA_CRIADOR", nullable = false, length = 40, updatable = false)
   	private   String  matriculaCriador ;
    
    @ManyToOne(cascade= CascadeType.PERSIST,fetch=FetchType.EAGER)
    @JoinColumn(name = "ID_STATUS", referencedColumnName = "ID", insertable = true, updatable = true)
    private StatusRecomendacaoTecnica statusRecomendacaoTecnica;
    

    @ManyToOne(cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name = "ID_NIVEL_CRITICIDADE", referencedColumnName = "ID", insertable = true, updatable = true)
    private NivelCriticidade nivelCriticidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID",insertable = true, updatable = false, nullable=true)
	private  DescricaoRTC descricaoRTC = new DescricaoRTC();
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name="ID_RTC", insertable = false, updatable = false, nullable=true)
	@OrderBy("id DESC")
	private List<DescricaoRTC> atividades;
	
	public boolean isEmAvaliacao() {
		return STATUS_RECOMEN.EM_AVALIACAO.getCodigo() == statusRecomendacaoTecnica.getId();
	}
	
	public boolean isEmAtendimento(){
		return STATUS_RECOMEN.EM_ATENDIMENTO.getCodigo() == statusRecomendacaoTecnica.getId();
	}
	
	public boolean isConcluido() {
		return STATUS_RECOMEN.CONCLUIDO.getCodigo() == statusRecomendacaoTecnica.getId();
	}
    public String getIdEncode() {
    	return CapacidadeUtils.encodeBase64(this.getId());
    }
    
    public DescricaoRTC getDescricaoRTC() {
    	if(null == descricaoRTC )  return new DescricaoRTC();
    	return descricaoRTC;
    }
    
}
