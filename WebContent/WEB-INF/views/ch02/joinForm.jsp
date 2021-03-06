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
						<h5>회원가입</h5>
						<div>								
							<form method="post" action="join">
								아이디: <input type="text"/>
								<br/>
								이름:	<input type="text"/>
								<br/>
								패스워드:<input type="password"/>
								<br/>
								POST 방식:<button class="btn btn-info btn-sm">회원가입</button>
							</form>
						</div>
					</div>
	
				</div>
			</div>		
		</div>
	</body>
</html>