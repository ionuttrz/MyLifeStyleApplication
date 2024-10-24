import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrinkingWaterChartComponent } from './drinkingwater-chart.component';

describe('StressChartComponent', () => {
  let component: DrinkingWaterChartComponent;
  let fixture: ComponentFixture<DrinkingWaterChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DrinkingWaterChartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DrinkingWaterChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
