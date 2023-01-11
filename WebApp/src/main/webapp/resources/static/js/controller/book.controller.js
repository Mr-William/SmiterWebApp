angular.module('SmiterApp').controller('BookController',
	['$scope', 'BookService', function($scope, BookService){
		let self = this;
		self.book = {
			id : '',
			title : '',
			author : '', 
			genre : '',
			datecompleted :''
		};

		self.error='';
		self.message='';
		self.reset=reset;
		const bkmodal = document.querySelector(".book-modal");
		const overlay = document.querySelector(".overlay");
		const closeModalBtn = document.querySelector(".btn-close");

		self.books = [];
			
		const closeModal = function(){
			bkmodal.classList.add("hidden");
			overlay.classList.add("hidden");
		}

		closeModalBtn.addEventListener("click", closeModal);
		overlay.addEventListener("click", closeModal);

		self.getAllBooks = function(){
			BookService.getAllBooks().then(function(data){
				data.datecompleted = new Date(data.datecompleted);
				self.books = data;
			})
		}
		
		self.createBook = function(){
			self.book.datecompleted = new Date(self.book.datecompleted);
			return BookService.createBook(self.book).then(function(data){
				console.log("the date:" + self.book.datecompleted);
				window.location.href="/books";
			})
		}
		
		self.deleteBook = function(id){
			return BookService.deleteBook(id).then(function(){
				self.fetchAllBooks();
			})
		}
		
		self.findBook = function(book){
			return BookService.findBook(book.id).then(function(data){
				self.book = data;
			})
		}

		$scope.submitUpdate = function(){
			console.log("bookId = " + self.book.id);
			console.log("self.bookTitle=" + self.book.bookTitle);
			return BookService.updateBook(self.book, self.id).then(function(data){
				closeModal();
				self.getAllBooks();
			})
		}

		$scope.bookDelete = function(){
			console.log(self.book.id);
			if(confirm("Do you really want to delete this book?")){
				return BookService.deleteBook(self.book.id).then(function(data){
				closeModal();
				self.getAllBooks();
				})
			}
			else
				return false;
		}

		self.editDetails = function(id){
			bkmodal.classList.remove("hidden");
			overlay.classList.remove("hidden");
			for(const element of self.books){
				if(element.id === id){
					self.book = angular.copy(element);
					break;
				}
			}
		}

		function reset(){
			self.book={id:null,title:'',author:'',genre:''};
			$scope.bookForm.$setPristine();
		}
		
		function clrMsg(){
		self.error = '';
		self.message = '';
	}

		
		self.getAllBooks();
	}])