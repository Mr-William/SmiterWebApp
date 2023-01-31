import { Component, OnInit } from '@angular/core';
import { BookServiceService } from 'src/app/services/book/book.service.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html'
})
export class BookListComponent implements OnInit {
  overlay:any;
  pageTitle: string = 'Book List';
  errorMessage: string | undefined;
  book = {
    id: -1,
    title:'',
    author:'',
    genre:'',
    datecompleted:'',
    rating: null
  }

  books:any;

  constructor(private _bookService: BookServiceService){}

  ngOnInit(): void{
    this._bookService.getAll()
        .subscribe(books => this.books = books,
          error => this.errorMessage = <any>error);
    this.overlay = document.getElementById("overlay");
    this.overlay?.addEventListener("click", this.closeModal);
  }

  editDetails(id: number){
    document.getElementById("bookModal")?.classList.remove("hidden");
    document.getElementById("overlay")?.classList.remove("hidden");
    for(const element of this.books){
      if(element.id === id){
        this.book = element;
        break;
      }
    }
  }

  submitUpdate(){
    this._bookService.update(this.book.id, this.book)
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

  bookDelete(){
    if(confirm("Do you really want to delete this book?")){
      this._bookService.delete(this.book.id)
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
    window.location.href="books";
  }

  closeModal(){
    document.getElementById("overlay")?.classList.add("hidden");
    document.getElementById("bookModal")?.classList.add("hidden");
  }
}
