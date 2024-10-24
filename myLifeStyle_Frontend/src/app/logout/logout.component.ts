import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {

  constructor(private router:Router){}

  logOut(){
    let removeToken = localStorage.removeItem('accessToken');
    if(removeToken == null){
      this.router.navigate(['/login']);
      alert("Logout Successfully");
    }
  }
}
