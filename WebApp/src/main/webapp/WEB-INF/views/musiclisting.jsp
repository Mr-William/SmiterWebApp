<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<script src="resources/static/js/app.module.js"></script>
		  <script src="resources/static/js/controller/music.controller.js"></script>
		  <script src="resources/static/js/service/music.service.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${message} Home</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="MusicController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    
    <section class="flex-sect" id="is95">
      <div class="gjs-row" id="ig5f">
        <div class="gjs-cell" id="ir4d">
          <div class="music-modal hidden">
            <div class="flex">
              <button class="btn-close">x</button>
            </div>
            <div>
              <h3>Edit Music Info</h3>
              <h4>${error}</h4>
              <p>Here you can modify the information stored about a music.</p>
            </div>
            <input type="text" ng-model="ctrl.music.songTitle" placeholder="Song Title" required />
            <input type="text" ng-model="ctrl.music.albumTitle" placeholder="Album" required />
            <input type="text" ng-model="ctrl.music.artist" placeholder="Artist" required />
            <input type="text" ng-model="ctrl.music.genre" placeholder="Genre" required />
            <button ng-click="submitUpdate()" class="btn btn-success">Finished</button>
            <button ng-click="musicDelete()" class="btn btn-danger">Delete Music</button>
        </div>
        
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
              <tr ng-repeat="currentMusic in ctrl.musics">
                <td><span ng-bind="currentMusic.songTitle"></span></td>
                <td><span ng-bind="currentMusic.albumTitle"></span></td>
                <td><span ng-bind="currentMusic.genre"></span></td>
                <td><span ng-bind="currentMusic.artist"></span></td>
                <td></td>
                <td><button data-ng-click="ctrl.editDetails(currentMusic.id)" class="btn btn-info">Edit Details</button></td>

              </tr>
            </tbody>
          </table>
        </div>
        <div class="gjs-cell" id="i5rij">
          <a class="btn btn-success" href="/addmusic">Add New ${message}</a>
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