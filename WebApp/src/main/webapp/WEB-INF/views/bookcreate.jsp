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
    	<title>Add Book</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
  <body ng-app="SmiterApp" ng-controller="BookController as ctrl">
	<smiter:myNav/>
    <header class="header-banner">
    </header>
    <section id="is95" class="flex-sect">
      <div id="ig5f" class="gjs-row">
        <div id="ir4d" class="gjs-cell">
          <div id="i6oy">Add a Book
            <br/>
          </div>
        </div>
      </div>
        <div class="row">
          <div><span data-ng-if="ctrl.error" class="error-message" ng-bind="ctrl.error"></span></div>
            	<div><span data-ng-if="ctrl.message" class="confirm-message" ng-bind="ctrl.message"></span></div>
        </div>
        <form ng-submit="ctrl.createBook()" name="bookForm"
          class="form-horizontal">
          <span class="border border-info"></span>
          <input type="hidden" ng-model="ctrl.book.id"/>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="title">Book Title: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.book.title"
                  id="bookTitle" class="from-control input-sm"
                  placeholder="Enter Book Title" required/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="author">Book Author: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.book.author"
                  id="bookAuthor" class="from-control input-sm"
                  placeholder="Enter Book Author" required/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md 12">
              <label class="col-md-2 control-label" for="genre">Book Genre: </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.book.genre"
                  id="bookGenre" class="from-control input-sm"
                  placeholder="Optional - Book genre."/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label" for="book_datecompleted">Date You Completed:</label>
                <div class="col-md-7">
                    <input type="text" ng-model="ctrl.book.datecompleted" id="book_datecompleted"/>
                </div>
            </div>
        </div>
          <div class="gjs-row">
            <div class="form-actions floatRight">
              <input type="submit" id="bookAddBtn" value="Add Book" class="btn btn-primary btn-sm">
              <button type="button" id="formResetBtn" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
              ng-disabled="bookForm.$pristine">Reset Form</button>
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
      <div class="book-modal hidden">
        <button class="btn-close"></button>
      </div>
    </section>
  </body>
  </html>