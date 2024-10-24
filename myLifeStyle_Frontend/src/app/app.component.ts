import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'myLifeStyle_FrontEnd';
  showHome: boolean = true;

  hideHome() {
    this.showHome = false;
    // Store the updated showHome value in local storage
    localStorage.setItem('showHome', JSON.stringify(this.showHome));
  }
}
 