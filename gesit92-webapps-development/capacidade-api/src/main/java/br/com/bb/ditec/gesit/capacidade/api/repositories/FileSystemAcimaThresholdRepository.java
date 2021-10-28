package br.com.bb.ditec.gesit.capacidade.api.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Component;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.FilesystemAcimaThreshold;


@Component
public class FileSystemAcimaThresholdRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<FilesystemAcimaThreshold> buscarFileSystemComConsumoAcimaDoThresholdNosUltimos30Dias( Parametros param) {
		
		final Session s  = em.unwrap(Session.class);
		 
		return s.createSQLQuery(FilesystemAcimaThreshold.FILESISTEM_COM_CONSUMO_ACIMA_DO_THRESHOLD_NOS_ULTIMOS_30_DIAS)
	    
		 .addScalar("fileSystem", StringType.INSTANCE)
		 .addScalar("dispositivo", StringType.INSTANCE)
		 .addScalar("areaTotalGb", BigDecimalType.INSTANCE)
		 .addScalar("areaUtilizadaGb", DoubleType.INSTANCE)
		 .addScalar("threshold", IntegerType.INSTANCE)
		 .addScalar("pcUtilizada", DoubleType.INSTANCE)
		 .addScalar("data", DateType.INSTANCE)
		 .addScalar("nomeServidor", StringType.INSTANCE)
			 .setParameter("nomeServidor", param.getNomeServidor() )
			 .setParameter("nomeGrupo", param.getNomeGrupo() )
			 .setParameter("dias", param.getDias() )
		 .setResultTransformer( Transformers.aliasToBean(FilesystemAcimaThreshold.class)).list();

	}

}
