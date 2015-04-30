<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='${film.titel}' />
</c:import>
<link rel='stylesheet' href='<c:url value="/css/reservaties.css"/>'>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="<c:url value='/index.htm'/>">Reserveren</a></li>
				<li><a href="<c:url value='/mandje.htm'/>">Mandje</a></li>
				<li><a href="<c:url value='/klant.htm'/>">Klant</a></li>
			</ul>
		</nav>
	</header>
	<h1>Bevestigen</h1>
	
	${aantalFilms} film(s) voor ${klantnaam}
</body>
</html>