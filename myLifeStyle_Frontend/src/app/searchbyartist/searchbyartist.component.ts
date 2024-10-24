import { Component } from '@angular/core';
import { Music } from '../music';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-searchbyartist',
  templateUrl: './searchbyartist.component.html',
  styleUrls: ['./searchbyartist.component.css']
})
export class SearchbyartistComponent {
  public songs : Music[] = [];
  public selectedArtist: string;
  constructor(private http: HttpClient) {}

  fetchData() {
    this.http.get<any>(`http://localhost:8081/music/searchbyartist?artist=${this.selectedArtist}`).subscribe(
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

  showByArtist() {
    this.fetchData();
  }
}
