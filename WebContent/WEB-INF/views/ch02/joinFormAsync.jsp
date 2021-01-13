 	<%@ page  contentType="text/html; charset=UTF-8"%>
<!-- 완전한 html이 아니고 html조각으로 불린다. 왜 ? 이 내용은 content div안에 들어갈 내용만을 보내기 때문에  이렇게 작성한다 -->
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