import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Music } from '../music';

@Component({
  selector: 'app-showallmusic',
  templateUrl: './showallmusic.component.html',
  styleUrls: ['./showallmusic.component.css']
})
export class ShowallmusicComponent implements OnInit{
    public songs : Music[] = [];

    constructor(private http: HttpClient) {}

    fetchData() {
      this.http.get<any>(`http://localhost:8081/music/showallmusic`).subscribe(
        data => {
          this.songs = data; 
          console.log(data);
          console.log(this.songs[0]);
        },
        error => {
          console.log(error);
        }
      );
    }

    ngOnInit() {
          this.fetchData();
    }
}
