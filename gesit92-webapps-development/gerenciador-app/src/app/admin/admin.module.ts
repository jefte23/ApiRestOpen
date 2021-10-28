import { ConsultaRtcComponent } from './admin-component/rtc/consulta-rtc/consulta-rtc.component';
import { AberturaRtcComponent } from './admin-component/rtc/abertura-rtc/abertura-rtc.component';
import { InstrucoesNormasComponent } from './admin-component/instrucoes-normas/instrucoes-normas.component';
import { MetodosEstatisticosComponent } from './admin-component/metodos-estatisticos/metodos-estatisticos.component';
import { AcessoInternetComponent } from './admin-component/acesso-internet/acesso-internet.component';
import { ExtranetRsfnComponent } from './admin-component/extranet-rsfn/extranet-rsfn.component';
import { CompeRedeComponent } from './admin-component/compe-rede/compe-rede.component';
import { BbworldnetComponent } from './admin-component/bbworldnet/bbworldnet.component';
import { BasileiaRedeComponent } from './admin-component/basileia-rede/basileia-rede.component';
import { RemusComponent } from './admin-component/remus/remus.component';
import { RedeComponent } from './admin-component/rede/rede.component';
import { DiscoComponent } from './admin-component/disco/disco.component';
import { BasileiaComponent } from './admin-component/basileia/basileia.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartModule } from 'angular-highcharts';
import { FormWizardModule } from 'angular2-wizard';
import { CookieService } from 'ngx-cookie-service';
import { LoadingModule } from 'ngx-loading';
import { AccordionModule } from 'primeng/accordion';
import { CalendarModule } from 'primeng/calendar';
import { CardModule } from 'primeng/card';
import { MessageService } from 'primeng/components/common/messageservice';
import { DataTableModule } from 'primeng/datatable';
import { EditorModule } from 'primeng/editor';
import { FieldsetModule } from 'primeng/fieldset';
import { GrowlModule } from 'primeng/growl';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { MessageModule } from 'primeng/message';
import { MessagesModule } from 'primeng/messages';
import { PanelModule } from 'primeng/panel';
import { ButtonModule, ConfirmationService, ConfirmDialogModule, ContextMenuModule, SplitButtonModule } from 'primeng/primeng';
import { BreadcrumbComponent } from './admin-component/breadcrumb/breadcrumb.component';
import { BuscarIncidenteComponent } from './admin-component/buscar-incidente/buscar-incidente.component';
import { CadernoPlataformaComponent } from './admin-component/caderno-plataforma/caderno-plataforma.component';
import { CipComponent } from './admin-component/cip/cip.component';
import { ComentarioComponent } from './admin-component/comentario/comentario.component';
import { CompeComponent } from './admin-component/compe/compe.component';
import { DocumentacaoApiComponent } from './admin-component/documentacao-api/documentacao-api.component';
import { ImprimirIncidenteComponent } from './admin-component/imprimir-incidente/imprimir-incidente.component';
import { IncidenteComponent } from './admin-component/incidente/incidente.component';
import { PageNotFoundComponent } from './admin-component/page-not-found/page-not-found.component';
import { ServidorThresholdComponent } from './admin-component/servidor-threshold/servidor-threshold.component';
import { SportfireComponent } from './admin-component/sportfire/sportfire.component';
import { AdminContentComponent } from './admin-content/admin-content.component';
import { AdminControlSidebarComponent } from './admin-control-sidebar/admin-control-sidebar.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminFooterComponent } from './admin-footer/admin-footer.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AdminLeftSideComponent } from './admin-left-side/admin-left-side.component';
import { AdminRoutingModule } from './admin-routing/admin-routing.module';
import { ChartsService } from './admin-services/charts.service';
import { ConfigService } from './admin-services/config.service';
import { FileSystemService } from './admin-services/filesystem.service';
import { FuncionarioService } from './admin-services/funcionario.service';
import { HistoricoConsumoMemoriaService } from './admin-services/historico-consumo-memoria.service';
import { HistoricoConsumoDispositivoService } from './admin-services/historico-consumoDispositivo.service';
import { IncidenteService } from './admin-services/incidente.service';
import { ServidorThresholdService } from './admin-services/servidorThreshold.service';
import { AdminComponent } from './admin.component';
import { WikiComponent } from './admin-component/wiki/wiki.component';
import { HardwareComponent } from './admin-component/hardware/hardware.component';
import { SoftwareComponent } from './admin-component/software/software.component';
import { FitotecaComponent } from './admin-component/fitoteca/fitoteca.component';
import { BovespaComponent } from './admin-component/bovespa/bovespa.component';
import { RtcService } from './admin-services/rtc.service';
import {TableModule} from 'primeng/table';
import {StepsModule} from 'primeng/steps';




@NgModule({
  imports: [
    StepsModule,
    CommonModule,
    AdminRoutingModule,
    GrowlModule,
    ButtonModule,
    FormsModule,
    MessagesModule,
    MessageModule,
    ConfirmDialogModule,
    DataTableModule,
    ContextMenuModule,
    ChartModule, 
    BrowserAnimationsModule,
    FieldsetModule,
    EditorModule,
    LoadingModule,
    FormWizardModule,
    CalendarModule,
    InputTextModule,
    InputTextareaModule,
    AccordionModule,
    CardModule,
    PanelModule,
    SplitButtonModule,
    TableModule
  ],

  providers: [
    FuncionarioService,
    ConfigService,
    CookieService,
    MessageService,
    ConfirmationService,
    ServidorThresholdService,
    FileSystemService,
    HistoricoConsumoMemoriaService,
    HistoricoConsumoDispositivoService,
    ChartsService,
    IncidenteService,
    RtcService

  ],


  declarations: [
    AdminComponent,
    AdminHeaderComponent,
    AdminLeftSideComponent,
    AdminContentComponent,
    AdminFooterComponent,
    AdminControlSidebarComponent,
    AdminDashboardComponent, 
    ServidorThresholdComponent,
    PageNotFoundComponent,
    BreadcrumbComponent,
    IncidenteComponent,
    SportfireComponent,
    DocumentacaoApiComponent,
    BuscarIncidenteComponent,
    ComentarioComponent,
    ImprimirIncidenteComponent,
    CadernoPlataformaComponent,
    WikiComponent,
    CompeComponent,
    CipComponent,
    HardwareComponent,
    FitotecaComponent,
    SoftwareComponent,
    BasileiaComponent,
    DiscoComponent,
    RedeComponent,
    RemusComponent,
    BasileiaRedeComponent,
    BbworldnetComponent,
    CompeRedeComponent,
    ExtranetRsfnComponent,
    BovespaComponent,
    AcessoInternetComponent,
    MetodosEstatisticosComponent,
    InstrucoesNormasComponent,
    AberturaRtcComponent,
    ConsultaRtcComponent
  ],
  exports: [AdminComponent]
})
export class AdminModule { }
