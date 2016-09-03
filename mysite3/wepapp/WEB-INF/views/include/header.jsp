<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="header">
  <h1>
    <a href="/">MySite3</a>
  </h1>
  <ul>
    <c:choose>
      <c:when test="${empty sessionScope.authUser }">
        <li><a href="/user/loginform">로그인</a>
        <li>
        <li><a href="/user/joinform">회원가입</a>
        <li>
      </c:when>
      <c:otherwise>
        <li><a href="/user/modifyform">회원정보수정</a>
        <li>
        <li><a href="/user/logout">로그아웃</a>
        <li>
        <li>${authUser.name }(${authUser.no })님 안녕하세요^^;</li>
      </c:otherwise>
    </c:choose>
  </ul>
</div>