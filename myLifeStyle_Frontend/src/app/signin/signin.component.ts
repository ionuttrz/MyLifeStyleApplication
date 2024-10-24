import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule  } from '@angular/forms';
import { first } from 'rxjs/operators';
import { SignupUserService } from '../signup-user.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  user: User = new User();
  form!: FormGroup;
  loading = false;
  submitted = false;
  
  constructor(private formBuilder: FormBuilder,
              private router:Router,
              private signupUsreService: SignupUserService
              ){}

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      gender: ['', Validators.required],
      password: ['', [Validators.minLength(6)]]
    });
  }

  onSubmit() {
    this.submitted = true;

    console.log(this.user.name);
    console.log(this.user.email);
    console.log(this.user.gender);
    console.log(this.user.password);
    this.loading = true;
    this.signupUsreService.signupUser(this.user).subscribe({
      next: data => {
        console.log(data);
        console.log("yes");
        this.router.navigate(['/login']);
      },
      error: err => {
        alert("Something went wrong, try to sign up again!");
        console.log(err);
      }
    });
  }
}
