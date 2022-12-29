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
      <title>SMITER: Create Account</title>
	</head>
	<body ng-app="SmiterApp">
  		<smiter:myNav/>
  		<header id="it3l" class="header-banner">
  		<div class="container-width"></div>
  		</header>
  		<div id="i1sn9" class="gjs-row"> 
  			<div><span data-ng-if="ctrl.message" class="confirm-message" ng-bind="ctrl.message"></span></div>
  		</div>
  <section id="i5uvx" class="am-sect">
    <div id="iusf2" class="gjs-row">
      <div id="idu5g" class="gjs-cell">
      </div>
      <div id="iqnmn" class="gjs-cell">
        <div id="i00bm" class="gjs-row">
          <div id="RegisterFormDiv" class="gjs-cell" ng-controller="RegistrationController as ctrl">
            <div><span data-ng-if="ctrl.message" class="confirm-message" ng-bind="ctrl.message"></span></div>
            <h1 align="center" id="il1a9">Create a New SMITER Account</h1> 
            <form ng-submit ="ctrl.submit()" name="registrationForm" >
            	<input type="hidden" ng-model="ctrl.registration.id"/>
            <div id="iht1e" class="gjs-row"><div id="ithg8" class="gjs-cell">
                <label id="izmh8">Name : </label>
                <input type="text" ng-model="ctrl.registration.name" id="registration_name" class="form-control input-sm" required placeholder="Enter your name" />
              </div>
            </div>
            <div id="icsj8" class="gjs-row">
               <div id="i5thw" class="gjs-cell">
                <label id="iasbn">Email: </label>
                <input type="text" ng-model="ctrl.registration.email" id="registration_email" class="form-control input-sm" required placeholder="Enter your email" />
              </div>
            </div>
            <div id="ir8oo" class="gjs-row">
              <div id="ircbk" class="gjs-cell">
                <label id="ilydl">User Name : </label>
                <input type="text" ng-model="ctrl.registration.username" id="registration_username" class="form-control input-sm" required placeholder="Enter your desired username" />
              </div>
            </div>
            <div id="ivls2" class="gjs-row">
              <div id="is3ar" class="gjs-cell">
                <label id="itygf">Password : </label>
                <input type="text" ng-model="ctrl.registration.password" id="registration_password" class="form-control input-sm" required placeholder="Enter your password" />
             </div>
            </div>
            <div id="ir8oo" class="gjs-row">
              <div id="ircbk" class="gjs-cell">
                <label id="ilydl">User DOB : </label>
                <input type="date" ng-model="ctrl.registration.dob" id="user_dob" class="datepicker" required placeholder="Select the users birthday." />
              </div>
            </div>
             <div id="ivls2" class="gjs-row">
              <div id="is3ar" class="gjs-cell">
                <label id="company" >Company : </label>
                <input type="text" ng-model="ctrl.registration.company" id="registration_company" class="form-control input-sm" optional placeholder="Optional--Enter your company" />
                </div>
            </div>
            <div id="ixy7w" class="gjs-row">
              <div id="izqzs" class="gjs-cell">
                <label id="in0lk">User Type: </label>
                <select ng-model="ctrl.registration.usertype" id="registration_usertype" class="form-control input-sm" required >
                  <option path="usertype" value="Group Owner">Owner</option>
                	<option path="usertype" value="Group User" >Member</option>
                	</select>
                
              </div>
            </div>
            <div id="iugfa" class="gjs-row">
              <div class="gjs-cell">
              </div>
              <div id="ir8vk" class="gjs-cell">
                <input type="submit" value="Register" class="btn btn-primary btn-sm">
              </div>
            </div>
        	</form>
          </div>
        </div>
      </div>
      <div id="idpkc" class="gjs-cell">
      </div>
    </div>
    <div id="i7vnj" class="gjs-row">
    </div>
    <div id="ijpuzf" class="gjs-row">
      <div id="i53ai5" class="gjs-cell">
      </div>
    </div>
    <div class="container-width">
    </div>
    <section id="i8k05" class="blk-sect">
    </section>
  </section>
  <div id="idjq4" class="gjs-row">
    <div id="iy0dx" class="gjs-cell">
    </div>
  </div>
  <script src="<c:url value='resources/static/js/app.module.js' />"></script>
  <script src="<c:url value='resources/static/js/service/registration.service.js' />"></script>
  <script src="<c:url value='resources/static/js/controller/registration.controller.js' />"></script>
</body>
</html>