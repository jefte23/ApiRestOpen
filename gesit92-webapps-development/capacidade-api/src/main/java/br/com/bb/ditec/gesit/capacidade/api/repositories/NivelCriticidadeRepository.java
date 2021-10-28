package br.com.bb.ditec.gesit.capacidade.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.NivelCriticidade;

@Repository
public interface NivelCriticidadeRepository extends JpaRepository<NivelCriticidade, Long> {

}
