import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactUsComponent } from './core/components/contact-us/contact-us.component';
import { HomePageComponent } from './core/components/home-page/home-page.component';
import { MainComponent } from './core/components/main/main.component';

const routes: Routes = [
  { path:"main", component:MainComponent, children:[
    {path:"home", component: HomePageComponent},
    {path:"contact", component: ContactUsComponent}
  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
