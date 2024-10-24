import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbyartistComponent } from './searchbyartist.component';

describe('SearchbyartistComponent', () => {
  let component: SearchbyartistComponent;
  let fixture: ComponentFixture<SearchbyartistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchbyartistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchbyartistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
