import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

const baseUrl = 'http://localhost:8085/api/games/';

@Injectable({
  providedIn: 'root'
})
export class GameServiceService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get(baseUrl);
  }

  get(id: number){
    return this.http.get(`${baseUrl}${id}`);
  }

  create(game: any){
    return this.http.post(`${baseUrl}new`, game);
  }

  update(id: number, game: any){
    return this.http.put(`${baseUrl}${id}`, game);
  }

  delete(id: number){
    return this.http.delete(`${baseUrl}${id}`);
  }
}
