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
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoMemoriaCpuDiario;


@Repository
@Transactional
public class HistoricoConsumoMemoriaCpuDiarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
@SuppressWarnings("unchecked")
public List<HistoricoConsumoMemoriaCpuDiario> historicoConsumoNosUltimos30Dias( Parametros param) {
	
	final Session s  = em.unwrap(Session.class);
	 
	return s.createSQLQuery(HistoricoConsumoMemoriaCpuDiario.HISTORICO_DE_CONSUMO_DE_CPU_E_MEMORIA_DOS_ULTIMOS_30_DIAS)
		.addScalar("nomeServidor" , StringType.INSTANCE )
		.addScalar("data", DateType.INSTANCE)
		.addScalar("totalCpu", DoubleType.INSTANCE )
		.addScalar("totalMemoriaGb" , DoubleType.INSTANCE)
		.addScalar("percentualUsoCpu" , DoubleType.INSTANCE)
		.addScalar("percentualUsoMmr", DoubleType.INSTANCE )
		.addScalar("memoriaUtilizadaGb", DoubleType.INSTANCE )
		.addScalar("thresholdCpuPercentual", DoubleType.INSTANCE )
		.addScalar("thresholdMmrPercentual", DoubleType.INSTANCE )
		.addScalar("thresholdMmrGb", DoubleType.INSTANCE )
		.addScalar("quantidadeCpuUtilizada", DoubleType.INSTANCE )
		.setParameter("servidor", param.getNomeServidor() )
		.setParameter("dias", param.getDias() )
	 
		.setResultTransformer( Transformers.aliasToBean(HistoricoConsumoMemoriaCpuDiario.class)).list();

	}

}
