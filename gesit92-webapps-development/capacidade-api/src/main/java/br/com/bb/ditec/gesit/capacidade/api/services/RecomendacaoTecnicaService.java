package br.com.bb.ditec.gesit.capacidade.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.entities.RecomendacaoTecnica;
import br.com.bb.ditec.gesit.capacidade.api.repositories.DescricaoRTCRepository;
import br.com.bb.ditec.gesit.capacidade.api.repositories.EquipeRepository;
import br.com.bb.ditec.gesit.capacidade.api.repositories.RecomendacaoTecnicaRepository;
import br.com.bb.ditec.gesit.capacidade.api.utils.CapacidadeUtils;

@Service
public class RecomendacaoTecnicaService {

	@Autowired
    private EquipeRepository equipeRepository;

	@Autowired
    private RecomendacaoTecnicaRepository recomentacaotecnicaRepository;
	
	@Autowired
	private DescricaoRTCRepository descricaoRTCRepository;
    
	public String gerarNumeroRecomendacaoTecnica() {
		return CapacidadeUtils.gerarNumeroRecomendacaoTecnica(recomentacaotecnicaRepository.buscarProximoNumeroRTC());
	}

	public EquipeRepository getEquipeRepository() {
		return equipeRepository;
	}

	public DescricaoRTCRepository getDescricaoRTCRepository() {
		return descricaoRTCRepository;
	}

	public RecomendacaoTecnicaRepository getRecomendacaoTecnicaRepository() {
		return recomentacaotecnicaRepository;
	}

	public RecomendacaoTecnica save(RecomendacaoTecnica rtc) {
		// TODO Auto-generated method stub
		return recomentacaotecnicaRepository.save(rtc);
	}
}
