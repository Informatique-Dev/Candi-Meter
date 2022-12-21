import { Component, Input } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass'],
})
export class HeaderComponent {
  @Input() sideNavItem: MatSidenav;
  constructor(private translate: TranslateService) {}

  clickMenu() {
    this.sideNavItem.toggle();
  }

  selectTranslate(event: any) {
    this.translate.use(event.target.value);
  }
}
