'use strict';

angular.module('SmiterApp').controller('RegistrationController', ['$scope', 'RegistrationService', function($scope, RegistrationService) {
    var self = this;
    self.registration = {
		id:null,
		username:'',
		email:'',
		dob:'',
        password:'',
        company:'',
        usertype:'',
        name:''
		};
    
    self.users = [];
	self.message = '';
	self.error = '';
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    function fetchAllUsers(){
        RegistrationService.fetchAllUsers()
            .then(
            function(data) {
                self.users = data;
            },
            function(errResponse){
				self.error = 'There was a problem finding the group users.';
            }
        );
    }

    function createUser(registration){
		self.message = 'User ' + registration.username + ' successfully created!'
        RegistrationService.createUser(registration)
            .then(			
            function(errResponse){
				clrMsg();
                self.error = errResponse;
                reset();
            }
        );
    }

    function updateUser(userSelected){
		self.message = 'User ' + userSelected.username + ' successfully updated!'
		self.user = angular.copy(userSelected);
		RegistrationService.updateUser(userSelected, self.user.id).then(
			fetchAllUsers,
			function(errResponse){
				clrMsg();
                self.error = errResponse;
                reset();				
			}
			);
	}

    function deleteUser(id){
		clrMsg();
		self.message = 'User id: ' + id + ' successfully deleted!';
        RegistrationService.deleteUser(id)
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
            console.log('Saving New User with id: ' + self.registration.id, self.registration);
            RegistrationService.createUser(self.registration);
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
        self.registration={id:null,
            username:'',
            email:'',
            dob:'',
            password:'',
            company:'',
            usertype:'',
            name:''};
        $scope.registrationForm.$setPristine();
    }
    
    function clrMsg(){
	self.error = '';
	self.message = '';
}

}]);
