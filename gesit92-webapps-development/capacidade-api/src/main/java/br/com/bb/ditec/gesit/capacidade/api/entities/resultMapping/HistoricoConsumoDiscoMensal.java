package br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoConsumoDiscoMensal {
	
	public static final String HISTORICO_COM_CONSUMO_MENSAL_DE_DISCO_DO_SERVIDOR = " SELECT " 
	        + "T2.NM_SVDR_INFT AS nomeServidor, "
			+ "TRUNC(T1.DT_CLA_SIS_ARQ,'month') AS data,  "
			+ "TRUNC(T1.NR_AREA_TTL/1024,2) areaTotalGb, "
			+ "TRUNC(T1.NR_AREA_UTZD/1024,2) as areaUtilizadaGb,"
			+ "T4.PC_LIM_DCO AS thresholdPercentual,"
			+ "TRUNC((T1.NR_AREA_TTL * T4.PC_LIM_DCO)/100/1024,2) AS thresholdGb"
		+ " FROM ORAIIT.TAB_SIS_ARQ_SVDR_PART T1 INNER JOIN TAB_SVDR T2 ON T1.CD_SVDR=T2.CD_SVDR AND T2.IN_SVDR_IATV='A' LEFT JOIN TAB_SVDR_GR T3 ON T1.CD_SVDR=T3.CD_SVDR LEFT JOIN TAB_GR T4 ON T4.CD_GR=T3.CD_GR WHERE T1.TIP_GR='M' AND T2.NM_SVDR_INFT= :nomeServidor ORDER BY T1.DT_CLA_SIS_ARQ DESC";

	private String nomeServidor;
	private Date data;
	private Double areaTotalGb;
	private Double areaUtilizadaGb;
	private Double thresholdPercentual;
	private Double thresholdGb;
	
}
