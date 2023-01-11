angular.module('SmiterApp').factory('GameService', ['$http', '$log', function($http, $log) { 
	
	let REST_SERVICE_URI = 'http://localhost:8085/api/games/'
	
	let factory = {
		createGame,
		deleteGame,
		findGame,
		getAllGames,
		updateGame
	};
	
	return factory;
	
	function getAllGames(){
		return $http.get(REST_SERVICE_URI).then(function(response){
			return response.data;
		})
	}
	
	function createGame(game){
		return $http.post(REST_SERVICE_URI + "new", game).then(function(response){
			return response.data;
		})
	}
	
	function deleteGame(gameId){
		return $http.delete(REST_SERVICE_URI + gameId).then(function(response){
			return response.data;
		})
	}
	
	function findGame(gameId){
		return $http.get(REST_SERVICE_URI, {params: {id : gameId}}).then(function(response){
			return response.data;
		})
	}

	function updateGame(game){
		return $http.put(REST_SERVICE_URI + game.id, game).then(function(response){
			return response.data;
		})
	}
}]);