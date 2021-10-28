import { Component, OnInit, Input, OnDestroy } from "@angular/core";
import { Funcionario } from "./../admin-model/app.funcionario";
import { FuncionarioService } from "./../admin-services/funcionario.service";
import { ConfigService } from "./../admin-services/config.service";

@Component({
  selector: "app-admin-header",
  templateUrl: "./admin-header.component.html",
  styleUrls: ["./admin-header.component.css"]
})
export class AdminHeaderComponent implements OnInit {
  funcionario = new Funcionario();
  cookieService: any;

  constructor( private funcionarioService: FuncionarioService ,private config :ConfigService) {}
  
  ngOnInit() {
    try {
       this.funcionarioService.getFuncionarioLogado().subscribe ( dados => this.funcionario = dados );
    } catch (error) {
      console.log(" Funcionário não localizado !");
    }
  }

  public sair(){

    window.location.href = 'https://capacidade.servicos.bb.com.br:8443/capacidade/';
    this.config.deleteCookie();
  }
}
