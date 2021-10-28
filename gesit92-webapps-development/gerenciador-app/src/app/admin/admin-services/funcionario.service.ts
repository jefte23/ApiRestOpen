import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http';
import { Subscriber } from 'rxjs/Subscriber';
import { Observable } from 'rxjs/Observable';

import { Funcionario } from './../admin-model/app.funcionario';
import { ConfigService } from './config.service';



@Injectable()
export class FuncionarioService {

  public static readonly URI_FUNCI = "/funcionario/";
  constructor( private http: HttpClient , private config :ConfigService) { }

  public getFuncionarioLogado():Observable<Funcionario>{
     console.log(" URL - " + this.config.getUrl( FuncionarioService.URI_FUNCI  + this.config.getMatriculaFuncionarioLogado()) );
     return  this.http.get<any>( this.config.getUrl( FuncionarioService.URI_FUNCI  + this.config.getMatriculaFuncionarioLogado()) ); 
  }

  public getFuncionario( matricula ):Observable<Funcionario>{
     return  this.http.get<any>( this.config.getUrl( FuncionarioService.URI_FUNCI  + matricula) ); 
  }
  public getAdmins():Observable<Funcionario[]>{
    return  this.http.get<any[]>( this.config.getUrl( FuncionarioService.URI_FUNCI+"admin/"  + this.config.getMatriculaFuncionarioLogado()) ); 
 }


}
