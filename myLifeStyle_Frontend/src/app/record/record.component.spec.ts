import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetricsComponent } from './record.component';

describe('MetricsComponent', () => {
  let component: MetricsComponent;
  let fixture: ComponentFixture<MetricsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MetricsComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(MetricsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
