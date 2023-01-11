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
    	<title>Add Movie</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="MovieController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    <section id="is95" class="flex-sect">
      <div id="ig5f" class="gjs-row">
        <div id="ir4d" class="gjs-cell">
          <div id="i6oy">Add a Movie
            <br/>
          </div>
        </div>
      </div>
        <div class="row">
          <div><span data-ng-if="ctrl.error" class="error-message" ng-bind="ctrl.error"></span></div>
            	<div><span data-ng-if="ctrl.message" class="confirm-message" ng-bind="ctrl.message"></span></div>
        </div>
        <form ng-submit="ctrl.createMovie()" name="movieForm"
          class="form-horizontal">
          <span class="border border-info"></span>
          <input type="hidden" ng-model="ctrl.movie.id"/>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="title">Movie Title: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.movie.title"
                  id="title" class="from-control input-sm"
                  placeholder="Enter Movie Title" required/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="genre">Movie Genre: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.movie.genre"
                  id="genre" class="from-control input-sm"
                  placeholder="Optional - Movie genre."/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label" for="movie_director">Director:</label>
                <div class="col-md-7">
                    <input type="text" ng-model="ctrl.movie.director" placeholder="Optional - Director" id="movie_director"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label" for="movie_producer">Producer:</label>
                <div class="col-md-7">
                    <input type="text" ng-model="ctrl.movie.producer" placeholder="Optional - Producer" id="movie_producer"/>
                </div>
            </div>
        </div>
          <div class="gjs-row">
            <div class="form-actions floatRight">
              <input type="submit" value="Add Movie" class="btn btn-primary btn-sm">
              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
              ng-disabled="movieForm.$pristine">Reset Form</button>
            </div>
          </div>
        </span>
        </form>
    </section>
    <section id="ipvi" class="am-sect">
      
      <div id="iqesh" class="gjs-row">
      </div>
    </section>
    <section id="ik15a" class="blk-sect">
      <div class="overlay hidden"></div>
      <div class="movie-modal hidden">
        <button class="btn-close"></button>
      </div>
    </section>
  </body>
  </html>