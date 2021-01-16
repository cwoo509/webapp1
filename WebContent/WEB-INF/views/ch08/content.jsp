<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

		<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/main.css">

	</head>
		
	<body>
		<div class="wrap">
			<%--공통 헤더--%>
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			
			<%--내용--%>
			<div class="mainCenter">
					<%--공통메뉴--%>
					<jsp:include page="/WEB-INF/views/include/menu.jsp"/>
					
					<div class="content">
							<div class="sector">
								<h5>Session 객체를 이용한 스칼라값 전달</h5>
								<div>
									<a class="btn btn-info btn-sm" href="method1">전달</a>
								</div>
							</div>
							
							<div class="sector">
								<h5>Session 객체를 이용한 객체  전달</h5>
								<div>
									<a class="btn btn-info btn-sm" href="method2">전달</a>
								</div>
							</div>
							<div class="sector">
								<h5>Session 객체를 이용한 객체  전달</h5>
								<div>
									<a class="btn btn-info btn-sm" href="method3">전달</a>
								</div>
							</div>
							<div class="sector">
								<h5>Http Session 객체를 이용한 객체  전달</h5>
								<c:if test="${loginStatus == null}" ><!-- 로그인 정보를가져오는데 안의 데이터가 없다면  -->
									<div>
									<form method="post" action="login">
											<input type="text" name="uid" placeholder="ID">
											<br/>
											<input type="password" name="upassword" placeholder="PW">
											<br/>
											<button class="btn btn-info btn-sm">로그인</button>
										</form>
									</div>
								</c:if>
									<c:if test="${loginStatus != null}" >
									<a class="btn btn-danger btn-sm" href="logout">로그아웃</a>
									</c:if>
								<div>
								</div>
							</div>
							<div class="sector">
								<h5>게시물 입력</h5>
								<div>
								
									<form method="post" action="boardWrite">
										<input type="text" name="title" placeholder="제목"/>
										<br/>
										<textarea rows="5" cols="100" name="content" placeholder="boardwrite"></textarea><br/>
									</form>
										<button class="btn btn-info btn-sm">게시뮬저장</button>
									
								</div>
							</div>
					</div>
			</div>
		</div>
	</body>
</html>