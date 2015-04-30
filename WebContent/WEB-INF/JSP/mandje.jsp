<%@ page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Mandje' />
</c:import>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="<c:url value='/index.htm'/>">Reserveren</a></li>
				<li><a href="<c:url value='/klant.htm'/>">Klant</a></li>
			</ul>
		</nav>
	</header>
	<%-- 	<vdab:menu /> --%>
	<h1>Mandje</h1>
	<c:if test='${not empty filmsInMandje }'>
		<form name='form' action="<c:url value='/mandje.htm'/>" method='post'
			id='toevoegform'>
			<table>
				<tr>
					<th>Film</th>
					<th>Prijs</th>
					<th><input type='submit' value='Verwijderen'
						name='verwijderknop'></th>
				</tr>
				<c:forEach var='film' items='${filmsInMandje}'>
					<tr>
						<td>${film.titel}</td>
						<td>€${film.prijs}</td>
						<td><label> <input type='checkbox' name='id'
								value='${film.id }'>
						</label></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</c:if>
	<c:if test='${not empty fout}'>${fout}</c:if>
</body>
</html>