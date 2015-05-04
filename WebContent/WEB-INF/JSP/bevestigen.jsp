<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Bevestigen' />
</c:import>
</head>
<body>
	<vdab:menu />
	<div class='wrapper'>
	<h1>Bevestigen</h1>

	<c:forEach var='film' items='${filmsInMandje}'>

		<h3>- ${film.titel}</h3>

	</c:forEach> ${aantalFilmsInMandje} film(s) voor ${klantnaam}

	<form name='form' action="<c:url value='/bevestigen.htm'/>"
	method='post' id='bevestigform'><input type="hidden" name='id' value="${klantid}" /><input type='submit'
		value='Bevestigen' name='bevestigknop'></form>
		</div>
</body>
</html>