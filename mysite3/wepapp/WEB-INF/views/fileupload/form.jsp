<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Example</title>
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="fileupload">

<h1>파일 업로드 예제</h1>
<form method="post" action="upload" enctype="multipart/form-data">
	<label>email:</label>
	<input type="text" name="email" value="kickscar@gmail.com">
	<br><br>
	
	<label>파일1:</label>
	<input type="file" name="file1">
	<br><br>
	
	<label>파일2:</label>
	<input type="file" name="file2">
	<br><br>
	
	<br>
	<input type="submit" value="upload">
</form>

			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation-footer.jsp"></c:import>
	</div>
</body>
</html>