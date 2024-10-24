import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListbygenreComponent } from './listbygenre.component';

describe('ListbygenreComponent', () => {
  let component: ListbygenreComponent;
  let fixture: ComponentFixture<ListbygenreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListbygenreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListbygenreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
