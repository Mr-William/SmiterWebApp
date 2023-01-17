<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<script src="resources/static/js/app.module.js"></script>
		  <script src="resources/static/js/controller/movie.controller.js"></script>
		  <script src="resources/static/js/service/movie.service.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${message} Home</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="MovieController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    
    <section class="flex-sect" id="is95">
      <div class="gjs-row" id="ig5f">
        <div class="gjs-cell" id="ir4d">
          <form name="movieForm" class="movie-modal hidden">
            <div class="flex">
              <button class="btn-close">x</button>
            </div>
            <div>
              <h3>Edit Movie Info</h3>
              <h4>${error}</h4>
              <p>Here you can modify the information stored about a movie.</p>
            </div>
            <input type="text" id="movieTitle" ng-model="ctrl.movie.title" placeholder="Movie Title" required ng-minlength="3"/>
            <div class="has-error" ng-show="movieForm.$dirty">
              <span ng-show="movieForm.title.$error.required">You must enter a title</span>
              <span ng-show="movieForm.title.$error.minlength">Title must be at least 3 characters</span>
              <span ng-show="movieForm.title.$invalid">The title is invalid</span>
           </div>
            <input type="text" id="movieGenre" ng-model="ctrl.movie.genre" placeholder="Genre"/>
            <input type="text" id="movieDirector" ng-model="ctrl.movie.director" placeholder="Director"/>
            <input type="text" id="movieProducer" ng-model="ctrl.movie.producer" placeholder="Producer"/>
            <button ng-click="submitUpdate()" id="updateMovieBtn" class="btn btn-success">Finished</button>
            <button ng-click="movieDelete()" id="deleteMovieBtn" class="btn btn-danger">Delete Movie</button>
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
              <tr ng-repeat="currentMovie in ctrl.movies">
                <td><span ng-bind="currentMovie.title"></span></td>
                <td><span ng-bind="currentMovie.genre"></span></td>
                <td><span ng-bind="currentMovie.producer"></span></td>
                <td><span ng-bind="currentMovie.director"></span></td>
                <td></td>
                <td><button data-ng-click="ctrl.editDetails(currentMovie.id)" id="editMovieBtn" class="btn btn-info">Edit Details</button></td>

              </tr>
            </tbody>
          </table>
        </div>
        <div class="gjs-cell" id="i5rij">
          <a class="btn btn-success" id="addMovieBtn" href="/addmovie">Add New ${message}</a>
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