import { IncidenteRequest } from './../../admin-model/app.incidenteRequest';
import { Funcionario } from './../../admin-model/app.funcionario';
import { IncidenteService } from './../../admin-services/incidente.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-incidente',
  templateUrl: './incidente.component.html',
  styleUrls: ['./incidente.component.css']
})
export class IncidenteComponent implements OnInit {

 public funcionario :Funcionario = new Funcionario();

  public loading = false;
  public isCompleted: boolean = false;
  public email:string;
  public rdi : string;
  public incidenteRequest : IncidenteRequest;

  constructor(private incidenteService:IncidenteService) { }

  public tipoAcionamento = [
    {id: 1, name: "United States"},
    {id: 2, name: "Australia"},
    {id: 3, name: "Canada"},
    {id: 4, name: "Brazil"},
    {id: 5, name: "England"},
  ];

  ngOnInit() {
    this.loading = true;
   
    this.incidenteService.getFuncionario().subscribe( data =>{
       this.loading = false;
       this.funcionario = data; 
       console.log( this.funcionario );
      }, err =>{
         this.loading = false;
      });
       
  }

  public buscarIncidente(){
    this.loading = true;
   
    this.incidenteService.buscarIncidente( this.rdi ).subscribe( requestData => {
      this.loading = false;
      this.incidenteRequest = requestData;
    },err => {
      this.loading = false;
      console.log(" Error buscarIncidente() => " , err); 
    });
}

  public open(){
    this.loading = true;
    this.incidenteService.getLoading().subscribe( res =>  {      
      this.loading = false;
    }, err =>{
      this.loading = false;
    });
  }

 

  //pw
  step2: any = {
    showNext: true,
    showPrev: true
  };
  
  step3: any = {
    showSecret: false
  };

  data: any = {
    email: 'muk@gmail.com'
  };

  onStep1Next(event) {
    console.log('Step1 - Next');
  }

  onStep2Next(event) {
    console.log('Step2 - Next');
  }

  onStep3Next(event) {
    console.log('Step3 - Next');
  }

  onComplete(event) {
    this.isCompleted = true;
  }

  onStepChanged(step) {
    console.log('Changed to ' + step.title);
  }


}
