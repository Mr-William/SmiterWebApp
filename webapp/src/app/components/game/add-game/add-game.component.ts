import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GameServiceService } from 'src/app/services/game/game.service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-game.component.html'
})
export class AddGameComponent {
  gameForm = new FormGroup ({
    id: new FormControl(''),
    title: new FormControl('', Validators.required),
    genre: new FormControl(''),
    datecompleted: new FormControl(''),
    rating: new FormControl('')
  });

  book = {
  };
  enabled = false;

  constructor(private _gameService: GameServiceService){}

  addGame(){
    this._gameService.create(this.gameForm.value)
      .subscribe(
        response => {
          console.log(response);
          window.location.href="games";
        },
        error => {
          console.log(error);
        }
      );
  }

  resetForm(){
    this.gameForm.reset();

    this.enabled = false;
  }
}
