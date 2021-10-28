import { AdminComponent } from './../admin/admin.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forRoot([
      { path: '', redirectTo: '/inicio', pathMatch: 'full' },
      { path: 'inicio', redirectTo: '/inicio', pathMatch: 'full'}
    ],{useHash: true })
  ],
  declarations: [],
  exports: [ RouterModule]
})
export class AppRoutingModule { }
