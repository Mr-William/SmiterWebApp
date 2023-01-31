import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MusicServiceService } from 'src/app/services/music/music.service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-music.component.html'
})
export class AddMusicComponent {
  musicForm = new FormGroup ({
    id: new FormControl(''),
    title: new FormControl('', Validators.required),
    artist: new FormControl('', Validators.required),
    album: new FormControl(''),
    genre: new FormControl(''),
    datecompleted: new FormControl(Date),
    rating: new FormControl('')
  });

  book = {
  };
  enabled = false;

  constructor(private _musicService: MusicServiceService){}

  addMusic(){
    this._musicService.create(this.musicForm.value)
      .subscribe(
        response => {
          console.log(response);
          window.location.href="musics";
        },
        error => {
          console.log(error);
        }
      );
  }

  resetForm(){
    this.musicForm.reset();

    this.enabled = false;
  }
}
