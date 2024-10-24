import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoursAtGymChartComponent } from './hoursatgym-chart.component';

describe('DurationChartComponent', () => {
  let component: HoursAtGymChartComponent;
  let fixture: ComponentFixture<HoursAtGymChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoursAtGymChartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HoursAtGymChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
