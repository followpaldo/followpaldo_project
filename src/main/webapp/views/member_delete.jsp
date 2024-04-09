<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" type="text/css" href="./css/member.css" />
<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->

</head>
<body>
<header></header>

<main>
	<div class="inner">
		<div class="logo">
			<img alt="logo" src="<%=request.getContextPath()%>image/Follow8°_black.svg">
		</div>
		
		<form id="m_form" name="m_form" method="post" action="member_delete_go"
			onsubmit ="return login_check()">
			
			<h1 class="h">${id}님, 회원을 탈퇴하시겠습니까?</h1>		
																																																																																																																																																																																																																									
			<div class="form_list" >
				<div class="form_item_user" id="divpw">
				<i class="fa-solid fa-lock icon"></i>
				<input type="password" id="login_pw" name="userPw" placeholder="확인을 위해 비밀번호를 입력해 주세요" class="input" value="" maxlength="16">
				</div>
			</div>
			
			<div id="logincheck">아이디를 입력하세요</div>

			<div id="login_menu">
				<input type="submit" value="회원탈퇴" class="input_button"/>
		
			</div>
		</form>
	</div>
</main>

<footer> </footer>


</body>
</html>