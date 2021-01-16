<%@ page contentType="text/html;charset=UTF-8" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mainHeader">
	<h3>Spring Framework</h3>
	<div class=loginBox>
		<c:if test="${loginStatus == null}">
		<a class="btn btn-info btn-sm" href="<%=application.getContextPath() %>/ch08/content">로그인</a>
		</c:if>
			<img class="rounded-circle" src="<%=application.getContextPath() %>/resources/img/kakao.PNG" width=50px;>
		<c:if test="${loginStatus != null}">
		<a class="btn btn-success btn-sm" href="<%=application.getContextPath() %>/ch08/content">로그아웃</a>
		</c:if>
	</div>
</div>