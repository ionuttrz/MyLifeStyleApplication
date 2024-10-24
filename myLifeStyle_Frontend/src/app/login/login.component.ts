import { Component } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { LoginUserService } from '../login-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user: User = new User();

  constructor(private loginuserservice: LoginUserService, private router:Router){

  }
  
  onSubmit(): void {
    this.router.navigate(['/menu']);
  }

  userLogin(){
    console.log(this.user);
    this.loginuserservice.loginUser(this.user).subscribe(data=>{
      alert("Login Successfully");
      this.router.navigate(['/menu']);
    },error=>{
      alert("Sorry, please enter correct Id and password");
      this.router.navigate(['/login']);
    });
    
  }

  userSignUp(){
      this.router.navigate(['/signin']);
  }

}
