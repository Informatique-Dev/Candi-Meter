import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { SharedModule } from 'src/shared/shared-module/shared.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './AddCandidateInfo/question/question.component';
import { ReactiveFormsModule } from '@angular/forms';


const routes: Routes = [
    {path:"contact", component: ContactUsComponent},
    {path:"question", component:QuestionComponent},

]
@NgModule({
  declarations: [
    ContactUsComponent,
    PageNotFoundComponent,
    QuestionComponent,
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    SharedModule,
    ReactiveFormsModule
    ]
})
export class PagesModule { }
