package br.com.bb.ditec.gesit.capacidade.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.StatusRecomendacaoTecnica;

/**
 * @author c1266003
 * */
@Repository
public interface StatusRecomendacaoTecnicaRepository extends JpaRepository<StatusRecomendacaoTecnica, Long> {

}
