import { HttpEvent, HttpHandler, HttpRequest, HttpErrorResponse, HttpInterceptor } from '@angular/common/http';
import { Inject, Injectable, Injector } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { MessageService } from './message.service';


@Injectable({
  providedIn: 'root'
})
export class ErrorInterceptorService implements HttpInterceptor {
  constructor(@Inject(Injector) private readonly injector: Injector) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      retry(1),
      catchError((error: HttpErrorResponse) => {
        if (error.error instanceof ErrorEvent) {
          // client-side error
          this.notFoundMessage();
        } else {
          // server-side error
          if (!error.url?.includes('document')) {
            if (error.status === 409) this.conflictMessage();
            if (error.status === 404) this.notFoundMessage();
            if (error.status === 406) this.errormessage();
            if (error.status === 401) this.unauthorized();
            if (error.status === 500) this.serverErrorMessage();
          }
        }
        return EMPTY;
      })
    );
  }

  private conflictMessage(): void {
    this.toasterService.errorMessage('Please do not duplicate data');
  }

  private notFoundMessage(): void {
    this.toasterService.errorMessage('Please try again');
  }
  private errormessage(): void {
    this.toasterService.errorMessage(' Please enter Right Password');
  }
  private unauthorized(): void {
    this.toasterService.errorMessage('You do not have permission, please try again');
  }

  private serverErrorMessage(): void {
    this.toasterService.errorMessage('An error occurred communicating with the server, please try again');
  }


  private get toasterService(): MessageService {
    return this.injector.get(MessageService);
  }
}
