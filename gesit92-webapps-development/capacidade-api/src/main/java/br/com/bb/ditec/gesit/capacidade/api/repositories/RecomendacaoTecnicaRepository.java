package br.com.bb.ditec.gesit.capacidade.api.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.RecomendacaoTecnica;
import br.com.bb.ditec.gesit.capacidade.api.repositories.RecomendacaoTecnicaRepository;


@Repository
public interface RecomendacaoTecnicaRepository extends JpaRepository<RecomendacaoTecnica, Serializable> {

	static final String RECOMEN_TEC_GERAR_NUMERO_RTC = "CREATE SEQUENCE  ORAIIT.RECOMEN_TEC_GERAR_NUMERO_RTC  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE";
	
	@Query (nativeQuery=true, value="SELECT RECOMEN_TEC_GERAR_NUMERO_RTC.NEXTVAL FROM DUAL")
	Long buscarProximoNumeroRTC();
	
	@Query (nativeQuery=true, value=RecomendacaoTecnicaRepository.RECOMEN_TEC_GERAR_NUMERO_RTC)
	void createSequenceRecomendacaoTecnica();
}
