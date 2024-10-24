import { TestBed } from '@angular/core/testing';

import { NrOfDaysService } from './nr-of-days.service';

describe('NrOfDaysService', () => {
  let service: NrOfDaysService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NrOfDaysService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
