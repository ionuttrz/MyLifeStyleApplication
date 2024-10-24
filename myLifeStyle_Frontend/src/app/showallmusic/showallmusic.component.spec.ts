import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowallmusicComponent } from './showallmusic.component';

describe('ShowallmusicComponent', () => {
  let component: ShowallmusicComponent;
  let fixture: ComponentFixture<ShowallmusicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowallmusicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowallmusicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
