import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SharedModule } from 'src/shared/shared-module/shared.module';
import { ReactiveFormsModule } from '@angular/forms';

const routes:Routes = [
  { path:"login", component:LoginComponent },
  { path:"", component:LoginComponent }
]

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ]
})
export class AuthModule { }
