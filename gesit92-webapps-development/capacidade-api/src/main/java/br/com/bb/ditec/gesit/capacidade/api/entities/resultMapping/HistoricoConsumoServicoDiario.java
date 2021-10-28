package br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoConsumoServicoDiario {
	
	public static final String HISTORICO_COM_CONSUMO_DO_SERVICO_NOS_ULTIMOS_30_DIAS = " SELECT " 
		       + "SV.NM_SRVC AS nomeServico, "
		       + "GR.NM_GR AS nomeGrupo, "
		       + "CS.DT_CSM_GR AS Data, "
		       + "CS.QT_CPU_FSCO AS totalCpuFisico, "
		       + "CS.LIM_PC_CPU AS thresholdCpuPercentual, "
		       + "CS.NR_PC_CPU AS percentualUsoCpu, "
		       + "CS.QT_CPU AS totalCpuLogico, "
		       + "ROUND((CS.NR_PC_CPU * CS.QT_CPU/100),2) AS quantidadeCpuUtilizada, "
		       + "ROUND((CS.LIM_PC_CPU * CS.QT_CPU/100),2) AS thresholdCpuQuantitativo, "
		       + "ROUND((CS.NR_MB_MMR_FSCO_TTL/1024),2) AS totalMemoriaGb, "
		       + "ROUND((CS.NR_MB_MMR_FSCO_UTZD/1024),2) AS memoriaUtilizadaGb, "
		       + "ROUND((CS.LIM_MMR/1024),2) AS thresholdMmrGb, "
		       + "ROUND(CS.LIM_MMR*100/CS.NR_MB_MMR_FSCO_TTL) AS thresholdMmrPercentual, "
		       + "ROUND((CS.NR_MB_MMR_FSCO_UTZD*100)/CS.NR_MB_MMR_FSCO_TTL,2) AS percentualUsoMmr, "
		       + "ROUND((CS.NR_AREA_TTL/1024),2) AS areaTotalGb, "
		       + "ROUND((CS.NR_AREA_UTZD/1024),2) AS areaUtilizadaGb, "
		       + "ROUND((CS.LIM_DCO/1024),2) AS thresholdDiscoGb, "
			   + "ROUND((CS.NR_AREA_UTZD * 100)/ CS.NR_AREA_TTL,2) AS percentualUsoDisco, "
		       + "ROUND((CS.LIM_DCO * 100)/ CS.NR_AREA_TTL,2) AS thresholdDiscoPercentual "
		+ " FROM TAB_CSM_GR CS INNER JOIN TAB_GR GR ON CS.CD_GR=GR.CD_GR INNER JOIN TAB_GR_SRVC GS ON GR.CD_GR=GS.CD_GR INNER JOIN TAB_SRVC SV ON SV.CD_SRVC=GS.CD_SRVC WHERE CS.TIP_GR ='D' AND GR.NM_GR = :nomeGrupo AND  CS.DT_CSM_GR > SYSDATE - :dias ORDER BY  CS.DT_CSM_GR DESC";

	private String nomeServico;
	private String nomeGrupo;
	private Date   data;
	private Double totalCpuFisico;
	private Double thresholdCpuPercentual;
	private Double percentualUsoCpu;
	private Double totalCpuLogico;
	private Double quantidadeCpuUtilizada;
	private Double thresholdCpuQuantitativo;
	private Double totalMemoriaGb;
	private Double memoriaUtilizadaGb;
	private Double thresholdMmrGb;
	private Double thresholdMmrPercentual;
	private Double PercentualUsoMmr;
	private Double areaTotalGb;
	private Double areaUtilizadaGb;
	private Double thresholdDiscoGb;
	private Double percentualUsoDisco;
	private Double thresholdDiscoPercentual;
	
}
