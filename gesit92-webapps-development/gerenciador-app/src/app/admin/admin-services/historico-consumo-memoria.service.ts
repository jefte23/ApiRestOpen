import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from './config.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class HistoricoConsumoMemoriaService {

  public static readonly URI = "/historicoConsumoMemoria/";
  constructor( private http: HttpClient , private config :ConfigService) { }

  public buscarhistoricoConsumoMemoria ( param ):Observable<any>{
    console.log(param)
    return this.http.post(this.config.getUrl( HistoricoConsumoMemoriaService.URI), param );
 }

}
