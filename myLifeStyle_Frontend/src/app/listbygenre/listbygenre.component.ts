import { Component } from '@angular/core';
import { Music } from '../music';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-listbygenre',
  templateUrl: './listbygenre.component.html',
  styleUrls: ['./listbygenre.component.css']
})
export class ListbygenreComponent {
  public songs : Music[] = [];
  public selectedGenre: string;
  constructor(private http: HttpClient) {}

  fetchData() {
    this.http.get<any>(`http://localhost:8081/music/listbygenre?genre=${this.selectedGenre}`).subscribe(
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

  showByGenre() {
    this.fetchData();
  }

}
