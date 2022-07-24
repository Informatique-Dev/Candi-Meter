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
import { CandidatesComponent } from './AddCandidateInfo/candidates/candidates.component';
import { InterviewComponent } from './AddCandidateInfo/interview/interview.component';


const routes: Routes = [
    {path:"contact", component: ContactUsComponent},
    {path:"question", component:QuestionComponent},
    {path:"company", component:CompanyComponent},
    {path:"employee", component:EmployeeComponent},
    {path:"candidate", component:CandidatesComponent},
    {path:"interview", component:InterviewComponent}
]
@NgModule({
  declarations: [
    ContactUsComponent,
    PageNotFoundComponent,
    QuestionComponent,
    CompanyComponent,
    EmployeeComponent,
    CandidatesComponent,
    InterviewComponent,
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    ReactiveFormsModule,
    SharedModule,
  ]
})
export class PagesModule { }
