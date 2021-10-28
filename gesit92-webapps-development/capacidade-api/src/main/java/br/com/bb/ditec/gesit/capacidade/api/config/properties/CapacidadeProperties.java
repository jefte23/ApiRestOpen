package br.com.bb.ditec.gesit.capacidade.api.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 12/042018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 *        Configuração de propriedades da aplicação.
 */

@ConfigurationProperties("capacidade")
@Component
public class CapacidadeProperties {

	private final Servidor servidor = new Servidor();
	private final CorsFilter corsFilter = new CorsFilter();

	public Servidor getServidor() {
		return servidor;
	}

	@JsonProperty("cors")
	public CorsFilter getCorsFilter() {
		return corsFilter;
	}

	public static class CorsFilter {

		private String originPermitida;

		public String getOriginPermitida() {
			return originPermitida;
		}

		public void setOriginPermitida(String originPermitida) {
			this.originPermitida = originPermitida;
		}

	}

	public static class Servidor {

		@JsonProperty("producao")
		private boolean emProducao;

		public boolean isEmProducao() {
			return emProducao;
		}

		public void setEmProducao(boolean emProducao) {
			this.emProducao = emProducao;
		}

	}

	@Override
	public String toString() {
		return "Produção: " + this.servidor.emProducao + ", Origin :" + this.corsFilter.originPermitida;
	}

}
