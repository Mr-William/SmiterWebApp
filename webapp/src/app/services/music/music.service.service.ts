import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

const baseUrl = 'http://localhost:8085/api/musics/';

@Injectable({
  providedIn: 'root'
})
export class MusicServiceService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get(baseUrl);
  }

  get(id: number){
    return this.http.get(`${baseUrl}${id}`);
  }

  create(music: any){
    return this.http.post(`${baseUrl}new`, music);
  }

  update(id: number, music: any){
    return this.http.put(`${baseUrl}${id}`, music);
  }

  delete(id: number){
    return this.http.delete(`${baseUrl}${id}`);
  }
}
