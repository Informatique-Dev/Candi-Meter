import { Injectable } from '@angular/core';

import { HotToastService } from '@ngneat/hot-toast';
import { ConfirmBoxEvokeService } from '@costlydeveloper/ngx-awesome-popup';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  delete(id: number) {
    throw new Error('Method not implemented.');
  }
  errorMessage = (errorText: string): void => {
    this.toast.error(errorText)
  };

  warnMessage = (errorText: string): void => {
    this.toast.warning(errorText);
  };

  successMessage = (text: string): void => {
    this.toast.success(text);
  };

  deleteConfirmation = (header: string, body: string): Observable<any> => {
    return this.confirmBoxEvokeService.warning(header, body, 'Confirm', 'Cancel');
  };

  constructor(
    private toast: HotToastService,
    private confirmBoxEvokeService: ConfirmBoxEvokeService
  ) {}
}
