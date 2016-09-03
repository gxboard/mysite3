<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="/user/login">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
					<c:if test="${param.result == 'fail' }">
					<p>
						로그인이 실패 했습니다.
					</p>
					</c:if>
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation-footer.jsp"></c:import>
	</div>
</body>
</html>