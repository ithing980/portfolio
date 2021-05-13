<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 | 그랜드치과</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/login.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/login.js"></script>
<!-- 	<script>
        <c:if test="${MemberInfo != null}">
            location.href = "/";
        </c:if>
    </script> -->
</head>
<body>
   <%@include file="/WEB-INF/views/includes/header.jsp" %>	
	<div class="login_box">	
	   <h1>LOGIN</h1>
		<div class="row">
			<span id="id">아이디</span>
			<input type="text" id="member_id">
		</div>
		<div class="row">
			<span>비밀번호</span>
			<input type="password" id="member_pwd">
		</div>
		<div class="row">
			<button id="login_btn">로그인</button>
			<button id="home">메인</button>
		</div>		
	</div>
</body>
</html>