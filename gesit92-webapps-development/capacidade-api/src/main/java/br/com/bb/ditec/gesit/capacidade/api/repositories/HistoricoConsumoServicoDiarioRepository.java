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
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.HistoricoConsumoServicoDiario;


@Repository
@Transactional
public class HistoricoConsumoServicoDiarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
@SuppressWarnings("unchecked")
public List<HistoricoConsumoServicoDiario> historicoConsumoNosUltimos30Dias( Parametros param) {
	
	final Session s  = em.unwrap(Session.class);
	 
	return s.createSQLQuery(HistoricoConsumoServicoDiario.HISTORICO_COM_CONSUMO_DO_SERVICO_NOS_ULTIMOS_30_DIAS)
		.addScalar("nomeServico" , StringType.INSTANCE )
		.addScalar("nomeGrupo" , StringType.INSTANCE )
		.addScalar("data", DateType.INSTANCE)
		.addScalar("totalCpuFisico", DoubleType.INSTANCE )
		.addScalar("thresholdCpuPercentual" , DoubleType.INSTANCE)
		.addScalar("percentualUsoCpu" , DoubleType.INSTANCE)
		.addScalar("totalCpuLogico", DoubleType.INSTANCE )
		.addScalar("quantidadeCpuUtilizada", DoubleType.INSTANCE )
		.addScalar("thresholdCpuQuantitativo", DoubleType.INSTANCE )
		.addScalar("totalMemoriaGb", DoubleType.INSTANCE )
		.addScalar("memoriaUtilizadaGb", DoubleType.INSTANCE )
		.addScalar("thresholdMmrGb", DoubleType.INSTANCE )
		.addScalar("thresholdMmrPercentual", DoubleType.INSTANCE )
		.addScalar("PercentualUsoMmr", DoubleType.INSTANCE )
		.addScalar("areaTotalGb", DoubleType.INSTANCE )
		.addScalar("areaUtilizadaGb", DoubleType.INSTANCE )
		.addScalar("thresholdDiscoGb", DoubleType.INSTANCE )
		.addScalar("percentualUsoDisco", DoubleType.INSTANCE )
		.addScalar("thresholdDiscoPercentual", DoubleType.INSTANCE )
		.setParameter("nomeGrupo", param.getNomeGrupo() )
		.setParameter("dias", param.getDias() )
	 
		.setResultTransformer( Transformers.aliasToBean(HistoricoConsumoServicoDiario.class)).list();

	}

}
