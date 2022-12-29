angular.module('SmiterApp').controller('GroupController',
	['GroupService', function(GroupService){
		let self = this;
		self.group = {
			id : '',
			groupName : '',
			owner : '',
			taskList : [],
			userList : []
		};
		
		self.groups = [];
				
		self.getAllGroups = function(){
			GroupService.getAllGroups().then(function(data){
				self.groups = data;
			})
		}
		
		self.createGroup = function(){
			return GroupService.createGroup(self.group).then(function(){
				self.getAllGroups();
			})
		}
		
		self.deleteGroup = function(group){
			return GroupService.deleteGroup(group.id).then(function(){
				self.fetchAllGroups();
			})
		}
		
		self.findGroup = function(group){
			return GroupService.findGroup(group.id).then(function(data){
				self.group = data;
			})
		}
		
		self.fetchAllGroups();
	}])