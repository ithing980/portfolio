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
	<link rel="stylesheet" href="/resources/css/board.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/board.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>	
	<div class="board_wrap">
		<h1>온라인상담</h1>
		<table class="board_table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>					
				</tr>
			</thead>
			<tbody>
				<c:if test="${list.size()==0 }">
					<tr>
						<td colspan="5">등록된 글이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${list.size()>0 }">
					<c:forEach items="${list}" var="post">
						<tr>
							<td>${post.dhc_seq}</td>
							<td><a href="/consult/detail?no=${post.dhc_seq}&post=${post.no}">${post.dhc_title}</a></td>
							<td><fmt:formatDate value="${post.dhc_reg_date}" pattern="yy-MM-dd HH:dd"/></td>
							<td>${post.dhm_name}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<c:if test="${memberInfo != null}">
			<a href="/consult/write" id="write">글쓰기</a>
		</c:if>
<!-- 		<div class="pager_area">
            <button id="prev_10">&lt;&lt;</button>
            <button id="prev_page">&lt;</button>
            <div class="pagers">

            </div>
            <button id="next_page">&gt;</button>
            <button id="next_10">&gt;&gt;</button>
        </div> -->
	</div>
</body>
</html>