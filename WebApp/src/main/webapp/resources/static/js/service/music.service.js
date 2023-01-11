angular.module('SmiterApp').factory('MusicService', ['$http', '$log', function($http, $log) { 
	
	let REST_SERVICE_URI = 'http://localhost:8085/api/musics/'
	
	let factory = {
		createMusic,
		deleteMusic,
		findMusic,
		getAllMusics,
		updateMusic
	};
	
	return factory;
	
	function getAllMusics(){
		return $http.get(REST_SERVICE_URI).then(function(response){
			return response.data;
		})
	}
	
	function createMusic(music){
		return $http.post(REST_SERVICE_URI + "new", music).then(function(response){
			return response.data;
		})
	}
	
	function deleteMusic(musicId){
		return $http.delete(REST_SERVICE_URI + musicId).then(function(response){
			return response.data;
		})
	}
	
	function findMusic(musicId){
		return $http.get(REST_SERVICE_URI, {params: {id : musicId}}).then(function(response){
			return response.data;
		})
	}

	function updateMusic(music){
		return $http.put(REST_SERVICE_URI + music.id, music).then(function(response){
			return response.data;
		})
	}
}]);