angular
	.module('SmiterApp')
	.factory('UserService', ['$http', '$log', function($http, $log) {
		
		let REST_URI = 'user/';
		
		let factory = {
			createUser,
			getUser,
			updateUser,
			deleteUser,
			loginUser,
			logoutUser
		};
		
		return factory;
		
		function createUser(user){
			return $http.post( REST_URI + "create", user).then(function(response){
				return response.data;
				}		
			);	
		}
		
		function getUser(userName){
			return $http.get( REST_URI + "find", userName).then(function(response){
				return response.data;
				}
			);
		}
		
		function deleteUser(userName){
			return $http.delete( REST_URI + "delete", userName).then(function(response){
				return response.data;
				}
			);
		}
		
		function loginUser(userName, password){
			return $http.post( REST_URI + "login", userName, password).then(function(response){
				return response.data;
				}
			);			
		}
		
		function logoutUser(userName){
			return $http.get( REST_URI + "logout", userName).then(function(response){
				return response.data;
				}
			);
		}
	}]);