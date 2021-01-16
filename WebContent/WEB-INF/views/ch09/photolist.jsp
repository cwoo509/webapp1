<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="fileName" items="${fileNames}">
	<div style="display:flex; margin-button: 15px; align-items: center">
		<img src="photodownload?photo=${fileName}" width="50px" height="50px" 
		style="margin-right: 5px"
		 class="rounded-circle">
		<a href="photodownload?photo=${fileName}">${fileName}</a>		
	</div>
</c:forEach>
