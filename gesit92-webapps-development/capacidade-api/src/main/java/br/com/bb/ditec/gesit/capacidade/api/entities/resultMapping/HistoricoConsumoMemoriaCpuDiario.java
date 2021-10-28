package br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class HistoricoConsumoMemoriaCpuDiario {
	
	public static final String HISTORICO_DE_CONSUMO_DE_CPU_E_MEMORIA_DOS_ULTIMOS_30_DIAS  = "SELECT "
				+ "SV.NM_SVDR_INFT AS nomeServidor, "
				+ "M1.QT_DSPN_CPU_LGC_LAST as totalCpu, "
				+ "TRUNC(QT_DSPN_CPU_LGC_LAST*M1.PC_CPU_TTL_UTZD_MAX/100,2) AS quantidadeCpuUtilizada, "
				+ "TRUNC(M1.QT_DSPN_CPU_LGC_LAST*GR.PC_LIM_CPU/100,2) AS thresholdCpuQuantitativo, "
				+ "M1.PC_CPU_TTL_UTZD_MAX AS percentualUsoCpu, "
				+ "GR.PC_LIM_CPU AS thresholdCpuPercentual, "
				+ "M1.QT_MB_MMR_FSCO/1024 AS totalMemoriaGb, "
				+ "TRUNC((M1.PC_MMR_UTZD_TTL_MAX *  M1.QT_MB_MMR_FSCO / 100 / 1024),2) AS memoriaUtilizadaGb, "
				+ "M1.QT_MB_MMR_FSCO/1024 * GR.PC_LIM_MMR/100 AS thresholdMmrGb, "
				+ "M1.PC_MMR_UTZD_TTL_MAX AS PercentualUsoMMR, "
				+ "GR.PC_LIM_MMR AS thresholdMmrPercentual, "				
				+ "M1.DT_MDD AS data "
				+ "FROM ORAIIT.MDD_CPDD_HW_DIA_PART M1 INNER JOIN TAB_SVDR SV ON M1.CD_SVDR=SV.CD_SVDR AND SV.IN_SVDR_IATV='A' INNER JOIN TAB_SVDR_GR SG ON M1.CD_SVDR=SG.CD_SVDR INNER JOIN TAB_GR GR ON SG.CD_GR=GR.CD_GR WHERE SV.NM_SVDR_INFT = :servidor AND  M1.DT_MDD > SYSDATE - :dias";

	
	private String nomeServidor;
	private Double totalCpu;
	private Double quantidadeCpuUtilizada;
	private Double thresholdCpuQuantitativo;
	private Double percentualUsoCpu;
	private Double thresholdCpuPercentual;
	private Double totalMemoriaGb;
	private Double memoriaUtilizadaGb;
	private Double thresholdMmrGb;
	private Double PercentualUsoMmr;
	private Double thresholdMmrPercentual;
	private Date data;
	
			
}
