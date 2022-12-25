<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    	<script src="resources/static/js/app.module.js"></script>
		<script src="resources/static/js/controller/user.controller.js"></script>
		<script src="resources/static/js/service/user.service.js"></script>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>${message}</title>
    	<link rel="icon" href="resources/static/images/favicon.ico">
	</head>
	<smiter:myNav/>
	<div class="container-width"></div>
  <header id="it3l" class="header-banner">
    <div id="iisz" class="container-width" >
      <div id="ilwp" class="logo-container">
      </div>
      <div id="iry3p" class="clearfix">
      </div>
      <div id="in1va" class="lead-title">Imagine managing tasks for everybody....in one place.
        <br/>
      </div>
      <div id="inlum" class="sub-lead-title">With SMITER, you have a System for Managing Individual Tasks, Expectations, and Roles for any application you can think of.
        <br/>
      </div>
      <div id="isw6g9" class="gjs-row">
        <div id="it3w0n" class="gjs-cell">
          <div id="i38ypo" class="gjs-row">
            <div id="ia5mfe" class="gjs-cell">
            </div>
            <div id="igr4fu" class="gjs-cell">
            	<div class="nav nav-fill">
            		<a class="lead-btn" href="login" role="button">Login</a><br><br>
              		<a class="lead-btn" href="registration" role="button">Sign Up</a> 
              	</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <section class="am-sect">
    <div class="container-width">
    </div>
  </section>
  <section id="i8k05" class="blk-sect">
    <div class="container-width">
      <div id="iad16" class="blk-title">How Can You Use SMITER?
        <br/>
      </div>
      <div id="io4bf" class="blk-desc">While the possibilities are nearly endless, here are some examples
        <br/>
      </div>
      <div class="price-cards">
        <div class="price-card-cont">
          <div class="price-card">
            <div id="iy7gyf" class="pc-title">At Work
              <br/>
            </div>
            <div id="ihavpe" class="pc-desc">Create a group and invite members to assign tasks such as training or daily tasks and track completion.
              <br/>
            </div>
          </div>
        </div>
        <div class="price-card-cont">
          <div class="price-card pc-regular">
            <div id="i9avyk" class="pc-title">At School
              <br/>
            </div>
            <div id="i2v51f" class="pc-desc">Assign learning objectives or assignments and allow students to send work or make files available for them to access.
              <br/>
            </div>
          </div>
        </div>
        <div id="icr5pb" class="price-card-cont">
          <div id="itrwcv" class="price-card pc-enterprise">
            <div id="idjkjg" class="pc-title">At Home
              <br/>
            </div>
            <div id="i5mnhi" class="pc-desc">Create a chore list for everybody in your home so they know what is expected and needs to be done.
              <br/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</body>
</html>