import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupUserService {
  private baseUrl = "http://localhost:8081/user/register";
  constructor(private httpClient: HttpClient) { }

  public signupUser(user: User): Observable<User> {
    console.log(user);
    return this.httpClient.post<User>(`${this.baseUrl}`, user);
  }
}
