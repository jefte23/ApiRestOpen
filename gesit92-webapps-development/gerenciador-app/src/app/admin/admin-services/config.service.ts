import { Injectable, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

import { Configuracao } from './../admin-model/app.config';
import { ConfiguracaoEnum } from '../admin-enum/config.enum';


@Injectable()
export class ConfigService {

  //private  CHAVE_FUNCI_LOCAL = "C1279457"; // CONTRATADO
  //private  CHAVE_FUNCI_LOCAL = "F8365923"; // GERENTE TI
  //private  CHAVE_FUNCI_LOCAL = "C1279457"; // ANALISTA TI
   //private  CHAVE_FUNCI_LOCAL = "C1266003"

  private configuracao = new Configuracao();
  ConfiguracaoEnum: any;


  constructor( private cookieService: CookieService ) {

    this.configuracao.producao = true;
    this.configuracao.urlBase = ( this.configuracao.producao ) ? ConfiguracaoEnum.URL_BASE_PROD : ConfiguracaoEnum.URL_BASE_DESENV;
    this.configuracao.matriculaFuncionarioLogado = this.getMatriculaFuncionarioLogado();
    /*
    if (this.configuracao.matriculaFuncionarioLogado == null || this.configuracao.matriculaFuncionarioLogado == ''){
      window.location.href = 'https://capacidade.servicos.bb.com.br:8443/';
      //console.log('USUARIO VAZIO');
    }
    */
    console.log("Config chave "+ this.configuracao.matriculaFuncionarioLogado +", Config Producao :"+ this.configuracao.producao +",  Config url URL :"+ this.configuracao.urlBase );
   }
 

  public getUrl(param : string):string{
    return this.configuracao.urlBase + param;
  }

  public  getAvatar(): string{ 
    let urlAvatar = ConfiguracaoEnum.URL_AVATAR_HUMANOGRAMA + this.configuracao.matriculaFuncionarioLogado ;
    return urlAvatar;
 }

  public setCookie(): void{ 
   //this.cookieService.set(ConfiguracaoEnum.COOKIE_NAME, this.CHAVE_FUNCI_LOCAL);
   this.cookieService.set(ConfiguracaoEnum.COOKIE_NAME, this.getMatriculaFuncionarioLogado() );
  }

  public getMatriculaFuncionarioLogado() {
    return this.getCookie();
  }

  public ahMatricula() {
    return this.cookieService.check( ConfiguracaoEnum.COOKIE_NAME );
  }

  /** TODO:-- Pegar a chave do funcionario no Cookie*/
  private getCookie(){ 
     // return (this.configuracao.producao ) ? this.cookieService.get( ConfiguracaoEnum.COOKIE_NAME).toLocaleUpperCase() : this.CHAVE_FUNCI_LOCAL.toLocaleUpperCase() ;
     return (this.configuracao.producao ) ? this.cookieService.get( ConfiguracaoEnum.COOKIE_NAME).toLocaleUpperCase() : this.getMatriculaFuncionarioLogado().toLocaleUpperCase() ;
  }

  public deleteCookie(){ 
    console.log("---- excluir cookie ---- ");
    console.log( ConfiguracaoEnum.COOKIE_NAME );
    return this.cookieService.delete( ConfiguracaoEnum.COOKIE_NAME );
 }
  /**
   * TODO
   */
  public static ehFucionario(matricula:string){
    if(matricula == undefined ) return false;
    console.log(!new RegExp("[C]").test( matricula.toUpperCase()));
    return !new RegExp("[C]").test( matricula.toUpperCase());
  }



}


