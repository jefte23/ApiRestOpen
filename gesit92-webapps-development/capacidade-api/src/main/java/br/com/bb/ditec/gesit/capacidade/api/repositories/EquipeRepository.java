package br.com.bb.ditec.gesit.capacidade.api.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities. Equipe;


@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Serializable> {
 

	/*Consulta do DB2 para carga na tabela do ORACLE - select CD_UOR, NM_UOR from DB2DTM.DIM_UOR where NM_UOR_RDZ like '%GESIT%';*/
	/*@Query (nativeQuery=true, value= "select distinct(bb_cod_equipe), bb_nome_equipe from v_funci where bb_uor_prefixo = '20261' and bb_nome_equipe IS NOT NULL Order By bb_nome_equipe")*/
	@Query (nativeQuery=true, value= "select * from TB_PORTAL_EQUIPES_GESIT order by NM_UOR")
	List<Equipe> listarEquipesGesit();
	

	/*@Query (nativeQuery=true, value= "select distinct bb_cod_equipe, bb_nome_equipe from v_funci where bb_uor_prefixo = '20261' and bb_cod_equipe = ? and  bb_nome_equipe IS NOT NULL Order By bb_nome_equipe")*/
	@Query (nativeQuery=true, value= "select * from TB_PORTAL_EQUIPES_GESIT where CD_UOR = ? Order By NM_UOR")
    Equipe buscarEquipe( Integer para);
	
	@Query (nativeQuery=true, value= "select CD_DIV from TB_PORTAL_EQUIPES_GESIT where CD_UOR = ?")
    int getCodDiv( Integer para);
	

	@Query (nativeQuery=true, value= "select DIV from TB_PORTAL_EQUIPES_GESIT where CD_UOR = ?")
    String getDiv( Integer para);
	
	
	
}
