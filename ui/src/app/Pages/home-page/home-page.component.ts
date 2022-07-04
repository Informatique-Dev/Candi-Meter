import { animate, style, transition, trigger } from '@angular/animations';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.sass'],
  animations: [
    trigger('side', [
      transition(':enter', [
        style({transform: "translateY(-20px)"}),
        animate(1000)
      ])
    ]),
    trigger('card-came-left', [
      transition(':enter', [
        style({transform: "translateX(300px)"}),
        animate(600)
      ])
    ])
  ]
})
export class HomePageComponent{

  constructor() { }
}
