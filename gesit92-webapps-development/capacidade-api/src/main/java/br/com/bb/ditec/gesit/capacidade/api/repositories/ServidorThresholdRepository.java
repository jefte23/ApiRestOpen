package br.com.bb.ditec.gesit.capacidade.api.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.ListaThreshold;

@Repository
public interface ServidorThresholdRepository extends JpaRepository<ListaThreshold, Serializable>  {
	

}


