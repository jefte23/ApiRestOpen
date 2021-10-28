package br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 14/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class  BbIncidente {
	
	private String ANO;
	private String Ambiente;
	private String Area;
	private String Criador;
	private String CriadorEquipe;
	private String CriadorNome;
	private String CriadorTelefone;
	private List<String> Descricao;
	private String EquipeSolucionadora;
	private Integer EquipeSolucionadoraUOR;
	private String FerramentaMonitoracao;
	private Integer GerenciaExecutivaUOR;
	private String IDIncidente;
	private String Impacto;
	private List<String> Interface;
	private String Prioridade;
	private String ServicoAfetado;
	private boolean ServicoEstaOperacional;
	private String Solicitante;
	private String SolicitanteCelular;
	private String SolicitanteCelularDDD;
	private String SolicitanteEmail;
	private String SolicitanteEquipe;
	private String SolicitanteTelefone;
	private String SolicitanteTelefoneDDD;
	private String Status;
	private String Subarea;
	private String TipoAcionamento;
	private String Titulo;
	private String Urgencia;

	
	
	

	
}


