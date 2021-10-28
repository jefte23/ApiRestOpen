package br.com.gesit.capacidade.mock;

import java.util.Arrays;

import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.BbIncidente;
import br.com.bb.ditec.gesit.capacidade.api.integration.gsti.json.RequestIncidente;


public class RequestIncidenteMock {
	public static RequestIncidente criarRequestIncidente() {
		return new RequestIncidente(BbIncidenteMock.getBbIncidente());
	}
}

class BbIncidenteMock {

	public static BbIncidente getBbIncidente() {

		BbIncidente bbIncidenteRquest = new BbIncidente();
			bbIncidenteRquest.setANO("geral");
			bbIncidenteRquest.setAmbiente("Produção");
			bbIncidenteRquest.setArea("Sistemas Operacionais");//TODO: dinamico
			bbIncidenteRquest.setSubarea("Alto consumo CPU/Memória");//TODO: dinamico
			bbIncidenteRquest.setCriador("F4684108");//TODO:sesseion
			bbIncidenteRquest.setCriadorEquipe("DITEC/UOS/GESIT/D9/E92-CAPACIDADE MF, HE E REDES");
			bbIncidenteRquest.setCriadorNome("JEFFERSON DE LIMA MACIE");
			bbIncidenteRquest.setCriadorTelefone("31046198");//TODO:sesseion
			bbIncidenteRquest.setDescricao(Arrays.asList("Tteste com spring framwork RDI"));////TODO: input
			bbIncidenteRquest.setEquipeSolucionadora("DITEC/UOS/GESIT/D3/E32-WEB INTRANET");//input
			//bbIncidente.setEquipeSolucionadoraUOR(288901);
			bbIncidenteRquest.setFerramentaMonitoracao("Operations");////TODO: dinamico
			bbIncidenteRquest.setGerenciaExecutivaUOR(20261);
			///bbIncidenteRquest.setIDIncidente("");
			bbIncidenteRquest.setImpacto("2");// 1 a 3
			bbIncidenteRquest.setInterface(Arrays.asList("266535"));
			bbIncidenteRquest.setPrioridade("3");
			bbIncidenteRquest.setServicoAfetado("266410");
			//bbIncidenteRquest.setServicoEstaOperacional(true);
			bbIncidenteRquest.setSolicitante("F4684108");
			bbIncidenteRquest.setSolicitanteCelular("81512171");
			bbIncidenteRquest.setSolicitanteCelularDDD("61");
			bbIncidenteRquest.setSolicitanteEmail("F4684108@bb.com.br");
			bbIncidenteRquest.setSolicitanteEquipe("DITEC/UOS/GESIT/D9/E92-CAPACIDADE MF, HE E REDES");
			bbIncidenteRquest.setSolicitanteTelefone("31046198");
			bbIncidenteRquest.setSolicitanteTelefoneDDD("61");
			//bbIncidenteRquest.setStatus("");
			//bbIncidenteRquest.setTipoAcionamento("Monitoração interna");
			bbIncidenteRquest.setTitulo("Capacidade teste com spring framwork !!");
			bbIncidenteRquest.setUrgencia("2");
		return bbIncidenteRquest;

	}
	
}
