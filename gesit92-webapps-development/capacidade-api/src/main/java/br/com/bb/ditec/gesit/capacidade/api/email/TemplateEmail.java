package br.com.bb.ditec.gesit.capacidade.api.email;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.bb.ditec.gesit.capacidade.api.entities.DescricaoRTC;
import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import br.com.bb.ditec.gesit.capacidade.api.entities.RecomendacaoTecnica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="TB_PORTAL_EMAIL")
@ToString
public class TemplateEmail {
    
	@Id
	@SequenceGenerator(name = "ID_SEQ", sequenceName = "TB_PORTAL_MAIL_ID_SEQ", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
	@Column(name="ID", nullable = false, length = 40 ,updatable = false)
	private Long id;
	
	@Column(name="ASSUNTO", nullable=false, updatable = false)
	private String assunto;
	
	@Column(name="MENSAGEM", nullable=false, updatable = false)
	private String messagem;
	
	@Column(name="ANEXO", nullable=true)  @Lob
	private byte [] anexo;
	
	@Column(name="DESTINATARIO", nullable=true)
	private String from;
	
	@Transient private List<String> emails = new ArrayList<>();
	@Transient private List<String> copias = new ArrayList<>();
	@Transient private RecomendacaoTecnica rtc;
	@Transient private Funcionario funci;
	@Transient private DescricaoRTC comentario;
	@Transient private String comentRtc;
	@Transient private String statusRtc;
	
}
