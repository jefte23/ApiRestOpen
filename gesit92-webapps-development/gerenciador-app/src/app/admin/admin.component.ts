import { HttpClient } from '@angular/common/http';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario } from './admin-model/app.funcionario';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit, OnDestroy {

  bodyClasses = 'skin-blue sidebar-mini';
  body: HTMLBodyElement = document.getElementsByTagName('body')[0];
  titlePage: String;
  redirecionarHome = true;

  constructor( private http:HttpClient){ 
           ///http://www.mocky.io/v2/5b3e6ea53000005600abc6f3
          // erro  http://www.mocky.io/v2/5b3e6dd53000009405abc6eb
       http.get("https://www.mocky.io/v2/5b3e6ea53000005600abc6f3").subscribe( 
          data =>{
                this.redirecionarHome = true;
            }, err =>{
                this.redirecionarHome = false;
            });
  }

  ngOnInit() {
    this.body.classList.add('skin-blue');
    this.body.classList.add('sidebar-mini');
  }

   ngOnDestroy() {
    // remove the the body classes
    this.body.classList.remove('skin-blue');
    this.body.classList.remove('sidebar-mini');
  }

}
