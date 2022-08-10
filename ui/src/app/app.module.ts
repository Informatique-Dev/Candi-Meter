import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoreModule } from './core/core.module';
import { ConfigService } from './core/services/config/config.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { ToastNotificationConfigModule ,NgxAwesomePopupModule} from '@costlydeveloper/ngx-awesome-popup';
import { HotToastModule } from '@ngneat/hot-toast';
import { ErrorInterceptorService } from './core/services/config/error-interceptor.service';


export function configServiceFactory(config: ConfigService): () => Promise<boolean> {
  return (): Promise<boolean> => config.load();
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    BrowserAnimationsModule,
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
  ],
  providers: [
    ConfigService,
    {
      provide: APP_INITIALIZER,
      useFactory: configServiceFactory,
      deps: [ConfigService],
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
