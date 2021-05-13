<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>진료안내 > 진료안내 </title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/information.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
	<div class="img_wrap">
		<div><img src="/resources/images/tr1.jpg" class="img1"></div>
		<div><img src="/resources/images/tr4.jpg" class="img2">
		<div class="time">진료시간</div>
		</div>
		<div>
			<img src="/resources/images/tr2.jpg" class="img3">
			<div class="title_detail">
				<div>월 ~ 목    오전 9:30 - 오후 8:30</div> <br>
				<div>금요일             오전 9:30 - 오후 6:30</div> <br>
				<div>토요일             오전 9:30 - 오후 2:30</div> <br>
				<div class="end">일요일 공휴일 휴진</div> <br>
				<div>점심시간 (12:30 - 2:00)</div>
			</div>
		<div>
			<img src="/resources/images/tr3.jpg" class="img4"></div>
			<div class="subject">
				<div>임플란트    치주</div><br>
				<div>신경치료     보존치료</div><br>
				<div>심미보철     일반치료</div><br>
			</div>
		</div>
	</div>
</body>
</html>