<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="icon" href="resources/static/images/favicon.ico">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>Create a Group</title>
	</head>
<body ng-app="SmiterApp">
<smiter:myNav/>  
  <header class="header-banner">
  </header> 
  <section class="flex-sect" id="isfgv">
  </section>
  <section class="am-sect">
    <div class="container" ng-controller="UserController as ctrl">
    		
            <div class="panel panel-default">
            	<div><span data-ng-if="ctrl.error" class="error-message" ng-bind="ctrl.error"></span></div>
            	<div><span data-ng-if="ctrl.message" class="confirm-message" ng-bind="ctrl.message"></span></div>
                <div class="blk-desc"><span class="lead">Edit Your Group Roster</span></div>
                <div class="formcontainer">
                    <form ng-submit="ctrl.submit()" name="userForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.user.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="blk-desc" for="user_username">User Name:</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.user.username" id="user_username" class="user_username form-control input-sm" placeholder="Enter the name of the new user [required]" required ng-minlength="3" />
                                    <div class="has-error" ng-show="userForm.$dirty">
                                        <span ng-show="userForm.user_username.$error.required">This is a required field</span>
                                        <span ng-show="userForm.user_username.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="userForm.user_username.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="blk-desc" for="user_email">User Email:</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.user.email" id="user_eamil" class="form-control input-sm" placeholder="Enter the email of the new user" />
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="blk-desc" for="user_email">User Birthday:</label>
                                <div class="col-md-7">
                                    <input type="date" ng-model="ctrl.user.dob" id="user_dob" class="datepicker" required placeholder="Select the users birthday." />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input data-ng-if="!ctrl.user || !ctrl.user.id" type="submit" value="Add" class="btn btn-primary btn-sm">
                                <button data-ng-if="ctrl.user.id" type="submit" class="btn btn-primary btn-sm">Update</button>
                                <button data-ng-if="ctrl.user" type="reset" class="btn btn-secondary btn-sm">Clear</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                        
            <div class="panel panel-default mt-3"> 
                <div class="blk-desc"> 
                	<span class="lead">List of Current Group Users</span>
                	
                	 
                <div class="tablecontainer">
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>User Name</th>
                                <th>User Email</th>
                                <th>User Birthday</th>
                               	<th>ID </th>
                                <th width="20%"></th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="currentUser in ctrl.users">
                                <td><span ng-bind="currentUser.username"></span></td>
                                <td><span ng-bind="currentUser.email"></span></td>
                                <td><span ng-bind="currentUser.dob | date:'MM/dd/yyyy' "></span></td>
                                <td><span ng-bind="currentUser.id"></span></td>
                                <td></td>
                                <td><button data-ng-click="ctrl.edit(currentUser.id)" class="btn btn-secondary btn-sm">Select</button></td>
                                <td><button data-ng-click="ctrl.remove(currentUser.id)" class="btn btn-secondary btn-sm">Delete</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
  </section> 
  <section class="blk-sect" id="ik15a">
  </section>
      <script src="<c:url value='resources/static/js/app.module.js' />"></script>
      <script src="<c:url value='resources/static/js/service/user.service.js' />"></script>
      <script src="<c:url value='resources/static/js/controller/user.controller.js' />"></script>
</body>
</html>