import { Injectable } from '@angular/core';

import { HotToastService } from '@ngneat/hot-toast';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  errorMessage = (errorText: string): void => {
    this.toast.error(errorText)
  };

  warnMessage = (errorText: string): void => {
    this.toast.warning(errorText);
  };

  successMessage = (text: string): void => {
    this.toast.success(text);
  };



  constructor(
    private toast: HotToastService,
  ) {}
}
