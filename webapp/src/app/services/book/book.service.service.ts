import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

const baseUrl = 'http://localhost:8085/api/books/';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get(baseUrl);
  }

  get(id: number){
    return this.http.get(`${baseUrl}${id}`);
  }

  create(book: any){
    return this.http.post(`${baseUrl}new`, book);
  }

  update(id: number, book: any){
    return this.http.put(`${baseUrl}${id}`, book);
  }

  delete(id: number){
    return this.http.delete(`${baseUrl}${id}`);
  }
}
