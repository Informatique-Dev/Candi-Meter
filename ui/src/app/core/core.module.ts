import { NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SharedModule } from 'src/shared/shared.module';
import { RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { SideBarListComponent } from './components/side-bar-list/side-bar-list.component';
import { HomePageComponent } from '../Pages/home-page/home-page.component';
import { ConfirmBoxConfigModule, NgxAwesomePopupModule, ToastNotificationConfigModule } from '@costlydeveloper/ngx-awesome-popup';
import { HotToastModule } from '@ngneat/hot-toast';
@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    MainComponent,
    SideBarListComponent,
    HomePageComponent,
    ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule,
    ToastNotificationConfigModule.forRoot(),
    HotToastModule.forRoot( {
      style:{
        border:'1px solid #713200',
        padding:'10px',
        margin:'170px',
        color:'#713200',
        'font-size':'25px',
        'width':'500px',
      },
    }
    ),
    NgxAwesomePopupModule.forRoot({
      colorList: {
        success: '#3caea3',
        info: '#2f8ee5',
        warning: '#ffc107',
        danger: '#e46464',
        customOne: '#3ebb1a',
        customTwo: '#bd47fa'
      },

    }),
    ConfirmBoxConfigModule.forRoot({
      confirmBoxCoreConfig: {
        customStyles: {
          textCSS: 'color: #454545; font-size: 25px; background: #FFFFFF; font-weight: bold;',
        }
      }
    }),
 ],
  providers: [

  ]
})
export class CoreModule {

  constructor (@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only');
    }
  }

 }
