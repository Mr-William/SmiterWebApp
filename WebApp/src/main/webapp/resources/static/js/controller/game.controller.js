angular.module('SmiterApp').controller('GameController',
	['$scope', 'GameService', function($scope, GameService){
		let self = this;
		self.game = {
			id : '',
			title : '',
			genre : '',
			datecompleted :''
		};

		self.error='';
		self.message='';
		self.reset=reset;
		const bkmodal = document.querySelector(".game-modal");
		const overlay = document.querySelector(".overlay");
		const closeModalBtn = document.querySelector(".btn-close");

		self.games = [];
			
		const closeModal = function(){
			bkmodal.classList.add("hidden");
			overlay.classList.add("hidden");
		}

		closeModalBtn.addEventListener("click", closeModal);
		overlay.addEventListener("click", closeModal);

		self.getAllGames = function(){
			GameService.getAllGames().then(function(data){
				data.datecompleted = new Date(data.datecompleted);
				self.games = data;
			})
		}
		
		self.createGame = function(){
			self.game.datecompleted = new Date(self.game.datecompleted);
			return GameService.createGame(self.game).then(function(data){
				console.log("the date:" + self.game.datecompleted);
				window.location.href="/games";
			})
		}
		
		self.deleteGame = function(id){
			return GameService.deleteGame(id).then(function(){
				self.fetchAllGames();
			})
		}
		
		self.findGame = function(game){
			return GameService.findGame(game.id).then(function(data){
				self.game = data;
			})
		}

		$scope.submitUpdate = function(){
			console.log("gameId = " + self.game.id);
			console.log("self.gameTitle=" + self.game.gameTitle);
			return GameService.updateGame(self.game, self.id).then(function(data){
				closeModal();
				self.getAllGames();
			})
		}

		$scope.gameDelete = function(){
			console.log(self.game.id);
			if(confirm("Do you really want to delete this game?")){
				return GameService.deleteGame(self.game.id).then(function(data){
				closeModal();
				self.getAllGames();
				})
			}
			else
				return false;
		}

		self.editDetails = function(id){
			bkmodal.classList.remove("hidden");
			overlay.classList.remove("hidden");
			for(const element of self.games){
				if(element.id === id){
					self.game = angular.copy(element);
                    self.game.datecompleted = new Date(self.game.datecompleted);
					break;
				}
			}
		}

		function reset(){
			self.game={id:null,title:'',genre:'',datecompleted:''};
			$scope.gameForm.$setPristine();
		}
		
		function clrMsg(){
		self.error = '';
		self.message = '';
	}

		
		self.getAllGames();
	}])