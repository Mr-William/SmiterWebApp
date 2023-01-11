angular.module('SmiterApp').factory('BookService', ['$http', '$log', function($http, $log) { 
	
	let REST_SERVICE_URI = 'http://localhost:8085/api/books/'
	
	let factory = {
		createBook,
		deleteBook,
		findBook,
		getAllBooks,
		updateBook
	};
	
	return factory;
	
	function getAllBooks(){
		return $http.get(REST_SERVICE_URI).then(function(response){
			return response.data;
		})
	}
	
	function createBook(book){
		return $http.post(REST_SERVICE_URI + "new", book).then(function(response){
			return response.data;
		})
	}
	
	function deleteBook(bookId){
		return $http.delete(REST_SERVICE_URI + bookId).then(function(response){
			return response.data;
		})
	}
	
	function findBook(bookId){
		return $http.get(REST_SERVICE_URI, {params: {id : bookId}}).then(function(response){
			return response.data;
		})
	}

	function updateBook(book){
		return $http.put(REST_SERVICE_URI + book.id, book).then(function(response){
			return response.data;
		})
	}
}]);