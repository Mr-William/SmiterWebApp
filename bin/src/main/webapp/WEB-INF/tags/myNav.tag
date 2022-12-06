<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <nav id="Smiter-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
 	<c:choose>
   		<c:when test="${loggedIn == 'true'}">
   			<a class="nav-btn" id="homebutton" href="welcome">Home</a>
            <a class="nav-btn" id="registerbutton" href="logout">LogOut</a>   		
		</c:when>
   		
		<c:when test="${loggedIn == 'false'}">
   			<a class="nav-btn" id="homebutton" href="/">Home</a>
            <a class="nav-btn" id="registerbutton" href="login" >Login</a>
		</c:when>
	</c:choose>
</nav>