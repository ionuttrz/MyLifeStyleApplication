import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Diet } from './diet';

@Injectable({
  providedIn: 'root'
})
export class DietService {

   private baseUrl = "http://localhost:8081/diet/calculateCalories";
  constructor(private httpClient: HttpClient) { }

  public addDiet(diet: Diet): Observable<Diet> {
    console.log(diet);
    console.log(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'authorization': `Bearer ${localStorage.getItem('accessToken')}`
      })
    };
    console.log(httpOptions);
    const url = `${this.baseUrl}`;
    return this.httpClient.post<Diet>(`${this.baseUrl}`, diet, httpOptions);
  }
}
