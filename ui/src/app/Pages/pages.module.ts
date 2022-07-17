import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { SharedModule } from 'src/shared/shared-module/shared.module';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './AddCandidateInfo/question/question.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CompanyComponent } from './company/company.component';
import { EmployeeComponent } from './employee/employee.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
    {path:"contact", component: ContactUsComponent},
    {path:"question", component:QuestionComponent},
    {path:"company", component:CompanyComponent},
    {path:"employee", component:EmployeeComponent},



]
@NgModule({
  declarations: [
    ContactUsComponent,
    PageNotFoundComponent,
    QuestionComponent,
    CompanyComponent,
    EmployeeComponent,
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    ReactiveFormsModule,
    SharedModule,
    RouterModule.forChild(routes)

  ]
})
export class PagesModule { }
