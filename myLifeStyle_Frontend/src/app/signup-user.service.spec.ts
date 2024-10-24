import { TestBed } from '@angular/core/testing';

import { SignupUserService } from './signup-user.service';

describe('SignupUserService', () => {
  let service: SignupUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignupUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
