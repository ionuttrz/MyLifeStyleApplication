import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KmRunChartComponent } from './kmrun-chart.component';

describe('DurationChartComponent', () => {
  let component: KmRunChartComponent;
  let fixture: ComponentFixture<KmRunChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KmRunChartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KmRunChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
