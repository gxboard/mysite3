<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="POST" action="/guest-book/delete">
					<label>비밀번호</label>
					<input type="hidden"   name="no" value="${no }">
					<input type="password" name="password" value="">
					<input type="submit" value="확인">
				</form>
				<a href="/guest-book/">방명록 리스트</a>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation-footer.jsp"></c:import>
	</div>
</body>
</html>