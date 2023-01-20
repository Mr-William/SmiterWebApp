import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MovieServiceService } from 'src/app/services/movie/movie.service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-movie.component.html'
})
export class AddMovieComponent {
  movieForm = new FormGroup ({
    id: new FormControl(''),
    title: new FormControl('', Validators.required),
    genre: new FormControl(''),
    director: new FormControl(''),
    producer: new FormControl(''),
    rating: new FormControl('')
  });

  book = {
  };
  enabled = false;

  constructor(private _movieService: MovieServiceService){}

  addMovie(){
    this._movieService.create(this.movieForm.value)
      .subscribe(
        response => {
          console.log(response);
          window.location.href="movies";
        },
        error => {
          console.log(error);
        }
      );
  }

  resetForm(){
    this.movieForm.reset();

    this.enabled = false;
  }
}
