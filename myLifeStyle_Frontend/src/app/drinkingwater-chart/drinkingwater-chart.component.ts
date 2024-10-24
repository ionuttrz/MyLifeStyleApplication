import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BaseChartDirective } from 'ng2-charts';
import { NrOfDaysService } from '../nr-of-days.service';


@Component({
  selector: 'app-drinkingwater-chart',
  templateUrl: './drinkingwater-chart.component.html',
  styleUrls: ['./drinkingwater-chart.component.css']
})
export class DrinkingWaterChartComponent implements OnInit{
  
  @ViewChild(BaseChartDirective) chart: BaseChartDirective;
  constructor(private http: HttpClient, 
              private nrOfDaysService: NrOfDaysService) {}

  public barChartType: ChartType = 'bar';
  public barChartLabels: string[] = [];
  public barChartOptions: ChartOptions = {
    responsive: true,
  };

  private formatDate(date: Date): string {
    const daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    const dayOfWeek = daysOfWeek[date.getDay()];
    const month = date.getMonth() + 1;
    const dayOfMonth = date.getDate();
    return `${dayOfWeek} (${month}/${dayOfMonth})`;
  }


  public barChartData: ChartDataset[] = [
    { data : [], 
      label: 'Drinking Water',
      backgroundColor: '', 
      borderColor: 'rgba(0, 0, 0, 1)',
      borderWidth: 1 }
  ];



  fetchData(nrDays:number) {
    this.http.get<any>(`http://localhost:8081/record/getDrinkingWater?days=${nrDays}`).subscribe(
      data => {
        this.barChartData[0].data = data.data;
        this.barChartData[0].backgroundColor = data.backgroundColor;
        console.log(data);
        console.log(this.barChartData[0]);
        this.chart.update();
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit() {
    const days = this.nrOfDaysService.getNrOfDays();
    this.fetchData(days);
    
    const today = new Date();
    for (let i = days; i >= 0; i--) {
      const date = new Date(today);
      date.setDate(today.getDate() - i);
      //console.log(date);
      this.barChartLabels.push(this.formatDate(date));
    }
  }  
  
}
