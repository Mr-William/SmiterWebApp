import { Component, OnInit } from '@angular/core';
import { MovieServiceService } from 'src/app/services/movie/movie.service.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html'
})
export class MovieListComponent implements OnInit {
  overlay: any;
  pageTitle: string = 'Movie List';
  errorMessage: string | undefined;
  movie = {
    id: -1,
    title:'',
    genre:'',
    producer:'',
    director:'',
    rating: null
  }

  movies:any;

  constructor(private _movieService: MovieServiceService){}

  ngOnInit(): void{
    this._movieService.getAll()
        .subscribe(movies => this.movies = movies,
          error => this.errorMessage = <any>error);
    this.overlay = document.getElementById("overlay");
    this.overlay?.addEventListener("click", this.closeModal);
  }

  editDetails(id: number){
    document.getElementById("movieModal")?.classList.remove("hidden");
    document.getElementById("overlay")?.classList.remove("hidden");
    for(const element of this.movies){
      if(element.id === id){
        this.movie = element;
        break;
      }
    }
  }

  submitUpdate(){
    this._movieService.update(this.movie.id, this.movie)
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

  movieDelete(){
    if(confirm("Do you really want to delete this movie?")){
      this._movieService.delete(this.movie.id)
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
    window.location.href="movies";
  }

  closeModal(){
    document.getElementById("overlay")?.classList.add("hidden");
    document.getElementById("movieModal")?.classList.add("hidden");
  }
}
