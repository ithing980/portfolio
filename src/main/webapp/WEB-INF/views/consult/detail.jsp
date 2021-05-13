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
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>	
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/consult.js"></script>
	<script>
        let userRole = "${memberInfo.dhm_type}";
    </script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
	<div class="content_wrap">
		<h1>온라인 상담</h1>
		<div class="title_area">
			<div class="title_left">
				<span id="dhc_seq">${data.dhc_seq} </span>
				<span id="no"></span>
				<span id="post_title">${data.dhc_title} <span class="comment_cnt"></span></span>
			</div>
			<div class="title_right">
				<span id="post_date">작성일</span>
					<fmt:formatDate value="${data.dhc_reg_date}" pattern="yyyy-MM-dd HH:mm"/>
<%-- 				<span id="post_count"><i class="fas fa-eye"></i>${data.dhn_count}</span> --%>
			</div>
		</div>
		<div class="content_area">
			${data.dhc_content}		
		</div>
		<c:if test="${data.dhc_owner == memberInfo.dhm_seq}"> 
			<div class="post_control">
				<a href="#" id="post_delete1">삭제</a>
                <a href="/consult/modify?seq=${data.dhc_seq}" id="post_modify">수정</a>
                
            </div>
        </c:if>
	</div>
	<div class="comment_area">
		<c:if test="${memberInfo.dhm_type==1}">
                <div class="comment_input">
                    <h1>댓글 쓰기</h1>
                    <textarea id="comment_content" placeholder="댓글을 입력해주세요" style="resize: none"></textarea>
                    <button id="comment_input_btn">확인</button>
                </div>
          </c:if>
	      <p><i class="far fa-comment-dots"></i> 댓글 <span id="total_comments"></span>개</p>
	      <div class="comment_list">
			
	      </div>
 	      <div class="more">
                <button id="more_btn">댓글 더 보기</button>
          </div> 	      	
   	</div>
   	
</body>
</html>