import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Record } from './record';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecordService {
  private baseUrl = "http://localhost:8081/record/addRecord";
  constructor(private httpClient: HttpClient) { }

  public addRecord(record: Record): Observable<Record> {
    console.log(record);
    console.log(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'authorization': `Bearer ${localStorage.getItem('accessToken')}`
      })
    };
    console.log(httpOptions);
    const url = `${this.baseUrl}`;
    return this.httpClient.post<Record>(`${this.baseUrl}`, record, httpOptions);
  }
}
