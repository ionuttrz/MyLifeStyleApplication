import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Diet } from '../diet';
import { DietService } from '../diet.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent {
  public diet = new Diet();
  form!: FormGroup;
  dataValue: any;
  isCalculated:boolean = false;
  constructor(private formBuilder: FormBuilder,
            private router: Router,
            private http: HttpClient,
            private dietService: DietService) {}

  ngOnInit() {
    this.form = this.formBuilder.group({
      mass: ['', Validators.required],
      height: ['', Validators.required],
      age: ['', Validators.required],
      activity: ['', Validators.required]
    });
  }

  onSubmit(): void {
    console.log(this.diet);

    this.dietService.addDiet(this.diet).subscribe({
      next: data => {
        this.isCalculated = true;
        console.log(data);
        this.dataValue = data;
        alert("Calculate Calories");
      },
      error: err => {
        alert("Something wrong happen!");
        console.log(err);
      }
    });
  }

}
