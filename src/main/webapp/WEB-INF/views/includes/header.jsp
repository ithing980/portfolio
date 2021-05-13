<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>치과 홈페이지</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/header.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/menu.js"></script>
</head>
<body>
	<header>
		<div class="upper">
			<c:if test="${memberInfo == null }">
				<a href="/">HOME</a>
				<a href="/join">JOIN</a>
				<a href="/login">LOGIN</a>
			</c:if>				
			<c:if test="${memberInfo != null }">
				<a href="/">HOME</a>
				<a href="/logout">LOGOUT</a>
				<a href="/">${memberInfo.dhm_name }님</a>
			</c:if>			
		</div>
		
		<img id="logo_header" src="/resources/images/logo.png">
		<nav id="gnb">
			<ul></ul>
		</nav>
<!-- 		<div class="main">
			<div class="dental">
				<img id="logo_header" src="/resources/images/logo.png">
				<a href="/">치과</a>
				<a href="/">임플란트</a>
				<a href="/">치주치료</a>
				<a href="/">보철보존치료</a>
				<a href="/">고객센터</a>
			</div>		
		</div> -->		
	</header>
</body>
</html>