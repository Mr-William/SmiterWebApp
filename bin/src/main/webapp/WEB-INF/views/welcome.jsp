<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="icon" href="resources/static/images/favicon.ico">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${user.getName()} Logged In</title>
	</head>

<body>
<smiter:myNav/>
  
  <header id="it3l" class="header-banner">
  </header>
   <div id="i7cm9" >Welcome ${user.getName()}
  </div>
  <div id="i1sn9" >
   Company: ${user.getCompany()}
  </div>
  <div class="gjs-row" id="iazyw">
    <div class="gjs-cell">
      <div id="iohgy">
        <div class="gjs-cell" id="ikdkn">
          <h1 id="il1a9">  Role: ${user.getUserType()}
            <span id="igfxw"></span>
            <br/>
          </h1> 
          <div id="iyrlz"> 
            <br/>
          </div>
        </div>
        <div class="gjs-cell">
        
          	
        </div>
      </div>
    </div>
  </div> 
  <div class="gjs-row" id="iyw6r">
    <div class="gjs-cell">
      <div class="gjs-row" id="ir3w4">
        <div class="gjs-cell" id="itzhi">
          <div class="gjs-row" id="iojjk">
            <div class="container" id="ikdkn">
              <div class="row"><h1 >Manage Your Groups:  </h1><br>
              <div class="nav nav-fill">
              </div>
            		<a class="group-mngmnt-btns" name="searchgroups" id="btn-create-group" href="searchgroups">Search Groups</a><br><br>
              		<a class="group-mngmnt-btns" name="creategroups" id="btn-edit-groups" href="creategroup">Create Groups</a>
              	</div>
            </div>
            <div  id="iy6ed" class="gjs-cell">
            	<div class="container" >
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>Your Groups:</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        	<tr>
							<c:forEach var="grp" items="${groups}">
							<tr><td><span><a href="groupdetailpage?groupName=${grp}">${grp}</a></span></td></tr>
							</c:forEach>
							</tr>
                        </tbody>
                    </table>
            	</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <section id="i5uvx" class="am-sect">
    <div id="ijpuzf" class="gjs-row">
     	<label class="confirm-message">${message}</label>
    </div>
    <div id="ijpuzf" class="gjs-row">
     	<label class="error-message">${error}</label>
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