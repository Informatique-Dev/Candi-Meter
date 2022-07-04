import { NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SharedModule } from 'src/shared/shared-module/shared.module';
import { RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { SideBarListComponent } from './components/side-bar-list/side-bar-list.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    MainComponent,
    SideBarListComponent,
    ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule
 ],
  providers: []
})
export class CoreModule {

  constructor (@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only');
    }
  }

 }
