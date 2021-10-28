package br.com.bb.ditec.gesit.capacidade.api.repositories;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Component;

import br.com.bb.ditec.gesit.capacidade.api.entities.Anomalia;

@Component
public class AnomaliaQueryRepository {

	public  static final String QUERY = " SELECT data_mvt as data_mvt , sg_dd_smn as sg_dd_smn , mes as  mes, rptclass as rptclass ,hrcsmespend as hrcsmespend "
			+ " FROM tb_anomalia WHERE  EXTRACT(month FROM DATA_MVT) = EXTRACT(month FROM sysdate) FETCH FIRST 50 ROWS ONLY  ";
 
	public AnomaliaQueryRepository() {
	}
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	public Query findAll(){
		Session s  = em.unwrap(Session.class);			
	return s.createSQLQuery(QUERY)
	 .addScalar("data_mvt" , DateType.INSTANCE )
	 .addScalar("sg_dd_smn", StringType.INSTANCE)
	 .addScalar("mes", StringType.INSTANCE )
	 .addScalar("rptclass" , StringType.INSTANCE)
	 //.addScalar(" msuatu", DoubleType.INSTANCE )
	 .addScalar("hrcsmespend", DateType.INSTANCE )
	 .setResultTransformer( Transformers.aliasToBean(Anomalia.class));

	}
}
