import { Component, OnInit } from '@angular/core';
import { HotToastService } from '@ngneat/hot-toast';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'candi-meter';
  constructor(private toast: HotToastService){

  }
  ngOnInit(): void {
    this.toast.success('Hello World!');
  }

}
