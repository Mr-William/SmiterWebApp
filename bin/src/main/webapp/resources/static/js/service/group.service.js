angular.module('SmiterApp').factory('SmiterService', ['$http', '$log', function($http, $log) { 
	
	let REST_SERVICE_URI = 'groups/'
	
	let factory = {
		createGroup,
		deleteGroup,
		findGroup,
		getAllGroups
	};
	
	return factory;
	
	function getAllGroups(){
		return $http.get(REST_SERVICE_URI + "all").then(function(response){
			return response.data;
		})
	}
	
	function createGroup(){
		return $http.post(REST_SERVICE_URI + "create").then(function(response){
			return response.data;
		})
	}
	
	function deleteGroup(groupId){
		return $http.delete(REST_SERVICE_URI + groupId).then(function(response){
			return response.data;
		})
	}
	
	function findGroup(groupId){
		return $http.get(REST_SERVICE_URI, {params: {id : groupId}}).then(function(response){
			return response.data;
		})
	}
}]);