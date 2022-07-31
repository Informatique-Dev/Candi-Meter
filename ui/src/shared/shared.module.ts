import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MaterialComponentsModule} from 'src/shared/material-components-module/material-components.module'
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MaterialComponentsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    RouterModule.forChild([])
  ],
  exports:[
    MaterialComponentsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
  ]
})
export class SharedModule { }
