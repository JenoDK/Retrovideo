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
	<vdab:menu />
	<div class='wrapper'>
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
					<tr>
						<td>Totaal: </td>
						<td>€${mandjeTotaal}</td>
					</tr>
		</table>
		</form>
	</c:if>
	<c:if test='${not empty fout}'>
		<h2>${fout}</h2>
	</c:if>
	</div>
</body>
</html>