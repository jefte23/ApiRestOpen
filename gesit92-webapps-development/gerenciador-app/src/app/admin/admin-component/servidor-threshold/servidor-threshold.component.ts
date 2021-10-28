import { ParamFilesystemDTO } from './../../admin-model/app.paramFileystem';
import { ChartsService } from './../../admin-services/charts.service';
import {HistoricoConsumoMemoria }from './../../admin-model/app.historicoConsumoMemoria'; 
import {HistoricoConsumoMemoriaService }from './../../admin-services/historico-consumo-memoria.service'; 
import {ParamDTO }from './../../admin-model/app.paramDTO'; 
import {FileSystem }from './../../admin-model/app.fileSystem'; 
import {ServidorThresholdService }from './../../admin-services/servidorThreshold.service'; 
import {ServidorThreshold }from '../../admin-model/app.servidorThreshold'; 
import {Funcionario }from '../../admin-model/app.funcionario'; 

import {Component, OnInit }from '@angular/core'; 
import * as moment from "moment"; 


import {MenuItem, Message }from 'primeng/components/common/api'; 
import {Chart }from 'angular-highcharts'; 
import { forEach } from '@angular/router/src/utils/collection';
import { Recurso } from '../../admin-enum/recurso.enum';
import { IndividualSeriesOptions } from 'highcharts';
import { FileSystemService } from '../../admin-services/filesystem.service';





@Component( {
  selector:'app-servidor-threshold', 
  templateUrl:'./servidor-threshold.component.html', 
  styleUrls:['./servidor-threshold.component.css']
})
export class ServidorThresholdComponent implements OnInit {
  
public  haDiscoSelecionado: boolean = false;
public servidores:ServidorThreshold []; 
public selectedThreshold:ServidorThreshold = new ServidorThreshold; 
public historicoConsumoMemoriaList:HistoricoConsumoMemoria []; 
public fileSystens:FileSystem []; 
public items:MenuItem[]; 
public msgs:Message[] = [];
public param:ParamDTO = new ParamDTO(); 
public fileSystemSelecionado : FileSystem ;



public heDisco:boolean = false; 
public heCpu:boolean = false; 
public heMemoria:boolean = false; 

public dataModificaoData : Array<Date> = [];
public loading = false;

chart:Chart; 

//https://www.npmjs.com/package/ngx-loading
constructor(private  servidorThresholdService:ServidorThresholdService, 
             private fileSystemService:FileSystemService, 
             private historicoConsumoService:HistoricoConsumoMemoriaService,
            private chartsService:ChartsService) {

}

ngOnInit() {
  this.loading = true;
  this.servidorThresholdService.getServidoresThreshold().subscribe(serv =>  {
     this.loading = false;
     this.servidores = serv; 
    }, err =>{
      this.loading = false;
    }); 

  }

private mostrarGraficoCpuEmemoria( param:ParamDTO) {

let  thresholdCpuData: Array<number> = []; let  cpuTotalUtilizadaData : Array<number> = [];

let memoriaTotalData :Array<number> = [] ; let thresholdMemoriaData : Array<number> = [] ; let  consumoDeMemoria: Array<number> = [] ;

this.historicoConsumoService.buscarhistoricoConsumoMemoria( param ).subscribe(dados => this.historicoConsumoMemoriaList = dados   ); 
  
for (const val in this.historicoConsumoMemoriaList) {

    if( this.heCpu ) {        
        thresholdCpuData.push ( this.historicoConsumoMemoriaList [val].thresholdCpu ); 
        cpuTotalUtilizadaData.push( this.historicoConsumoMemoriaList [val].cpuTotalUtilizada );
    }else if( this.heMemoria ){
        memoriaTotalData.push( this.historicoConsumoMemoriaList [val].totalMemoria );
        thresholdMemoriaData.push(this.historicoConsumoMemoriaList [val].thresholdMmr);
        consumoDeMemoria.push( this.historicoConsumoMemoriaList [val].consumoMemoria );
    }
   
    let  dataMod : any =  moment( this.historicoConsumoMemoriaList [val].dataModificao ).format("DD/MM/YYYY");
    this.dataModificaoData.push( dataMod );
}
  if( this.heCpu ){
    this.chart = this.chartsService.getChartCpu( cpuTotalUtilizadaData, thresholdCpuData, this.dataModificaoData );
  }else if( this.heMemoria ){
      this.chart = this.chartsService.getChartMemoria( memoriaTotalData ,thresholdMemoriaData ,consumoDeMemoria, this.dataModificaoData );
  }
}


public selectServidor(car:ServidorThreshold) {
  this.msgs = []; 
  this.msgs.push( {severity:'info', summary:'Car Select', detail:'Vin: ' + car.listaThresholdId.recurso}); 
}

public onRowSelect(event) {
  this.selectedThreshold = event.data; 

  this.heDisco = this.selectedThreshold.listaThresholdId.recurso == Recurso.DISCO; 
  this.heCpu = this.selectedThreshold.listaThresholdId.recurso == Recurso.CPU;
  this.heMemoria = this.selectedThreshold.listaThresholdId.recurso == Recurso.MEMORIA;


  this.param.idGrupo = this.selectedThreshold.idGrupo; 
  this.param.idServidor = this.selectedThreshold.idServidor; 
  
  this.mostrarGraficoCpuEmemoria( this.param );
 
  this.fileSystemService.getFileSystem(this.param ).subscribe(dados => this.fileSystens = dados ); 
  
}
onRowSelectDisco(event){
  console.log( event.data );
  this.fileSystemSelecionado = event.data;
  this.haDiscoSelecionado = true;
  
  let paramFilesystemDTO : ParamFilesystemDTO = new ParamFilesystemDTO();
  paramFilesystemDTO.idServidor = this.fileSystemSelecionado.idServidor;
  paramFilesystemDTO.fileSystem = this.fileSystemSelecionado.fileSystem; 
  paramFilesystemDTO.dispositivo = this.fileSystemSelecionado.dispositivo;

  this.chart = this.chartsService.getChartFilesystens( paramFilesystemDTO );
  
}


}
