import { Component, OnInit } from '@angular/core';
import { RtcService } from '../../../admin-services/rtc.service';
import { RecomendacaoTecnica } from '../../../admin-model/app.recomendacaoTecnica';
import { MenuModule } from 'primeng/menu';
import { MenuItem } from 'primeng/api';
import { Alert } from 'selenium-webdriver';
import { StepsModule } from 'primeng/steps';


@Component({
  selector: 'app-consulta-rtc',
  templateUrl: './consulta-rtc.component.html',
  styleUrls: ['./consulta-rtc.component.css']
})
export class ConsultaRtcComponent implements OnInit {

  recomendacoesTecnicas: Array<RecomendacaoTecnica> = new Array();
  selectedRecomendacaoTecnica: RecomendacaoTecnica = new RecomendacaoTecnica();
  constructor(private rtcService: RtcService) {
  }
  placeholder: string;
  label: string;
  private items: MenuItem[];
  private stepItems: MenuItem[];
  activeIndex: number = 1;


  ngOnInit() {
    // -----------  Menu Step ---------------
    this.stepItems = [{
      label: 'Aberto',
      command: (event: any) => {
        this.activeIndex = 0;
      }
    },
    {
      label: 'Em atendimento',
      command: (event: any) => {
        this.activeIndex = 1;
      }
    },
    {
      label: 'Em avaliação',
      command: (event: any) => {
        this.activeIndex = 2;
      }
    },
    {
      label: 'Pendente',
      command: (event: any) => {
        this.activeIndex = 3;
      }
    },
    {
      label: 'Concluido',
      command: (event: any) => {
        this.activeIndex = 4;
      }
    }
    ];


    this.rtcService.getAll().subscribe(dados => this.recomendacoesTecnicas = dados);
    console.log(this.recomendacoesTecnicas);
    this.items = [
      { label: 'Nr. RTC', icon: 'pi pi-refresh', command: () => { this.placeholder = 'Dígite o Número da RTC'; this.label = 'RTC'; } },
      { label: 'Chave', icon: 'pi pi-times', command: () => { this.placeholder = 'Dígite a chave'; this.label = 'Chave'; } },
      { label: 'Descrição', icon: 'pi pi-info', command: () => { this.placeholder = 'Dígite a descrição'; this.label = 'Descrição'; } },
      { label: 'Status', icon: 'pi pi-cog', command: () => { this.placeholder = 'Dígite o status'; this.label = 'Status'; } }
    ];
  }

  selectWithButton(recomendacaoTecnica: RecomendacaoTecnica) {
    this.selectedRecomendacaoTecnica = recomendacaoTecnica;
    console.log(this.selectedRecomendacaoTecnica);
  }

  onRowSelect(event) {
    console.log(event.data.recomendacaoTecnica);
  }

  onRowUnselect(event) {
    console.log(event.data.recomendacaoTecnica);
  }

}
