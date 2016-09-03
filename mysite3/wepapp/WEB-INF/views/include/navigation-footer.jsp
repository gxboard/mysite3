<%@page import="org.apache.jasper.tagplugins.jstl.core.Remove"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="navigation">
  <ul>
    <li><a href="/">엄기화</a></li>
    <li><a href="/guest-book/">방명록</a></li>
    <li><a href="/board/">게시판</a></li>
  </ul>
</div>
<div id="footer">
  <p>(c)opyright 2015</p>
</div>
<c:if test="${not empty sessionScope.flashMessage }">
<script>
alert("${sessionScope.flashMessage}");
</script>
<c:remove var="flashMessage" scope="session"/>
</c:if>