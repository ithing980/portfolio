<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입약관 | 그랜드치과</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/join.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/join.js"></script>
</head>
<body>	
   <%@include file="/WEB-INF/views/includes/header.jsp" %>	
	<div class="join_box">
		<h1>회원가입</h1>
		<p>* 표시된 항목은 필수 항목입니다.</p>
		<div class="row">
			<div><span class="necessary">*</span>아이디</div>
			<input type="text" id="member_id">
			<button id="dup_check">중복확인</button>
		</div>
		<div class="row">
			<div><span class="necessary">*</span>비밀번호</div>
			<input type="password" id="member_pwd">
		</div>
		<div class="row">
			<div><span class="necessary">*</span>비밀번호확인</div>
			<input type="password" id="member_pwd_confirm">
		</div>
		<div class="row">
			<div><span class="necessary">*</span>이름</div>
			<input type="text" id="member_name">
		</div>
		<div class="row">
			<div><span class="necessary">*</span>이메일</div>
			<input type="text" id="member_email">
		</div>
		<div class="row">
			<div><span class="necessary">*</span>휴대폰번호</div>
			<input type="text" id="member_phone">
		</div>
		<div class=agree>
			<div class="row">
				<div>개인정보수집동의</div>
				<div class="privacy">
					<p>동의합니다</p>
					<input type="checkbox">
					<a href="#">약관보기</a>
				</div>
			</div>
			<div class="row">
				<div>이용약관동의</div>
				<div class="terms">
					<p>동의합니다</p>
					<input type="checkbox">
					<a href="#">약관보기</a>
				</div>
			</div>
		</div>
	</div>
	<div class="btn_area">
		<button id="join_btn">회원가입</button>
		<button id="cancel">취소</button>
	</div>
</body>
</html>