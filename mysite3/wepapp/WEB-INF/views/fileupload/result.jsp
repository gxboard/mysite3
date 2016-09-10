<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>  
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
			
	<h1>Upload completed</h1>

	<div class="result-images">
		<c:if test="${not empty productImageUrl1 }">
			<img src="/fileupload${productImageUrl1 }" style="width:150px"><br>
		</c:if>
	</div>

	<p>
		<a href='/fileupload/form'> 다시 업로드 하기 </a>
	</p>
	
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation-footer.jsp"></c:import>
	</div>
	
</body>
</html>