<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<script src="resources/static/js/app.module.js"></script>
		  <script src="resources/static/js/controller/book.controller.js"></script>
		  <script src="resources/static/js/service/book.service.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${message} Home</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="BookController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    
    <section class="flex-sect" id="is95">
      <div class="gjs-row" id="ig5f">
        <div class="gjs-cell" id="ir4d">
          <form name="bookForm" class="book-modal hidden">
            <div class="flex">
              <button class="btn-close">x</button>
            </div>
            <div>
              <h3>Edit Book Info</h3>
              <h4>${error}</h4>
              <p>Here you can modify the information stored about a book.</p>
            </div>
            <input type="text" id="bookTitle" ng-model="ctrl.book.title" placeholder="Book Title" required ng-minlength="3"/>
            <div class="has-error" ng-show="bookForm.$dirty">
              <span ng-show="bookForm.title.$error.required">You must enter a title</span>
              <span ng-show="bookForm.title.$error.minlength">Title must be at least 3 characters</span>
              <span ng-show="bookForm.title.$invalid">The title is invalid</span>
           </div>
            <input type="text" id="bookAuthor" ng-model="ctrl.book.author" placeholder="Author" required ng-minlength="3" />
            <div class="has-error" ng-show="bookForm.$dirty">
              <span ng-show="bookForm.title.$error.required">You must enter author name</span>
              <span ng-show="bookForm.title.$error.minlength">Author name must be at least 3 characters</span>
              <span ng-show="bookForm.title.$invalid">The author name is invalid</span>
           </div>
            <input type="text" id="bookGenre" ng-model="ctrl.book.genre" placeholder="Genre"/>
            <button ng-click="submitUpdate()" id="submitUpdateBtn" class="btn btn-success">Finished</button>
            <button ng-click="bookDelete()" id="deleteBtn" class="btn btn-danger">Delete Book</button>
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
              <tr ng-repeat="currentBook in ctrl.books">
                <td><span ng-bind="currentBook.title"></span></td>
                <td><span ng-bind="currentBook.author"></span></td>
                <td><span ng-bind="currentBook.genre"></span></td>
                <td><span ng-bind="currentBook.datecompleted"></span></td>
                <td></td>
                <td><button id="editBookBtn" data-ng-click="ctrl.editDetails(currentBook.id)" class="btn btn-info">Edit Details</button></td>

              </tr>
            </tbody>
          </table>
        </div>
        <div class="gjs-cell" id="i5rij">
          <a class="btn btn-success" id="addBookBtn" href="/addbook">Add New ${message}</a>
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