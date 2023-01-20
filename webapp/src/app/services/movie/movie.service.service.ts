import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

const baseUrl = 'http://localhost:8085/api/movies/';

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get(baseUrl);
  }

  get(id: number){
    return this.http.get(`${baseUrl}${id}`);
  }

  create(movie: any){
    return this.http.post(`${baseUrl}new`, movie);
  }

  update(id: number, movie: any){
    return this.http.put(`${baseUrl}${id}`, movie);
  }

  delete(id: number){
    return this.http.delete(`${baseUrl}${id}`);
  }
}
