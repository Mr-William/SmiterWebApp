import { Component, OnInit } from '@angular/core';
import { MusicServiceService } from 'src/app/services/music/music.service.service';

@Component({
  selector: 'app-music-list',
  templateUrl: './music-list.component.html'
})
export class MusicListComponent implements OnInit {
  overlay: any;
  pageTitle: string = 'Music List';
  errorMessage: string | undefined;
  music = {
    id: -1,
    title:'',
    album:'',
    artist:'',
    genre:'',
    rating: null
  }

  musics:any;

  constructor(private _musicService: MusicServiceService){}

  ngOnInit(): void{
    this._musicService.getAll()
        .subscribe(musics => this.musics = musics,
          error => this.errorMessage = <any>error);
    this.overlay = document.getElementById("overlay");
    this.overlay?.addEventListener("click", this.closeModal);
  }

  editDetails(id: number){
    document.getElementById("musicModal")?.classList.remove("hidden");
    document.getElementById("overlay")?.classList.remove("hidden");
    for(const element of this.musics){
      if(element.id === id){
        this.music = element;
        break;
      }
    }
  }

  submitUpdate(){
    this._musicService.update(this.music.id, this.music)
    .subscribe(
      response => {
        console.log(response);

      },
      error => {
        console.log(error);
      }
    );

    this.closeModal();
  }

  musicDelete(){
    if(confirm("Do you really want to delete this music?")){
      this._musicService.delete(this.music.id)
      .subscribe(
        response => {
          console.log(response);
        },
        error => {
          console.log(error);
        }
      );
    }
    this.closeModal();
    window.location.href="music";
  }

  closeModal(){
    document.getElementById("overlay")?.classList.add("hidden");
    document.getElementById("musicModal")?.classList.add("hidden");
  }
}
