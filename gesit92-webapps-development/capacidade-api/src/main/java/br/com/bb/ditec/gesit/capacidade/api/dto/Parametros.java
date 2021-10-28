package br.com.bb.ditec.gesit.capacidade.api.dto;

import br.com.bb.ditec.gesit.capacidade.api.utils.APIUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parametros {
	@ApiModelProperty(value = "Nome do servidor cujo histórico de consumo do recurso (cpu, memória, filesystem/disco) se deseja obter.", required=true)
	private String nomeServidor;
	@ApiModelProperty(value = "Nome do grupo/serviço cujo histórico de consumo do recurso (cpu, memória, filesystem/disco) se deseja obter.", required=false)
	private String nomeGrupo;
	@ApiModelProperty(value = "Quantidade de dias retroativos cujo histórico de consumo do recurso (cpu, memória, filesystem/disco) se deseja obter. Default=30", required=false)
    private Integer dias = APIUtils.ULTIMOS_30_DIAS ;
	
//   TDOD: impl
    //public int getDias() {
//		return  APIUtils.getDias(dias) ;
//	} 
   
   
	

}
