package br.com.bb.ditec.gesit.capacidade.api.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoDiscoMensal;




@Repository
@Transactional
public class HistoricoConsumoDiscoMensalRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
@SuppressWarnings("unchecked")
public List<HistoricoConsumoDiscoMensal> historicoConsumoDiscoMensal( String servidor) {
	
	final Session s  = em.unwrap(Session.class);
	 
	return s.createSQLQuery(HistoricoConsumoDiscoMensal.HISTORICO_COM_CONSUMO_MENSAL_DE_DISCO_DO_SERVIDOR)
	 .addScalar("nomeServidor" , StringType.INSTANCE )
	 .addScalar("data", DateType.INSTANCE)
	 .addScalar("areaTotalGb", DoubleType.INSTANCE )
	 .addScalar("areaUtilizadaGb" , DoubleType.INSTANCE)
	 .addScalar("thresholdPercentual", DoubleType.INSTANCE )
	 .addScalar("thresholdGb", DoubleType.INSTANCE )
	 	.setParameter("nomeServidor", servidor)
	 .setResultTransformer( Transformers.aliasToBean(HistoricoConsumoDiscoMensal.class)).list();

	}

}
