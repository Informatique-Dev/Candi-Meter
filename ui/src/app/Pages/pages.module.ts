import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { SharedModule } from 'src/shared/shared-module/shared.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
    {path:"contact", component: ContactUsComponent},
]
@NgModule({
  declarations: [
    ContactUsComponent,
    PageNotFoundComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    SharedModule,

  ]
})
export class PagesModule { }
