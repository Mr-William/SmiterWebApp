import { Component, OnInit } from '@angular/core';
import { GameServiceService } from 'src/app/services/game/game.service.service';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html'
})
export class GameListComponent implements OnInit {
  overlay: any;
  pageTitle: string = 'Game List';
  errorMessage: string | undefined;
  game = {
    id: -1,
    title:'',
    genre:'',
    datecompleted:'',
    rating: null
  }

  games:any;

  constructor(private _gameService: GameServiceService){}

  ngOnInit(): void{
    this._gameService.getAll()
        .subscribe(games => this.games = games,
          error => this.errorMessage = <any>error);
    this.overlay = document.getElementById("overlay");
    this.overlay?.addEventListener("click", this.closeModal);
  }

  editDetails(id: number){
    document.getElementById("gameModal")?.classList.remove("hidden");
    document.getElementById("overlay")?.classList.remove("hidden");
    for(const element of this.games){
      if(element.id === id){
        this.game = element;
        break;
      }
    }
  }

  submitUpdate(){
    this._gameService.update(this.game.id, this.game)
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

  gameDelete(){
    if(confirm("Do you really want to delete this game?")){
      this._gameService.delete(this.game.id)
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
    window.location.href="games";
  }

  closeModal(){
    document.getElementById("overlay")?.classList.add("hidden");
    document.getElementById("gameModal")?.classList.add("hidden");
  }
}
