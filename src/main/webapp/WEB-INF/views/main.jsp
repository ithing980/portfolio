<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>치과 홈페이지</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/main.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/consult.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>	
	<div class="main">
		<section class="main_list">
			<h1>진료 내역</h1>
			<p>그랜드 치과의 진료내역을 안내합니다</p>
			<div class="care">
				<div class="left_box">
					<div class="icon1">
						<img src="/resources/images/icon01.png"/> 
						<div class="intro">
							<h4>임플란트</h4>
							<p>시간 단축으로 편리한 일상생활</p>
							<a href="/implant">more</a>
						</div>
					</div>					
					<div class="icon2">
						<div><img src="/resources/images/icon02.png"></div>
						<div class="intro">
							<h4>치주치료</h4>
							<p>구강건강의 기본, 잇몸관리의 시작</p>
							<a href="/perio">more</a>
						</div>
					</div>
				</div>				
				
				<img id="logo" src="/resources/images/st4_img.jpg">	
				
				<div class="right_box">			
					<div class="icon3">
						<img src="/resources/images/icon03.png">
						<div class="intro">
							<h4>보철보존치료</h4>
							<p>수준높은 직영가공소의 가공기술과
								첨단 맞춤 보철 시스템</p>
							<a href="/treatment">more</a>
						</div>
					</div>
					<div class="icon4">
						<img src="/resources/images/icon06.png">
						<div class="intro">
							<h4>증상</h4>
							<P>턱관절,코골이,이갈이등의 다양한 증상의 원인을 찾고 <br>
							 치료를 도와드립니다.</P> 
							<a href="/consult">more</a>
						</div>
					</div>
				</div>				
			</div>		
		</section>
		<section class="consult">
			<h1>온라인 상담</h1>
				<img src="/resources/images/st3_con.jpg">				
			<div class="connect">
				<p>쉽고 빠르게 온라인으로<br> 상담을 신청해보세요.</p>
				<button id="consult_move">온라인 상담 > </button>
			</div>				
		</section>
		<%-- <section class="s1">
            <div class="notice">
                <div class="notice_header">
                    <p>공지사항</p>
                    <a href="/notice">more</a>
                </div>
                <div class="notice_contents">
                    <c:forEach items="${noticeList}" var="notice">
                        <a href="/notice/detail?no=${notice.dhn_seq}&post=${notice.no}" class="notice_item">
                            <span class="title">
                                <i>※</i> ${notice.dhn_title}
                            </span>
                            <span class="date">
                                <fmt:formatDate value="${notice.dhn_reg_dt}" pattern="yyy-MM-dd HH:mm"/>
                            </span>
                        </a>
                    </c:forEach>
                </div>
            </div>
         </section> --%>
	</div>
</body>
</html>