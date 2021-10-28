import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http';
import { Subscriber } from 'rxjs/Subscriber';
import { Observable } from 'rxjs/Observable';

import { ConfigService } from './config.service';
import { ServidorThreshold } from '../admin-model/app.servidorThreshold';



@Injectable()
export class ServidorThresholdService {

  public static readonly URI = "/servidorThreshold/";
  constructor( private http: HttpClient , private config :ConfigService) { }

  public getServidoresThreshold():Observable<ServidorThreshold[]>{
    return  this.http.get<ServidorThreshold[]>( this.config.getUrl( ServidorThresholdService.URI  ) ); 
 }


}
