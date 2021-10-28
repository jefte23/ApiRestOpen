import { Component, OnInit, Input } from '@angular/core';
import { IncidenteRequest } from '../../admin-model/app.incidenteRequest';
import {AccordionModule} from 'primeng/accordion';


@Component({
  selector: 'app-imprimir-incidente',
  templateUrl: './imprimir-incidente.component.html',
  styleUrls: ['./imprimir-incidente.component.css']
})
export class ImprimirIncidenteComponent implements OnInit {
    
   @Input() incidente : IncidenteRequest;
   @Input() titulo : string;

   

  constructor() { }
  
  ngOnInit() {
     console.log( this.incidente.messages );
     console.log("Titulo" , this.titulo );
  }

}
