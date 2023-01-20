import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './components/home/welcome.component';
import { AddBookComponent } from './components/book/add-book/add-book.component';
import { BookListComponent } from './components/book/book-list/book-list.component';
import { AddGameComponent } from './components/game/add-game/add-game.component';
import { GameListComponent } from './components/game/game-list/game-list.component';
import { AddMovieComponent } from './components/movie/add-movie/add-movie.component';
import { MovieListComponent } from './components/movie/movie-list/movie-list.component';
import { AddMusicComponent } from './components/music/add-music/add-music.component';
import { MusicListComponent } from './components/music/music-list/music-list.component';

const routes: Routes = [
  { path: 'home', component: WelcomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'books', component: BookListComponent },
  { path: 'addbook', component: AddBookComponent },
  { path: 'games', component: GameListComponent },
  { path: 'addgame', component: AddGameComponent },
  { path: 'movies', component: MovieListComponent },
  { path: 'addmovie', component: AddMovieComponent },
  { path: 'music', component: MusicListComponent },
  { path: 'addmusic', component: AddMusicComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
