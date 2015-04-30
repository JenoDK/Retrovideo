<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Reservaties' />
</c:import>
<link rel='stylesheet' href='<c:url value="/css/reservaties.css"/>'>
</head>
<body>
	<h1>Reservaties</h1>
	<ul>
		<c:forEach var='genre' items='${genres}'>
			<c:choose>
				<c:when test='${genre.id == activeGenre}'>
					<li><c:out value='${genre.naam}' /></li>
				</c:when>
				<c:otherwise>
					<li><c:url value='/index.htm' var='detailURL'>
							<c:param name='genreid' value='${genre.id}' />
						</c:url> <a href='${detailURL}'><c:out value='${genre.naam}' /></a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	<c:if test='${not empty films}'>
		<c:forEach var='film' items='${films}'>
			<c:url value='/detailFilm.htm' var='detailURL'>
				<c:param name='id' value='${film.id}' />
			</c:url>
			<a href='${detailURL}'
				<c:choose>
					<c:when test='${film.voorraad>film.gereserveerd}'>
						title="Reservatie mogelijk"
					</c:when>
					<c:otherwise>
						title="Reservatie niet mogelijk"
					</c:otherwise>
					</c:choose>>
				<img src='<c:url value="/images/${film.id}.jpg"/>'
				alt='${film.titel}'>
			</a>
		</c:forEach>
	</c:if>
</body>
</html>