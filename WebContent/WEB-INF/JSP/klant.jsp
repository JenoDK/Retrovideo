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
	<vdab:menu />
	<h1>Klant</h1>
	<form method='get'>
		<label> Familienaam bevat: <input name='familienaam'
			value='${param.familienaam}' type='text' min='1' autofocus>
		</label> <input type='submit' value='Zoeken'>
	</form>
	<c:if test='${not empty klanten}'>
		<table>
			<tr>
				<th>Naam</th>
				<th>Straat - Huisnummer</th>
				<th>Postcode</th>
				<th>Gemeente</th>
			</tr>

			<c:forEach var='klant' items='${klanten}'>
				<tr>
					<td><c:url value='/bevestigen.htm' var='detailURL'>
							<c:param name='id' value='${klant.id}' />
						</c:url> <a href='${detailURL}'>${klant.naam}</a></td>
					<td>${klant.adres.straatNummer}</td>
					<td>${klant.adres.postcode}</td>
					<td>${klant.adres.gemeente}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>