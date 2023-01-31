import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBookComponent } from './components/book/add-book/add-book.component';
import { BookListComponent } from './components/book/book-list/book-list.component';
import { AddGameComponent } from './components/game/add-game/add-game.component';
import { GameListComponent } from './components/game/game-list/game-list.component';
import { AddMovieComponent } from './components/movie/add-movie/add-movie.component';
import { MovieListComponent } from './components/movie/movie-list/movie-list.component';
import { AddMusicComponent } from './components/music/add-music/add-music.component';
import { MusicListComponent } from './components/music/music-list/music-list.component';
import { NgbModule, NgbRating } from '@ng-bootstrap/ng-bootstrap';
import { NgIf } from '@angular/common';

@NgModule({
    declarations: [
        AppComponent,
        AddBookComponent,
        BookListComponent,
        AddGameComponent,
        GameListComponent,
        AddMovieComponent,
        MovieListComponent,
        AddMusicComponent,
        MusicListComponent
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        NgbModule,
        FormsModule, 
        ReactiveFormsModule,
        NgbRating,
        NgIf
    ]
})
export class AppModule { }
