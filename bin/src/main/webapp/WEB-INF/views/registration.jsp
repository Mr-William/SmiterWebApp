<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="smiter" %>

<!DOCTYPE html>
<html lang="en">
	<head>
    	<link rel="stylesheet" href="resources/static/css/style.css">
    	<link rel="icon" href="resources/static/images/favicon.ico">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<title>SMITER: Create Account</title>
	</head>
	<body>
  		<smiter:myNav/>
  		<header id="it3l" class="header-banner">
  		<div class="container-width"></div>
  		</header>
  		<div id="i1sn9" class="gjs-row">
  			<div class="error-message">${error}</div>
  		</div>
  <section id="i5uvx" class="am-sect">
    <div id="iusf2" class="gjs-row">
      <div id="idu5g" class="gjs-cell">
      </div>
      <div id="iqnmn" class="gjs-cell">
        <div id="i00bm" class="gjs-row">
          <div id="RegisterFormDiv" class="gjs-cell">
            <h1 align="center" id="il1a9">Create a New SMITER Account</h1>
            <form:form modelAttribute="user" method="post" action="/registration" >
            	<form:input type="hidden" path="id"/>
            <div id="iht1e" class="gjs-row"><div id="ithg8" class="gjs-cell">
                <label id="izmh8">Name : </label>
                <form:input path="name" type="text" name="name" class="imflz" required="required" id="name"/>
              </div>
            </div>
            <div id="icsj8" class="gjs-row">
               <div id="i5thw" class="gjs-cell">
                <label id="iasbn">Email: </label>
                <form:input path="email" type="email" class="imflz" required="required" name="email" />
              </div>
            </div>
            <div id="ir8oo" class="gjs-row">
              <div id="ircbk" class="gjs-cell">
                <label id="ilydl">User Name : </label>
                <form:input path="userName" type="text" class="imflz" required="required" name="username"/>
              </div>
            </div>
            <div id="ivls2" class="gjs-row">
              <div id="is3ar" class="gjs-cell">
                <label id="itygf">Password : </label>
                <form:input path="password" type="password" class="imflz" required="required" id="password" />
             </div>
            </div>
             <div id="ivls2" class="gjs-row">
              <div id="is3ar" class="gjs-cell">
                <label id="company" >Company : </label>
                <form:input path="company" type="text" class="imflz" placeholder="Optional"  id="user_company"/>
             </div>
            </div>
            <div id="ixy7w" class="gjs-row">
              <div id="izqzs" class="gjs-cell">
                <label id="in0lk">User Type: </label>
                <form:select path="userType" id="userType" class="imflz" required="required" name="userType">
                	<form:option path="usertype" value="Group Owner">Owner</form:option>
                	<form:option path="usertype" value="Group User" >Member</form:option>
                	</form:select>
                
              </div>
            </div>
            <div id="iugfa" class="gjs-row">
              <div class="gjs-cell">
              </div>
              <div id="ir8vk" class="gjs-cell">
                <input type="submit" value="Register" id="irvir">
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
</html>