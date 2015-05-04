<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Rapport' />
</c:import>
</head>
<body>
<vdab:menu />
<div class='wrapper'>
	<h1>Rapport</h1>
	<c:choose>
	<c:when test='${empty foutefilms}'>
		De reservatie is OK
	</c:when>
	<c:otherwise>
	Mislukte reservaties: 
		<c:forEach var='film' items='${foutefilms}'>
			${film.titel}
		</c:forEach>
	</c:otherwise>
	</c:choose>
	</div>
</body>
</html>