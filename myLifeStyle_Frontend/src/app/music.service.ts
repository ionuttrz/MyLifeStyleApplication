import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Music } from './music';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MusicService {
  private baseUrl = "http://localhost:8081/music/addMusic";
  constructor(private httpClient: HttpClient) { }

  public addMusic(music: Music): Observable<Music> {
    console.log(music);
    console.log(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'authorization': `Bearer ${localStorage.getItem('accessToken')}`
      })
    };
    console.log(httpOptions);
    const url = `${this.baseUrl}`;
    return this.httpClient.post<Music>(`${this.baseUrl}`, music, httpOptions);
  }
}
