package br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoConsumoMemoriaCpuMensal {
	
	public static final String HISTORICO_COM_CONSUMO_MENSAL_DE_CPU_E_MEMORIA_DO_SERVIDOR = " SELECT " 
	        + "T2.NM_SVDR_INFT AS NomeServidor , "
	        + "T1.QT_DSPN_CPU_LGC_LAST as totalCpu, "
	        + "TRUNC(T1.QT_DSPN_CPU_LGC_LAST * T1.PC_CPU_TTL_UTZD_MEDIA_5MAX/100,2) quantidadeCpuUtilizada, "
	        + "TRUNC(T1.QT_DSPN_CPU_LGC_LAST*T4.PC_LIM_CPU/100,2) AS thresholdCpuQuantitativo, "
	        + "T1.PC_CPU_TTL_UTZD_MEDIA_5MAX AS PercentualUsoCpu, "
	        + "T4.PC_LIM_CPU AS ThresholdCpuPercentual, " 
			+ "T1.QT_MB_MMR_FSCO/1024 AS TotalMemoriaGb, "
			+ "TRUNC(T1.QT_MB_MMR_FSCO * T1.PC_MMR_UTZD_TTL_MEDIA_5MAX/100/1024,2) AS MemoriaUtilizadaGb, "
			+ "T4.PC_LIM_MMR AS ThresholdMmrPercentual, "
			+ "T1.QT_MB_MMR_FSCO/1024 * T4.PC_LIM_MMR/100 AS thresholdMmrGb, "
			+ "T1.PC_MMR_UTZD_TTL_MEDIA_5MAX as PercentualUsoMmr, "
			+ "T1.DT_MDD as Data  "
		+ " FROM MDD_CPDD_HW_MES_PART T1 INNER JOIN TAB_SVDR T2 ON T1.CD_SVDR=T2.CD_SVDR AND T2.IN_SVDR_IATV='A' LEFT JOIN TAB_SVDR_GR T3 ON T1.CD_SVDR=T3.CD_SVDR LEFT JOIN TAB_GR T4 ON T4.CD_GR=T3.CD_GR WHERE T2.NM_SVDR_INFT= :nomeServidor ORDER BY T1.DT_MDD DESC";

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
