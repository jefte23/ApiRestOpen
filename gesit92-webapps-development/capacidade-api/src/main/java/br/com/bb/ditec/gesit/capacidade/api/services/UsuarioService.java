package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import br.com.bb.ditec.gesit.capacidade.api.repositories.FuncionarioRepository;

@Service
public class UsuarioService  {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario getFuncionarioByChave(String chave){
		try {
			if(chave == null )  return null;
			return  this.funcionarioRepository.findOne( chave.toUpperCase() );
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Funcionario não localizado! :" + chave);
		}

	}
	
	public List<String> getEmails(Integer cod){
		try {
			if(cod == null )  return null;
			return  this.funcionarioRepository.emailFuncionariosByCodiEquipe(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Funcionario getUser(String chaveUsuario) {
		return funcionarioRepository.getUsuario(chaveUsuario);
	}
	
	public Integer getCodigoEquipe(String chaveUsuario) {
		return getUser(chaveUsuario).getCodigoEquipe();
	}
	public String getMatricula(String chaveUsuario) {
		return getUser(chaveUsuario).getMatricula();
	}
	
	public Integer getPrefixo(String chaveUsuario) {
		return getUser(chaveUsuario).getPrefixo();
	}
	
	public String getDivisaoGesit(String chave) {
		return funcionarioRepository.divFuncionarioGesit(chave);
	}
	
	public String getDivisaoGesat(String chave) {
		return funcionarioRepository.divFuncionarioGesat(chave);
	}
	
	public String getDivisaoGesitbyName(String nomeEquipeInterveniente, int bbPrefixo) {
		return funcionarioRepository.divGesit(nomeEquipeInterveniente, bbPrefixo);
	}
	
	public String getDivisaoGesatbyName(String nomeEquipeInterveniente, int bbPrefixo) {
		return funcionarioRepository.divGesat(nomeEquipeInterveniente, bbPrefixo);
	}
	
	public int getPrefixoInterveniente(int codigoEquipe) {
		return funcionarioRepository.getCodigoEquipe(codigoEquipe);
	}
	
	public int getPrefixoIntervenienteGetByName(String nomeEquipe) {
		return funcionarioRepository.getCodigoEquipeByName(nomeEquipe);
	}
	
	public List<String> getEmailsGerenteGesit(String div, int bbPrefixo) {
		try {
			return funcionarioRepository.emailGerDivGesit(div, bbPrefixo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getEmailsGerenteGesat(String div, int bbPrefixo) {
		try {
			return funcionarioRepository.emailGerDivGesat(div, bbPrefixo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  
	public List<String> findByUsers(){
		return funcionarioRepository.getAllUsers();
	}
	
	public List<String> findByEquips(){
		return funcionarioRepository.getAllEquipes();
	}
}
