import { Component, OnInit } from '@angular/core';
import { IncidenteService } from '../../admin-services/incidente.service';
import { IncidenteRequest } from '../../admin-model/app.incidenteRequest';

@Component({
  selector: 'app-buscar-incidente',
  templateUrl: './buscar-incidente.component.html',
  styleUrls: ['./buscar-incidente.component.css']
})
export class BuscarIncidenteComponent implements OnInit {
  
  public loading = false;//loading
  public rdi : string;
  public incidenteRequest : IncidenteRequest = new IncidenteRequest ();

  constructor( private incidenteService:IncidenteService ) { }

  ngOnInit() {
  }


  public buscarIncidente(){
    this.loading = true;
    console.log( this.rdi );
    this.incidenteService.buscarIncidente( this.rdi ).subscribe( requestData => {
      this.loading = false;
      this.incidenteRequest = requestData;
      console.log(  this.incidenteRequest );
    },err => {
      this.loading = false;
      console.log(" Error buscarIncidente() => " , err); 
    });
}

}
