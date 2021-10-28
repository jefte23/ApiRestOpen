package br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping;

import java.math.BigDecimal;
import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Filesystem com consumo acima do Threshold")
public class FilesystemAcimaThreshold {
	
	
	public static final String FILESISTEM_COM_CONSUMO_ACIMA_DO_THRESHOLD_NOS_ULTIMOS_30_DIAS = " SELECT " 
			+ "SAD.NM_SIS_ARQ AS fileSystem,  "
			+ "SAD.NM_DSVO_SIS_ARQ AS dispositivo, "
			+ "TRUNC(SAD.NR_AREA_TTL/1024,2) AS areaTotalGb, "
			+ "TRUNC(SAD.NR_AREA_UTZD/1024,2) AS areaUtilizadaGb, "
			+ "GR.PC_LIM_DCO AS threshold, "
			+ "TRUNC((SAD.NR_AREA_UTZD*100)/SAD.NR_AREA_TTL,2) AS pcUtilizada, "
			+ "SAD.DT_CLA_SIS_ARQ AS data, "
			+ "SV.NM_SVDR_INFT AS nomeServidor "
		+ " FROM TAB_SIS_ARQ_FS_PART SAD INNER JOIN TAB_SVDR SV ON SV.CD_SVDR=SAD.CD_SVDR AND SV.IN_SVDR_IATV='A' INNER JOIN TAB_SVDR_GR SG ON SAD.CD_SVDR = SG.CD_SVDR INNER JOIN TAB_GR GR ON SG.CD_GR = GR.CD_GR WHERE  SV.NM_SVDR_INFT = :nomeServidor AND GR.NM_GR = :nomeGrupo  AND SAD.TIP_GR='M' AND SAD.DT_CLA_SIS_ARQ > SYSDATE - :dias  AND (SAD.NR_AREA_UTZD*100)/SAD.NR_AREA_TTL> GR.PC_LIM_DCO ORDER BY SAD.DT_CLA_SIS_ARQ DESC";
	
	@ApiModelProperty(dataType ="String", notes = "nome do filesystem",required=false)
	private String fileSystem;
	@ApiModelProperty(dataType ="String", notes = "Ponto de Montagem (Mount Point) onde o filesystem foi montado",required=false)
	private String dispositivo;
	@ApiModelProperty(dataType ="Double", notes = "Área Total Alocada para o filesystem, em gigabyte",required=false)
	private BigDecimal areaTotal;
	@ApiModelProperty(dataType ="Double", notes = "Área utilizada do filesystem, em gigabyte",required=false)
	private Double areaUtilizada;
	@ApiModelProperty(dataType ="Integer", notes = "Limite, em percentual, utilizado para alertar a proximidade do consumo total do recurso",required=false)
	private Integer threshold;
	@ApiModelProperty(dataType ="Double", notes = "Percentual de utilização do filesystem",required=false)
	private Double pcUtilizada;
	@ApiModelProperty(dataType ="Date", notes = "Data do consumo do recurso,",required=false)
	private Date data;
	@ApiModelProperty(dataType ="Date", notes = "Nome do servidor,",required=true)
	private String nomeServidor;
			
}
