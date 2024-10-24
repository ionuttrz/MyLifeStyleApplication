import { Component, OnInit } from '@angular/core';
import { Music } from '../music';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MusicService } from '../music.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.css']
})
export class MusicComponent  implements OnInit{
  music: Music = new Music();
  form!: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private musicService: MusicService,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      emailUser: ['', Validators.required],
      songName: ['', Validators.required],
      artist: ['', Validators.required],
      genre: ['', Validators.required]
    });
  }

  onSubmit(): void {
    console.log(this.music);

    this.musicService.addMusic(this.music).subscribe({
      next: data => {
        console.log(data);
        alert("New Music Added");
      },
      error: err => {
        alert("This song was already added!");
        console.log(err);
      }
    });
  }

showAllMusicComponent: boolean = false;
listByGenreComponent: boolean = false;
searchByArtistComponent: boolean = false;

showAllMusic() {
  this.showAllMusicComponent = true;
  this.listByGenreComponent = false;
  this.searchByArtistComponent = false;
}

listByGenre() {
  this.showAllMusicComponent = false;
  this.listByGenreComponent = true;
  this.searchByArtistComponent = false;
}

searchByArtist() {
  this.showAllMusicComponent = false;
  this.listByGenreComponent = false;
  this.searchByArtistComponent = true;
}

}
