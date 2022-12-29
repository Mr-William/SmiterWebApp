<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="icon" href="resources/static/images/favicon.ico">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>Create a TaskList</title>
	</head>
<body>
<smiter:myNav/>
  <header class="header-banner">
  </header>
  <section class="flex-sect" id="isfgv">
  </section>
  <section class="am-sect">
    <div class="container-width">
     <h1 align="center" id="il1a9">Create a New Group TaskList for Group: ${groupName}</h1>
            <form:form modelAttribute="task" action="createtasklist?groupName=${groupName}" method="post">
            <form:input type="hidden" path="id"/>
            <div id="iht1e" class="gjs-row">
            	<div id="ithg8" class="gjs-cell">
                	<label id="izmh8">Task Name: </label>
                	<form:input path="taskTitle" type="text" required="required" />
              </div>
            </div>
            <div id="iht1e" class="gjs-row">
            	<div id="ithg8" class="gjs-cell">
                	<label id="izmh8">Task Description: </label>
                	<form:input path="taskItems" type="text" required="required" />
              </div>
            </div>
            <div id="icsj8" class="gjs-row">
               <div id="ithg8" class="gjs-cell">
                <label id="iasbn">Due Date: </label>
                <form:input path="dueDate" required="required" />
              </div>
            </div>
            
            <div id="iugfa" class="gjs-row">
              <div class="gjs-cell">
              </div>
              <div id="ir8vk" class="gjs-cell">
                <input type="submit" value="Create Task" id="irvir">
              </div>
            </div>
        	</form:form>
    </div>
  </section> 
  <section class="blk-sect" id="ik15a">
  </section>
</body>