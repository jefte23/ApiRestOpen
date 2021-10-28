package br.com.bb.ditec.gesit.capacidade.api.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Serializable> {

	@Query( value ="SELECT f.email FROM Funcionario f WHERE SUBSTR(TRIM(matricula), 1, 1) = 'F' and f.codigoEquipe = ?1")
	List<String> emailFuncionariosByCodiEquipe(Integer cod);
	
	@Query(nativeQuery=true, value = "select distinct(BB_PREFIXO) from V_FUNCI where BB_COD_EQUIPE = ?1")
	int getCodigoEquipe(int codigoEquipe);
	
	@Query(nativeQuery=true, value = "select replace(SUBSTR(BB_NOME_EQUIPE,13,3),'/', '') as DIV from V_FUNCI where USER_ID = ?1")
	String divFuncionarioGesit(String chave);
	
	@Query(nativeQuery=true, value = "select replace(SUBSTR(BB_NOME_EQUIPE,17,2),'/', '') as DIV from V_FUNCI where USER_ID = ?1")
	String divFuncionarioGesat(String chave);
	
	@Query(nativeQuery=true, value = "SELECT Distinct(replace(SUBSTR(BB_NOME_EQUIPE,13,3),'/', '')) FROM V_FUNCI WHERE trim(BB_NOME_EQUIPE) = ?1 and BB_PREFIXO = ?2")
	String divGesit(String nomeEquipeInterveniente, int bbPrefixo);
	
	@Query(nativeQuery=true, value = "SELECT Distinct(replace(SUBSTR(BB_NOME_EQUIPE,17,2),'/', '')) FROM V_FUNCI WHERE trim(BB_NOME_EQUIPE) =?1 and BB_PREFIXO = ?2")
	String divGesat(String nomeEquipeInterveniente, int bbPrefixo);
	
	
	@Query(nativeQuery=true, value = "select EMAIL from V_FUNCI where trim(replace(SUBSTR(BB_NOME_EQUIPE,13,3),'/', '')) = ?1 and BB_PREFIXO = ?2 and trim(TITLE) = 'GER SOLUCOES UE'")
	List<String> emailGerDivGesit(String div, int bbPrefixo );
	
	@Query(nativeQuery=true, value = "select EMAIL from V_FUNCI where trim(replace(SUBSTR(BB_NOME_EQUIPE,17,2),'/', '')) = ?1 and BB_PREFIXO = ?2 and trim(TITLE) = 'GER SOLUCOES UE'")
	List<String> emailGerDivGesat(String div, int bbPrefixo );

	@Query(nativeQuery=true, value = "SELECT distinct(BB_PREFIXO) FROM V_FUNCI WHERE trim(BB_NOME_EQUIPE) = ?1")
	int getCodigoEquipeByName(String nameEquipe);
	
	@Query(nativeQuery=true, value = "select distinct CONCAT(CONCAT(USER_ID, ' - '), FULL_NAME) as users from V_FUNCI")
	List<String> getAllUsers();
	
	@Query(nativeQuery=true, value = "select distinct BB_NOME_EQUIPE from V_FUNCI")
	List<String> getAllEquipes();
	
	@Query ( nativeQuery=true, value="select * from V_FUNCI where USER_ID = ?1")
	Funcionario getUsuario(String chaveUsuario);
	
	
	
}
