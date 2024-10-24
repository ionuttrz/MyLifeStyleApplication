import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NrOfDaysService {

  nrOfDays: number = 6;

  constructor() { }

  getNrOfDays(): number {
    return this.nrOfDays;
  }

  setNrOfDays(nrOfDays: number) {
    this.nrOfDays = nrOfDays;
  }
}
