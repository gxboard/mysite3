<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>mysite3</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
  <div id="container">

    <c:import url="/WEB-INF/views/include/header.jsp"></c:import>

    <div id="wrapper">
      <div id="content">
        <div id="site-introduction">
          <img id="profile"
            src="${pageContext.request.contextPath }/assets/images/26285_109307805767013_4946997_n.jpg">
          <h2>안녕하세요. 엄기화(xhunter)의 mysite3에 오신 것을 환영합니다.</h2>
          <p>
            이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록,
            게시판이 있습니다.<br> JAVA 수업 + 데이터베이스 수업 + Servlet/JSP +
            Spring MVC + JPA(Hibernate) 수업 배운 거 있는거 없는 거 다 합쳐서 만들어 놓은
            사이트 입니다.<br>
            <br> <a
              href="${pageContext.request.contextPath }/guest-book/">방명록</a>에
            글 남기기<br>
            pageContext = ${pageContext } <br />
            requets = ${pageContext.request } <br />
            remoteUser   = ${pageContext.request.remoteUser } <br />
          </p>
        </div>
      </div>
    </div>
    <c:import url="/WEB-INF/views/include/navigation-footer.jsp"></c:import>
  </div>
</body>
</html>