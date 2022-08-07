import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { SharedModule } from 'src/shared/shared.module';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './AddCandidateInfo/question/question.component';
import { CompanyComponent } from './company/company.component';
import { EmployeeComponent } from './employee/employee.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CandidatesComponent } from './AddCandidateInfo/candidates/candidates.component';
import { InterviewComponent } from './AddCandidateInfo/interview/interview.component';
import { HomePageComponent } from './home-page/home-page.component';


const routes: Routes = [
  { path: "contact", component: ContactUsComponent },
  { path: "home", component: HomePageComponent },
  { path: "question", component: QuestionComponent },
  { path: "company", component: CompanyComponent },
  { path: "employee", component: EmployeeComponent },
  { path: "candidate", component: CandidatesComponent },
  { path: "interview", component: InterviewComponent },

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
    SharedModule,
  ]
})
export class PagesModule { }
