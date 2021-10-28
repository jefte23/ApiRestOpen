import { ComentarioConsumoMF } from './../../admin-model/comentarioConsumoMF';
import { Component, OnInit } from '@angular/core';
import { detachEmbeddedView } from '@angular/core/src/view';

@Component({
  selector: 'app-comentario',
  templateUrl: './comentario.component.html',
  styleUrls: ['./comentario.component.css']
})
export class ComentarioComponent implements OnInit {

  pt: any;
  list : Array<number> = new Array<number>() ;
  dataAtual;
  
  comentarioConsumoMF: ComentarioConsumoMF = new ComentarioConsumoMF ();
  
   
  constructor() { }

  ngOnInit() {

    this.pt = {
      firstDayOfWeek: 0,
      dayNames: ["Domingo", "Segunra", "Terça", "Quarta", "Quinta", "Sexta", "Sabado"],
      dayNamesShort: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
      dayNamesMin: ["D","S","T","Q","Q","S","S"],
      monthNames: [ "Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro" ],
      monthNamesShort: [ "Jan", "Fev", "Mar", "Abr", "Mai", "Jun","Jul", "Ago", "Set", "Out", "Nov", "Dez" ],
      today: 'Hoje',
      clear: 'Clear'
  };

    this.dataAtual = new Date();

    console.log(this.dataAtual);
  }


 public add(){
   this.list.push( this.comentarioConsumoMF.capacidade );
   this.comentarioConsumoMF.capacidade = null;
   console.log( this.list );
 }


}
