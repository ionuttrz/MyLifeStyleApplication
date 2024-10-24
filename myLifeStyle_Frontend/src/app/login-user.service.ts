import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginUserService {
  private baseUrl = "http://localhost:8081/user/login";

  constructor(private httpClient: HttpClient) {

  }

  loginUser(user: User): Observable<object> {
    console.log(user);
    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*');
    return this.httpClient.post(`${this.baseUrl}`, user, {
      headers: headers
    }).pipe(tap( (resp: any) => localStorage.setItem('accessToken',  resp.accessToken)));
  }
}
