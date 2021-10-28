import { Injectable } from '@angular/core';
import { ConfigService } from './config.service';
import { FileSystem } from '../admin-model/app.fileSystem';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class HistoricoConsumoDispositivoService {

  public static readonly URI = "/historicoConsumoDispositivo/";
  constructor( private http: HttpClient , private config :ConfigService) { }

  public getHistoricoConsumoDispositivo(param):Observable<any>{
    console.log('Param :', param );
    return this.http.post(this.config.getUrl(HistoricoConsumoDispositivoService.URI), param);
 }

}
 