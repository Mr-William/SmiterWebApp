import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BookServiceService } from 'src/app/services/book/book.service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html'
})
export class AddBookComponent {
  bookForm = new FormGroup ({
    id: new FormControl(''),
    title: new FormControl('', Validators.required),
    author: new FormControl('', Validators.required),
    genre: new FormControl(''),
    datecompleted: new FormControl(''),
    rating: new FormControl('')
  });

  book = {
  };
  enabled = false;

  constructor(private _bookService: BookServiceService){}

  addBook(){
    this._bookService.create(this.bookForm.value)
      .subscribe(
        response => {
          console.log(response);
          window.location.href="books";
        },
        error => {
          console.log(error);
        }
      );
  }

  resetForm(){
    this.bookForm.reset();

    this.enabled = false;
  }
}
