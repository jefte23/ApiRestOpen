import { Funcionario } from './../admin-model/app.funcionario';
import { FuncionarioService } from './../admin-services/funcionario.service';
import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../admin-services/config.service';

@Component({
  selector: 'app-admin-left-side',
  templateUrl: './admin-left-side.component.html',
  styleUrls: ['./admin-left-side.component.css']
})
export class AdminLeftSideComponent implements OnInit {
  
  ngOnInit() {}
  
  public  funcionario : Funcionario = new Funcionario(); 
 
  constructor(private funcionarioService: FuncionarioService , private config :ConfigService) {
   
    this.funcionarioService.getFuncionarioLogado().subscribe( funci => { 
        this.funcionario = funci;
    } );
  }
  
  public sair(){
    this.config.deleteCookie();
  }
 

}
