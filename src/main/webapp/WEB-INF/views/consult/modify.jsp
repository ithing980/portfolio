<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 : 수정</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/resources/js/consult.js"></script>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/write.css">
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <div class="content_wrap">
        <h1>글 수정</h1>
        <div class="title" data-user-seq="${memberInfo.dhm_seq}" data-post-seq="${postInfo.dhc_seq}">
            <span>제목</span>
            <input type="text" id="post_title" value="${postInfo.dhc_title}">
        </div>
        <div class="content">
            <textarea id="post_content">${postInfo.dhc_content}</textarea>
        </div>
        <div class="btn_area">
            <button id="post_save">수정</button>
            <button id="post_cancel">취소</button>
        </div>
    </div>
</body>
</html>