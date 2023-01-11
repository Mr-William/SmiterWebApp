angular.module('SmiterApp').controller('MovieController',
	['$scope', 'MovieService', function($scope, MovieService){
		let self = this;
		self.movie = {
			id : '',
			title : '',
			genre : '',
            producer:'',
            director:''
		};

		self.error='';
		self.message='';
		self.reset=reset;
		const bkmodal = document.querySelector(".movie-modal");
		const overlay = document.querySelector(".overlay");
		const closeModalBtn = document.querySelector(".btn-close");

		self.movies = [];
			
		const closeModal = function(){
			bkmodal.classList.add("hidden");
			overlay.classList.add("hidden");
		}

		closeModalBtn.addEventListener("click", closeModal);
		overlay.addEventListener("click", closeModal);

		self.getAllMovies = function(){
			MovieService.getAllMovies().then(function(data){
				self.movies = data;
			})
		}
		
		self.createMovie = function(){
			return MovieService.createMovie(self.movie).then(function(data){
				window.location.href="/movies";
			})
		}
		
		self.deleteMovie = function(id){
			return MovieService.deleteMovie(id).then(function(){
				self.fetchAllMovies();
			})
		}
		
		self.findMovie = function(movie){
			return MovieService.findMovie(movie.id).then(function(data){
				self.movie = data;
			})
		}

		$scope.submitUpdate = function(){
			console.log("movieId = " + self.movie.id);
			console.log("self.movieTitle=" + self.movie.movieTitle);
			return MovieService.updateMovie(self.movie, self.id).then(function(data){
				closeModal();
				self.getAllMovies();
			})
		}

		$scope.movieDelete = function(){
			console.log(self.movie.id);
			if(confirm("Do you really want to delete this movie?")){
				return MovieService.deleteMovie(self.movie.id).then(function(data){
				closeModal();
				self.getAllMovies();
				})
			}
			else
				return false;
		}

		self.editDetails = function(id){
			bkmodal.classList.remove("hidden");
			overlay.classList.remove("hidden");
			for(const element of self.movies){
				if(element.id === id){
					self.movie = angular.copy(element);
					break;
				}
			}
		}

		function reset(){
			self.movie={id:null,title:'',genre:'',producer:'',director:''};
			$scope.movieForm.$setPristine();
		}
		
		function clrMsg(){
		self.error = '';
		self.message = '';
	}

		
		self.getAllMovies();
	}])