import { Injectable, OnInit } from '@angular/core';
import { RecomendacaoTecnica } from '../admin-model/app.recomendacaoTecnica';
import { Observable } from 'rxjs';


@Injectable()
export class RtcService implements OnInit {

  ngOnInit(): void { }

  constructor() { }
   public getAll(): Observable<any>{
    return  this.mockList() ;
 }

private mockList(): Observable<any>{
  let recomendacaoTecnica: RecomendacaoTecnica = new RecomendacaoTecnica();
  let recomendacoesTecnicas: Array<RecomendacaoTecnica> = new Array();
  for (let index = 0; index < 10; index++) {
    recomendacaoTecnica.descricao = "Teste de inicialização rdi nº" + index;
    recomendacaoTecnica.responsavel = "gerente Responsavel nº" + index;
    recomendacaoTecnica.gerencia = "GESIT";
    recomendacaoTecnica.nivelCriticidade = (index % 2 ? "Baixo" : "Alta");
    recomendacaoTecnica.destinatario = "GESIT/" + index;
    recomendacoesTecnicas.push( recomendacaoTecnica );
    recomendacaoTecnica = new RecomendacaoTecnica();
  }
  return Observable.of( recomendacoesTecnicas );
}
  
}
