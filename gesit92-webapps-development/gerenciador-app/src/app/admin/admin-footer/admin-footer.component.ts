import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-admin-footer',
  templateUrl: './admin-footer.component.html',
  styleUrls: ['./admin-footer.component.css']
})
export class AdminFooterComponent implements OnInit {

  today: any ;
  meses = new Array("Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro");
	semana = new Array("Domingo","Segunda-feira","Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira","Sábado");
	

  constructor() {
    
   
   }

  ngOnInit() {

    let hoje = new Date();
	  let dia = hoje.getDate();
	  let dias = hoje.getDay();
	  let mes = hoje.getMonth();
    let ano = moment( hoje).format("YYYY");

	  this.today = this.semana[dias] + ", " + dia + " de " + this.meses[mes]+ " de " + ano;
     
  }

 
}
