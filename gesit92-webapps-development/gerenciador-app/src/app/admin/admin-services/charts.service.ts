import { Injectable } from "@angular/core";
import { IndividualSeriesOptions } from "highcharts";
import { Chart } from "angular-highcharts";
import * as moment from 'moment';
import { HistoricoConsumoDispositivoService } from "./historico-consumoDispositivo.service";

@Injectable()
export class ChartsService {

  constructor(private historicoService : HistoricoConsumoDispositivoService) { }
  
public getChartCpu( cpuTotalUtilizadaData : Array<number> , thresholdCpuData: Array<number> ,dataModificao: Array<any>) {
  let chart = new Chart( {
    chart: {
      type:'line'
    },  
    title: {
      text: 'Consumo de CPU - Diário'
    }, 
    credits: {
      enabled:false
    }, 
    plotOptions: {
      line: {
          dataLabels: {
              enabled: true
          },
          enableMouseTracking: false
      }
  },

    legend: {
      layout:'vertical', 
      align:'right', 
      verticalAlign:'middle'
  }, 
  xAxis: {
    categories: dataModificao
  },
  yAxis: {
    title: {
        text: 'Temperature (°C)'
    }
   
 }, 

   series:[
    {
      name:'Consumo de CPU',
      data:cpuTotalUtilizadaData,
      color:'#1b38cc'
    },
    {
      name:'Threshold CPU',
      data:thresholdCpuData,
      color:'#f39c12'
    }
  ]
     
  }); 
    
  return chart;
}

//TODO:
public getChartMemoria( memoriaTotalData :Array<number> , thresholdMemoriaData : Array<number> , consumoMemoria: Array<number>, dataModificao: Array<any>  ) {
  console.log("memoria");
  let chart = new Chart( {
    chart: {
      type:'line'
    },  
    title: {
      text:' Consumo de Memória (GB) - Mensal'
    }, 
    credits: {
      enabled:false
    }, 
    plotOptions: {
      line: {
          dataLabels: {
              enabled: true
          },
          enableMouseTracking: false
      }
  },

    legend: {
      layout:'vertical', 
      align:'right', 
      verticalAlign:'middle'
  }, 
  xAxis: {
    categories: dataModificao
  },
   series:[
    {
      name:'Mémoria Total',
      data:memoriaTotalData,
      color:'#dc2d17'
    },
    {
      name:'Threshold de Memória',
      data:thresholdMemoriaData,
      color:'#f39c12'
    },
    {
      name:'Consumo de Memória',
      data:consumoMemoria,
      color:'#1b38cc'
    }
  ]
     
  }); 
    
  return chart;
}

public getChartFilesystens(param:any) {
  let dataColeta : Array<any> = []; 
  let areaTotalUtilizadaData : Array<any> = [];  
  let areaTotalData: Array<any> = [];
 
  this.historicoService.getHistoricoConsumoDispositivo(param).subscribe( dados => {
    dados.forEach( el => {
       dataColeta.push( el.dataColeta );
       areaTotalUtilizadaData.push( el.areaTotal );
       areaTotalData.push( moment( el.areaTotalUtilizada).format("DD/MM/YYYY")  );
    });
    console.log('dados - > ', dados );
  });

  let chart : Chart = new Chart( {
    chart: {
      type:'line'
    },  
    title: {
      text:' Consumo do Filesystem (GB) - Mensal'
    }, 
    credits: {
      enabled:false
    }, 
    plotOptions: {
      line: {
          dataLabels: {
              enabled: true
          },
          enableMouseTracking: false
      }
  },

    legend: {
      layout:'vertical', 
      align:'right', 
      verticalAlign:'middle'
  }, 
  xAxis: {
    categories: dataColeta
  },
   series:[
    {
      name:'Área Total',
      data:areaTotalData,
      color:'#dc2d17'
    },
  /**  {
      name:'Threshold Disco',
      data:null,
      color:'#f39c12'
    }, */
    {
      name:'Área Utilizada',
      data:areaTotalUtilizadaData,
      color:'#1b38cc'
    }
  ]
     
  }); 
    
  return chart;
}

public data ( data: string ){
 let meses = new Array("Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez");
  

 let dia = moment( data).format("M");
console.log("Mes", dia);
 let today =  meses[dia];
 return today;
}

}
