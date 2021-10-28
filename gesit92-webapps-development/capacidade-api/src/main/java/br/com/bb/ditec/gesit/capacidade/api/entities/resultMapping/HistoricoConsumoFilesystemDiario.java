package br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class HistoricoConsumoFilesystemDiario {
	
	public static final String HISTORICO_DE_CONSUMO_DE_SERVIDOR_FILESISTEM_INFORMACAO_ULTIMOS_30_DIAS  = "SELECT  " + 
			"   T4.NM_SVDR_INFT AS nomeServidor, " +
			"   T1.NM_SIS_ARQ as filesystem, " +
			"   T1.DT_CLA_SIS_ARQ AS data, " + 
			"   TRUNC(T1.NR_AREA_TTL/1024,2) AS areaTotalGb," + 
			"   TRUNC(T1.NR_AREA_UTZD/1024,2) AS areaUtilizadaGb," +
			"   TRUNC(T1.NR_AREA_TTL*T3.PC_LIM_DCO/100/1024,2) AS thresholdGb, "+
			"   T3.PC_LIM_DCO AS thresholdPercentual "+
			"FROM       " + 
			"   ORAIIT.TAB_SIS_ARQ_FS_PART T1       " + 
			"   INNER JOIN TAB_SVDR_GR T2 ON T1.CD_SVDR=T2.CD_SVDR" +
			"   INNER JOIN TAB_GR T3 ON T2.CD_GR=T3.CD_GR"+
			"   INNER JOIN TAB_SVDR T4 ON T1.CD_SVDR=T4.CD_SVDR AND T4.IN_SVDR_IATV='A' "+
			"   WHERE T1.TIP_GR = 'D' and T4.NM_SVDR_INFT = :nomeServidor AND  T1.DT_CLA_SIS_ARQ > SYSDATE - :dias";

	private String nomeServidor;
	private String filesystem;
	private Date data;
	private Double areaTotalGb;
	private Double areaUtilizadaGb;
	private Double thresholdGb;
	private Double thresholdPercentual;
	
	
	
			
}
