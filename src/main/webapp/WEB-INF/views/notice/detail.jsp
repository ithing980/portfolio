<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>치과 홈페이지</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/detail.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/detail.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
	<div class="content_wrap">
		<h1>공지사항</h1>
		<div class="title_area">
			<div class="title_left">
				<span id="dhn_seq">${data.dhn_seq}</span>
				<span id="no"></span>
				<span id="post_title">${data.dhn_title}</span>
			</div>
			<div class="title_right">
				<span id="post_date">작성일</span>
					<fmt:formatDate value="${data.dhn_reg_date}" pattern="yyyy-MM-dd HH:mm"/>
<%-- 				<span id="post_count"><i class="fas fa-eye"></i>${data.dhn_count}</span> --%>
			</div>
		</div>
		<div class="content_area">
			${data.dhn_content}		
		</div>
 		<c:if test="${memberInfo.dhm_type==1}"> 
            <div class="post_control">
            	<a href="#" id="post_delete">삭제</a>
                <a href="/notice/modify?seq=${data.dhn_seq}" id="post_modify">수정</a>
                
            </div>
        </c:if> 
	</div>
</body>
</html>