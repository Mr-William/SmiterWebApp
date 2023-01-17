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
    	<title>Add Game</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="GameController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    <section id="is95" class="flex-sect">
      <div id="ig5f" class="gjs-row">
        <div id="ir4d" class="gjs-cell">
          <div id="i6oy">Add a Game
            <br/>
          </div>
        </div>
      </div>
        <div class="row">
          <div><span data-ng-if="ctrl.error" class="error-message" ng-bind="ctrl.error"></span></div>
            	<div><span data-ng-if="ctrl.message" class="confirm-message" ng-bind="ctrl.message"></span></div>
        </div>
        <form ng-submit="ctrl.createGame()" name="gameForm" id="gameForm"
          class="form-horizontal">
          <span class="border border-info"></span>
          <input type="hidden" ng-model="ctrl.game.id"/>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="title">Game Title: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.game.title"
                  id="gameTitle" class="from-control input-sm"
                  placeholder="Enter Game Title" required/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="genre">Game Genre: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.game.genre"
                  id="gameGenre" class="from-control input-sm"
                  placeholder="Optional - Game genre."/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label" for="game_datecompleted">Date Last Played:</label>
                <div class="col-md-7">
                    <input type="text" ng-model="ctrl.game.datecompleted" id="game_datecompleted"/>
                </div>
            </div>
        </div>
          <div class="gjs-row">
            <div class="form-actions floatRight">
              <input type="submit" id="submitGameForm" value="Add Game" class="btn btn-primary btn-sm">
              <button type="button" id="resetFormBtn" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
              ng-disabled="gameForm.$pristine">Reset Form</button>
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
      <div class="game-modal hidden">
        <button class="btn-close"></button>
      </div>
    </section>
  </body>
  </html>