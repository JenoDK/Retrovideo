<%@ page contentType='text/html' pageEncoding='UTF-8'%>
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
	<vdab:menu />
	<h1>Reservaties</h1>
	<c:if test='${not empty reservaties }'>
		<form name='form' action="<c:url value='/reservaties.htm'/>"
			method='post' id='toevoegform'>
			<table>
				<tr>
					<th>Klant</th>
					<th>Film</th>
					<th>Datum</th>
					<th>Verwijderen</th>
			</tr>
				<c:forEach var='reservatie' items='${reservaties}'>
					<tr>
						<td>${reservatie.klantNaam}</td>
						<td>${reservatie.filmNaam}</td>
						<td>${reservatie.reservatieDatum }
					<td> <input type="hidden" name='filmid'
				value="${reservatie.filmid}" /><input type="hidden" name='klantid'
				value="${reservatie.klantid}" /><input type='submit' value='Verwijderen'
						name='verwijderknop'>
						</td>
					</tr>
				</c:forEach>
		</table>
		</form>
	</c:if>
	<c:if test='${not empty fout}'>
		<h2>${fout}</h2>
	</c:if>
</body>
</html>