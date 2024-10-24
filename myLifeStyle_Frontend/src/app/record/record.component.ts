import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Record } from '../record';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RecordService } from '../record.service';
import { HttpClient } from '@angular/common/http';
import { NrOfDaysService } from '../nr-of-days.service';

@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})
export class RecordComponent {
  selectedDate: string = '';
  selectedDuration: number = 1;
  selectedStress: number = 1;
  selectedEnergy: number = 1;
  selectedTag: string = 'neutral';

  showKmChart: boolean = false;
  showHoursAtGymChart: boolean = false;
  showDrinkingWaterChart: boolean = false;

  showWeekly: boolean = true;
  showMonthly: boolean = false;

  nrOfDays: number;

  buttonKm() {
    this.showKmChart = true;

    this.showHoursAtGymChart = false;
    this.showDrinkingWaterChart = false;
  }

  buttonHoursAtGym() {
    this.showHoursAtGymChart = true;

    this.showKmChart = false;
    this.showDrinkingWaterChart = false;
  }

  buttonDrinkingWater() {
    this.showDrinkingWaterChart = true;

    this.showKmChart = false;
    this.showHoursAtGymChart = false;
  }

  onStrategyChange(event: any) {
    const selectedStrategy = event.target.value;
    if (selectedStrategy === 'Week') {
      this.showWeekly = true;
      this.showMonthly = false;
      this.nrOfDaysService.setNrOfDays(6);
    } else if (selectedStrategy === 'Month') {
      this.showWeekly = false;
      this.showMonthly = true;
      this.nrOfDaysService.setNrOfDays(29);
    }

  }

  record: Record = new Record();
  form!: FormGroup;
  loading = false;
  submitted = false;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private recordService: RecordService,
    private http: HttpClient,
    private nrOfDaysService: NrOfDaysService
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      emailUser: ['', Validators.required],
      date: ['', Validators.required],
      kmRun: ['', Validators.required],
      hoursAtTheGym: ['', Validators.required],
      drinkingWater: ['', Validators.required],
    });
    this.nrOfDays = this.nrOfDaysService.getNrOfDays();
  }

  onSubmit() {
    this.submitted = true;

    console.log(this.record.emailUser);
    console.log(this.record.date);
    console.log(this.record.kmRun);
    console.log(this.record.hoursAtTheGym);
    console.log(this.record.drinkingWater);
    this.loading = true;
    this.recordService.addRecord(this.record).subscribe({
      next: data => {
        console.log(data);
        console.log("yes");
        alert("New Record Added");
      },
      error: err => {
        console.log(err);
      }
    });
  }
}

