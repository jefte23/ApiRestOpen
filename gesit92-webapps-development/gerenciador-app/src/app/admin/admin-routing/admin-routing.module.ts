import { ExtranetRsfnComponent } from './../admin-component/extranet-rsfn/extranet-rsfn.component';
import { WikiComponent } from './../admin-component/wiki/wiki.component';
import { AdminComponent } from './../admin.component';
import { AdminDashboardComponent } from '../admin-dashboard/admin-dashboard.component';
import { ServidorThresholdComponent } from '../admin-component/servidor-threshold/servidor-threshold.component';
import { PageNotFoundComponent } from './../admin-component/page-not-found/page-not-found.component';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AppComponent } from '../../app.component';
import { IncidenteComponent } from '../admin-component/incidente/incidente.component';
import { SportfireComponent } from '../admin-component/sportfire/sportfire.component';
import { DocumentacaoApiComponent } from '../admin-component/documentacao-api/documentacao-api.component';
import { BuscarIncidenteComponent } from '../admin-component/buscar-incidente/buscar-incidente.component';
import { ComentarioComponent } from '../admin-component/comentario/comentario.component';
import { CadernoPlataformaComponent } from '../admin-component/caderno-plataforma/caderno-plataforma.component';
import { CompeComponent } from '../admin-component/compe/compe.component';
import { CipComponent } from '../admin-component/cip/cip.component';
import { HardwareComponent } from '../admin-component/hardware/hardware.component';
import { SoftwareComponent } from '../admin-component/software/software.component';
import { FitotecaComponent } from '../admin-component/fitoteca/fitoteca.component';
import { BasileiaComponent } from '../admin-component/basileia/basileia.component';
import { DiscoComponent } from '../admin-component/disco/disco.component';
import { RedeComponent } from '../admin-component/rede/rede.component';
import { RemusComponent } from '../admin-component/remus/remus.component';
import { BasileiaRedeComponent } from '../admin-component/basileia-rede/basileia-rede.component';
import { BbworldnetComponent } from '../admin-component/bbworldnet/bbworldnet.component';
import { CompeRedeComponent } from '../admin-component/compe-rede/compe-rede.component';
import { BovespaComponent } from './../admin-component/bovespa/bovespa.component';
import { AcessoInternetComponent } from './../admin-component/acesso-internet/acesso-internet.component';
import { MetodosEstatisticosComponent } from './../admin-component/metodos-estatisticos/metodos-estatisticos.component';
import { InstrucoesNormasComponent } from './../admin-component/instrucoes-normas/instrucoes-normas.component';
import { AberturaRtcComponent } from '../admin-component/rtc/abertura-rtc/abertura-rtc.component';
import { ConsultaRtcComponent } from '../admin-component/rtc/consulta-rtc/consulta-rtc.component';


@NgModule({
  imports: [


  RouterModule.forChild([
      {
        path: 'inicio',
        component: AdminComponent,
        children: [
          {
            path: '',
            redirectTo: 'inicio',
            pathMatch: 'full'
          },
          {
            path: 'inicio',
            component: AdminDashboardComponent
          },
          { 
            path: '',
            component: AdminDashboardComponent
          },
          {
            path: 'grupos-threshold',
            component: ServidorThresholdComponent
          },
          {
            path: 'incidente',
            component: IncidenteComponent
          },
          {
            path: 'sportfire',
            component: SportfireComponent
          },
          {
            path: 'documentacao',
            component: DocumentacaoApiComponent
          },
          {
            path: 'buscar-incidente',
            component: BuscarIncidenteComponent
          },
          {
            path: 'comentario',
            component: ComentarioComponent
          },
          {
            path: 'caderno-plataforma',
            component: CadernoPlataformaComponent
          },
          {
            path: 'wiki',
            component: WikiComponent
          },
          {
            path: 'compe',
            component: CompeComponent
          },
          {
            path: 'cip',
            component: CipComponent
          },
          {
            path: 'hardware',
            component: HardwareComponent
          },
          {
            path: 'software',
            component: SoftwareComponent
          },
          {
            path: 'fitoteca',
            component: FitotecaComponent
          },
          {
            path: 'basileia',
            component: BasileiaComponent
          },
          {
            path: 'disco',
            component: DiscoComponent
          },
          {
            path: 'rede',
            component: RedeComponent
          },
          {
            path: 'remus',
            component: RemusComponent
          },
          {
            path: 'basileia-rede',
            component: BasileiaRedeComponent
          },
          {
            path: 'bbworldnet',
            component: BbworldnetComponent
          },
          {
            path: 'compe-rede',
            component: CompeRedeComponent
          },
          {
            path: 'extranet-rsfn',
            component: ExtranetRsfnComponent
          },
          {
            path: 'bovespa',
            component: BovespaComponent
          },
          {
            path: 'acesso-internet',
            component: AcessoInternetComponent
          },
          {
            path: 'metodos-estatisticos',
            component: MetodosEstatisticosComponent
          },
          {
            path: 'instrucoes-normas',
            component: InstrucoesNormasComponent
          },
          {
            path: 'abertura-rtc',
            component: AberturaRtcComponent
          },
          {
            path: 'consulta-rtc',
            component: ConsultaRtcComponent
          },
          {
            path: '**',
            component: PageNotFoundComponent
          }
        ]
      }
    ], )
  ],
  exports: [
    RouterModule
  ]
})
export class AdminRoutingModule { }
