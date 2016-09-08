<%@page import="kr.co.saramin.mysite3.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
// List<GuestbookVo> list = (List<GuestbookVo>) request.getAttribute("list");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>

</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="/guest-book/write" method="POST" onsubmit="return false;">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="message"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
				<c:set var="count" value="${fn:length(list)}" />
				<c:forEach items="${list}" var="vo" varStatus="status">
					<li>
						<table>
							<tr>
								<td>[${status.count}/${count}]</td>
								<td>${vo.name }</td>
								<td>${vo.regDate}</td>
								<td><a href="${pageContext.request.contextPath }/guest-book/deleteform/${vo.no}">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>${vo.message}</td>
							</tr>
						</table>
						<br>
					</li>
				</c:forEach>
				</ul>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation-footer.jsp"></c:import>
	</div>
	
	<script>
$(function () {
	$("input[type=submit]").click(function() {
		event.preventEvent();
		
		var data = {
				name: $("input[name='name']"),
				message: $("textarea[name='message']"),
				password: $("password[name='password']")
		}
		console.log(data);

		$.ajax({
			url : "${pageContext.request.contextPath }/api/guestbook", // /insert
			type : "POST",
			dataType : "json",
			data : JSON.stringfy(data),
			//  contentType: "application/json",
			success : function(response) {
				console.log(response);
				if (response.result != "success") {
					alert("사용중인 이메일 주소 입니다.");
				}
			},
			error : function(jqXHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
})
</script>
</body>
</html>