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
    	<title>SMITER: Login</title>
	</head>
	<body>
	<smiter:myNav/>
  <header id="it3l" class="header-banner">
  </header>
  <div id="i1sn9" class="gjs-row">
  </div>
  <section id="i5uvx" class="am-sect">
    <div id="iusf2" class="gjs-row">
      <div id="idu5g" class="gjs-cell">
      </div>
      <div id="iqnmn" class="gjs-cell">
        <div id="i00bm" class="gjs-row">
          <div id="LoginFormDiv"class="gjs-cell">
            <h1 id="il1a9" align="center">Login to your account
              <br/>
            </h1>
             <form:form modelAttribute="login" action="login" method="post">
              
              <div id="ir8oo" class="gjs-row">
                <div id="ircbk" class="gjs-cell">
                  <label id="ilydl">User Name : </label>
                  <form:input path="userName" type="text" required="required" />
                </div> 
              </div>
              <div id="ivls2" class="gjs-row">
                <div id="is3ar" class="gjs-cell">
                  <label id="itygf">Password : </label>
                  <form:input path="password" type="password" required="required" />
                </div>
              </div>
              <div id="iugfa" class="gjs-row">
                <div class="error-message">${error}</div>
                <div id="ir8vk" class="gjs-cell">
                	<input type="submit" value="Login" id="irk2w">
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
      <div id="idpkc" class="gjs-cell">
      </div>
    </div>
    <div id="i7vnj" class="gjs-row">
    </div>
    <div id="ijpuzf" class="gjs-row">
      <div id="i53ai5" class="gjs-cell">
      </div>
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
</body>