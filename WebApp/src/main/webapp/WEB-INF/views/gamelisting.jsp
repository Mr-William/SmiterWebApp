<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<script src="resources/static/js/app.module.js"></script>
		  <script src="resources/static/js/controller/game.controller.js"></script>
		  <script src="resources/static/js/service/game.service.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${message} Home</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="GameController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    
    <section class="flex-sect" id="is95">
      <div class="gjs-row" id="ig5f">
        <div class="gjs-cell" id="ir4d">
          <form name="gameUpdateForm" class="game-modal hidden">
            <div class="flex">
              <button class="btn-close">x</button>
            </div>
            <div>
              <h3>Edit Game Info</h3>
              <h4>${error}</h4>
              <p>Here you can modify the information stored about a game.</p>
            </div>
            <input type="text" id="gameTitle" ng-model="ctrl.game.title" placeholder="Game Title" required ng-minlength="3"/>
            <div class="has-error" ng-show="gameUpdateForm.$dirty">
                <span ng-show="gameUpdateForm.title.$error.required">You must enter a title</span>
                <span ng-show="gameUpdateForm.title.$error.minlength">Title must be at least 3 characters</span>
                <span ng-show="gameUpdateForm.title.$invalid">The title is invalid</span>
             </div>
            <input type="text" id="gameGenre" ng-model="ctrl.game.genre" placeholder="Genre"/>
            <input type="date" id="gameDate" ng-model="ctrl.game.datecompleted" placeholder="Last Played" />
            <button ng-click="submitUpdate()" id="updateBtn" class="btn btn-success">Update Game</button>
            <button ng-click="gameDelete()" id="deleteBtn" class="btn btn-danger">Delete Game</button>
          </form>
        
          <div id="i6oy">
            <u>
              <b>
                <span id="izxff">${title}</span>
              </b>
            </u>
            <br/>
          </div>
        </div>
      </div>
    </section>
    
    <div class="overlay hidden"></div>
    <section class="flex-sect" id="ipvi">
     
      <div class="container-width" id="iqesh">
        <div class="gjs-cell" id="reviewlisting">
          <table class="table table-primary table-striped">
            <thead>
              <tr>
                <c:forEach var="hdr" items="${tableHeaders}">
                  <th scope="col" id="iqesh"><c:out value="${hdr}"/></th>
                </c:forEach>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="currentGame in ctrl.games">
                <td><span ng-bind="currentGame.title"></span></td>
                <td><span ng-bind="currentGame.genre"></span></td>
                <td><span ng-bind="currentGame.datecompleted"></span></td>
                <td></td>
                <td><button id="editGameBtn" data-ng-click="ctrl.editDetails(currentGame.id)" class="btn btn-info">Edit Details</button></td>

              </tr>
            </tbody>
          </table>
        </div>
        <div class="gjs-cell" id="i5rij">
          <a class="btn btn-success" id="addGameBtn" href="/addgame">Add New ${message}</a>
        </div>
      </div>
    </section>
    <section class="am-sect" id="ipvi">
      <div class="gjs-row" id="iqesh">
        
      </div>
    </section>
    <section id="i8k05" class="blk-sect">
      <div class="container-width">
        </div>
        </section>
      </body>
  </html>