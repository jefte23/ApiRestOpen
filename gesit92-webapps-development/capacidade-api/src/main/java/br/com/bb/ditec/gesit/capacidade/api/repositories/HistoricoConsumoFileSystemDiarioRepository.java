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

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoFilesystemDiario;


@Repository
@Transactional
public class HistoricoConsumoFileSystemDiarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
@SuppressWarnings("unchecked")
public List<HistoricoConsumoFilesystemDiario> historicoConsumoServidorFileSistemDosUtimos30dias(  Parametros param   ) {
	
	final Session s  = em.unwrap(Session.class);
	 
	return s.createSQLQuery( HistoricoConsumoFilesystemDiario.HISTORICO_DE_CONSUMO_DE_SERVIDOR_FILESISTEM_INFORMACAO_ULTIMOS_30_DIAS )
	 .addScalar("nomeServidor", StringType.INSTANCE)
	 .addScalar("filesystem", StringType.INSTANCE)
	 .addScalar("data", DateType.INSTANCE)
	 .addScalar("areaTotalGb", DoubleType.INSTANCE )
	 .addScalar("areaUtilizadaGb", DoubleType.INSTANCE )
	 .addScalar("thresholdGb", DoubleType.INSTANCE )
	 .addScalar("thresholdPercentual", DoubleType.INSTANCE )
		 .setParameter("nomeServidor", param.getNomeServidor() )
		 .setParameter("dias", param.getDias() )
	 .setResultTransformer( Transformers.aliasToBean( HistoricoConsumoFilesystemDiario.class)).list();

	}

}
