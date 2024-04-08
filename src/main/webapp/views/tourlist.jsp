<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="jjon.gangsan.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/tour.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 글목록  -->
	<div class=container>
	
		<div class="region-area">
			<h1>${region } 관광지 리스트</h1>
		</div>
		<div>글 개수 : ${listcount }</div>
		<div>
			<c:forEach var="t" items="${tourlist }">
				<div class="content">
					<div class="img-area">
						<img src="${t.image }">
					</div>
					
					<div class="content-area">
						<div class="title-area">
							<h2>${t.title }</h2>
						</div>
						<div class="addr-area">
							${t.addr1 }
						</div>
						<div class="tel-area">
							${t.tel }
						</div>
					</div>
				</div>
			</c:forEach>
			
	</div>

		<div class="page-area">
	
			<c:if test="${page <=1 }">
				[이전]&nbsp;
			</c:if>
			
			<c:if test="${page >1 }">
				<a href="?page=${page-1 }&region=${region}">[이전]</a>&nbsp;
			</c:if>
			
			<c:forEach var="a" begin="${startPage }" end="${endPage }">
				<c:if test="${a == page }">
				[${a }]
				</c:if>
				<c:if test="${a!= page }">
					<a href="?page=${a }&region=${region}">[${a }]</a>&nbsp;
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxPage }">
				[다음]
			</c:if>
			
			<c:if test="${page < maxPage }">
				<a href="?page=${page+1 }&region=${region}">[다음]</a>
			</c:if>
		</div>


</body>
</html>