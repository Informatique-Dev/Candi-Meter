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
  lang: string = 'en';

  constructor(private translate: TranslateService) {
    this.lang = this.translate.currentLang;
  }

  clickMenu() {
    this.sideNavItem.toggle();
  }

  selectTranslate() {
    // this.translate.use(event.target.value);
    if (this.lang == 'en') {
      localStorage.setItem('lang', 'ar');
    } else {
      localStorage.setItem('lang', 'en');
    }
    window.location.reload();
  }
}
