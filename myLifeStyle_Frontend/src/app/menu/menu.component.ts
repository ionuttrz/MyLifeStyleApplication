import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(private router: Router) {}

  navigateToMusic(): void {
    // Navigate to the music page
    this.router.navigate(['/music']);
  }

  navigateToDiet(): void {
    // Navigate to the diet page
    this.router.navigate(['/diet']);
  }

  navigateToStats(): void {
    // Navigate to the stats page
    this.router.navigate(['/record']);
  }
}
