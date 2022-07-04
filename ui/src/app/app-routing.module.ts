import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './core/components/main/main.component';
import { PageNotFoundComponent } from './Pages/page-not-found/page-not-found.component';

const routes: Routes = [

    { path:"main", component:MainComponent, children:[
    { path: '',loadChildren: () => import('./Pages/pages.module').then(m => m.PagesModule)},
  ] ,
},
{ path: '',loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)},

{path:"**",component:PageNotFoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
