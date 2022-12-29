'use strict';

angular.module('SmiterApp').factory('RegistrationService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8085/api/users';

    var factory = {
        fetchAllUsers,
        createUser,
        updateUser,
        deleteUser,
        getHomePage
    };

    return factory;

    function getHomePage(url, user){
        $http.post(url, "user", user);

    }

    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error getting Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log('Inside registration service js====');
                getHomePage("/home", user);
            },
            function(errResponse){
                console.error('Error creating User');
                deferred.reject('User ' + user.username + ' already exists!');
            }
        );
        return deferred.promise;
    }


    function updateUser(user, id) {
        var deferred = $q.defer();
        
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error updating selected User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error deleteing User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
