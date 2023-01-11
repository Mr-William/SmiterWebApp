angular.module('SmiterApp').factory('MovieService', ['$http', '$log', function($http, $log) { 
	
	let REST_SERVICE_URI = 'http://localhost:8085/api/movies/'
	
	let factory = {
		createMovie,
		deleteMovie,
		findMovie,
		getAllMovies,
		updateMovie
	};
	
	return factory;
	
	function getAllMovies(){
		return $http.get(REST_SERVICE_URI).then(function(response){
			return response.data;
		})
	}
	
	function createMovie(movie){
		return $http.post(REST_SERVICE_URI + "new", movie).then(function(response){
			return response.data;
		})
	}
	
	function deleteMovie(movieId){
		return $http.delete(REST_SERVICE_URI + movieId).then(function(response){
			return response.data;
		})
	}
	
	function findMovie(movieId){
		return $http.get(REST_SERVICE_URI, {params: {id : movieId}}).then(function(response){
			return response.data;
		})
	}

	function updateMovie(movie){
		return $http.put(REST_SERVICE_URI + movie.id, movie).then(function(response){
			return response.data;
		})
	}
}]);