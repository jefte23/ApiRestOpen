import { Injectable } from '@angular/core';
import { ConfigService } from './config.service';
import { FileSystem } from '../admin-model/app.fileSystem';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class FileSystemService {

  public static readonly URI = "/fileSystemThreshold/";
  constructor( private http: HttpClient , private config :ConfigService) { }

  public getFileSystem(param):Observable<any>{
    console.log('Param :', param );
    this.http.post(this.config.getUrl(FileSystemService.URI), param).subscribe( dados => {
      console.log('Daodos :', dados);
     });
    
    return this.http.post(this.config.getUrl(FileSystemService.URI), param);
 }

}
 