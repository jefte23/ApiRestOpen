package br.com.bb.ditec.gesit.capacidade.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.Anomalia;

/**
 * @author Lucas.carvalho - C1279457
 * @author F4684108
 * @since 14/05/2018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */
@Repository
public interface AnomaliaRepository extends JpaRepository<Anomalia, Integer> {
	

}
