 	<%@ page  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/main.css">
	</head>
	
	<body>
		<div class="wrap">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/> 
			<div class="mainCenter">
					<jsp:include page="/WEB-INF/views/include/menu.jsp"/>
				<div class="content">
					 <div class="sector">
						<h5>헤더값 얻기</h5>
					</div>
					<div>
						<a class="btn btn-info btn-sm" href="method1">브라우져 정보 얻기1</a>
						<a class="btn btn-info btn-sm" href="method2">브라우져 정보 얻기2</a>
						<a class="btn btn-info btn-sm" href="method3">브라우져 정보 얻기3</a>
						<a class="btn btn-info btn-sm" href="method4">브라우져 정보 얻기4</a>
						<a class="btn btn-info btn-sm" href="method5">브라우져 정보 얻기5</a>
					</div>
				</div>	
			</div>	
		</div>		
	</body>
</html>