import { OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ConfigService } from './config.service';
import { FuncionarioService } from './funcionario.service';
import { Funcionario } from '../admin-model/app.funcionario';
import { IncidenteRequest } from '../admin-model/app.incidenteRequest';


//https://www.npmjs.com/package/ngx-loading
@Injectable()
export class IncidenteService  {


  public static readonly URI = "/bbincidente/";
  
  
  constructor( private http: HttpClient ,private funcionarioService : FuncionarioService, private config :ConfigService  ) { }

  public getLoading():Observable<any>{
    //return this.http.get("");
    return null;
 }

public getFuncionario():Observable<Funcionario>{
  return this.funcionarioService.getFuncionarioLogado();
}

public buscarIncidente( rdi ):Observable<any>{
  return  this.http.get( this.config.getUrl( IncidenteService.URI +  rdi ) );
}
 


}
