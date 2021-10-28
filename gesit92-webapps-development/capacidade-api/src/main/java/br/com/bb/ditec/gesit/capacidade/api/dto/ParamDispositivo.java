package br.com.bb.ditec.gesit.capacidade.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bb.ditec.gesit.capacidade.api.utils.APIUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Historico-Consumo-Filesystem-Diario-Resource - Parâmetros")
@Deprecated
public class ParamDispositivo {
	@ApiModelProperty(value = "Nome do servidor cujo histórico de consumo de filesystem se deseja obter.", required=true)
	private String nomeServidor;
	//@ApiModelProperty(value = "Nome do grupo/serviço cujo histórico de consumo de filesystem se deseja obter.", required=false)
	
	//TODO: atributo a ser removido
	@JsonIgnore
	private String nomeGrupo;
	@ApiModelProperty(value = "Quantidade de dias retroativos cujo histórico de consumo de filesystem se deseja obter. Default=30", required=false)
    private Integer dias = APIUtils.ULTIMOS_30_DIAS ;

}
