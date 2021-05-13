<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>치과 홈페이지</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/write.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/write.js"></script>
    <script>
    	let board_seq=19;
    </script>
     <script>
        <c:if test="${memberInfo == null || memberInfo.dhm_type != 1}">
            alert("관리자전용 메뉴입니다.");
            location.href="/";
        </c:if>
    </script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>	
	<div class="content_wrap">
		<h1>공지사항 등록</h1>
		<div class="title" data-user-seq="${memberInfo.dhm_seq}">
			<span>제목</span>
			<input type="text" id="post_title">
		</div>
		<div class="content">
			<textarea id="post_content"></textarea>
		</div>
		<div class="btn_area">
			<button id="save">등록</button>
			<button id="cancel">취소</button>
		</div>
	</div>
</body>
</html>