<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='${film.titel}' />
</c:import>
</head>
<body>
	<vdab:menu />
	<div class='wrapper'><c:if test='${not empty film }'>
			<h1>${film.titel}</h1>
			<img class='detail' src='<c:url value="/images/${film.id}.jpg"/>'
				alt='${film.titel}'>
			<dl>
				<dt>Prijs</dt>
				<dd>€${film.prijs}</dd>
				<dt>Voorraad</dt>
				<dd>${film.voorraad}</dd>
				<dt>Gereserveerd</dt>
				<dd>${film.gereserveerd}</dd>
				<dt>Beschikbaar</dt>
				<dd>${film.voorraad - film.gereserveerd}</dd>
			</dl>
			<a
				href='http://www.imdb.com/find?ref_=nv_sr_fn&q=${film.titel}&s=all' target="_blank"><img
				src='<c:url value="/images/imdb.png"/>' alt='imdb'></a>
			<c:if
				test='${((film.voorraad - film.gereserveerd)>0) and empty fout}'>
				<form name='form' action="<c:url value='/mandje.htm'/>"
					method='post' id='toevoegform'><input type="hidden"
					name='id' value="${film.id}" /> <input type='submit'
					name='toevoegknop' value='Toevoegen aan mandje' /></form>
			</c:if>
			<c:if test='${not empty fout}'>
				<h2>${fout}</h2>
			</c:if>
		</c:if> <script>
			document.getElementById('toevoegform').onsubmit = function() {
				document.getElementById('toevoegknop').disabled = true;
			};
		</script></div>
</body>
</html>