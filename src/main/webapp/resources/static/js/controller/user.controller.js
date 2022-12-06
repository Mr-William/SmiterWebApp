'use strict';

angular.module('SmiterApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user = {
		id:null,
		username:'',
		email:''
		};
    
    self.users = [];
	self.message = '';
	self.error = '';
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(data) {
                self.users = data;
            },
            function(errResponse){
				self.error = 'There was a problem finding the group users.';
            }
        );
    }

    function createUser(user){
		self.message = 'User ' + user.username + ' successfully created!'
        UserService.createUser(user)
            .then(
            fetchAllUsers,
			
            function(errResponse){
				clrMsg();
                self.error = 'That username already exists!';
                reset();
            }
        );
    }

    function updateUser(userSelected){
		self.user = angular.copy(userSelected);
	}

    function deleteUser(id){
		clrMsg();
		self.message = 'User id: ' + id + ' successfully deleted!';
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
				clrMsg();
                self.error = 'There was an error ';
            }
        );
        reset();
    }

    function submit() {
		clrMsg();
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
            self.message = 'User ' + self.user.username + ' updated!';
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,username:'',email:''};
        $scope.userForm.$setPristine();
    }
    
    function clrMsg(){
	self.error = '';
	self.message = '';
}

}]);
