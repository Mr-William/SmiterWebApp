<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="icon" href="resources/static/images/favicon.ico">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${message}${error}</title>
	</head>
<body>
<smiter:myNav/>
  <header class="header-banner">
  </header>
  <section class="flex-sect" id="isfgv">
  </section>
  <section class="am-sect">
    <div class="container-width">
     <h1 align="center" id="il1a9">${message}</h1><br><br>
            <dl class="row">
            	<dt class="col-sm-3">Group ID:</dt>
            	<dt class="col-sm-9">${group.id}</dt>
            	<dt class="col-sm-3">Group Name:</dt>
            	<dd class="col-sm-9">${group.name}</dd>
            	<dt class="col-sm-3">Group Email:</dt>
            	<dd class="col-sm-9">${group.email}</dd>
            	<dt class="col-sm-3">Group Owner:</dt>
            	<dd class="col-sm-9">${group.ownerName}</dd>
            	<dt class="col-sm-3">Member Count:</dt>
            	<dd class="col-sm-9">${group.memberCount}</dd>
            	<dt class="col-sm-3">Task List Count:</dt>
            	<dd class="col-sm-9">${group.taskListCount}</dd>
            </dl>
            <dl class="row">
            	<div class="container" >
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th align="center">Your TaskList:</th> 
                            </tr>
                        </thead>
                        <tbody>
                        	<tr>
                        	<td><span>Task Title:</span></td>
                        	<td><span>Task Due Date:</span></td>
							<c:forEach var="tsk" items="${taskList}">
							<tr>
								<td><span><a href="tasklistinfo?name=${tsk.id}">${tsk.taskTitle}</a></span></td>
								<td><span>${tsk.dueDate}</span></td>
							</tr>
							</c:forEach>
							</tr>
							<a href="createtasklist?groupName=${group.name}" class="task-btn">Create Task</a>
                        </tbody>
                    </table>
                    	
            	</div>
            </dl>
    </div>
  </section>
  <section class="blk-sect" id="ik15a">
  </section>
</body>