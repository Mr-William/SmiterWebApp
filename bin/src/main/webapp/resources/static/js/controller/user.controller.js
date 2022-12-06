angular
	.module('SmiterApp')
	.controller('UserController', ['UserService', function(UserService) {
		
		let self = this;
		self.user = {
			userId : '',
			name : '',
			email : '',
			userName : '',
			password : '',
			company : '',
			userType: '',
			groupMembership : []
		}
		
		self.createUser = function(){
			return UserService.createUser(self.user);
		}
		
		self.getUser = function(user) {
			return UserService.getUser(user.userName);
		}
		
		self.updateUser = function(userSelected){
			self.user = angular.copy(userSelected);
		}
		
		self.deleteUser = function(user){
			return UserService.deleteUser(user.userName);
		}
		
		self.loginUser = function(user){
			return UserService.loginUser(user.userName, user.password);
		}
		
		self.logoutUser = function(user){
			return UserService.logoutUser(user.userName);
		}
	}])