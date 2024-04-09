<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="./css/member.css" />

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./js/member.js"></script>

</head>
<body>


	<main>
		<div class="inner">
			<div class="logo">
				<img alt="logo" src="<%=request.getContextPath()%>image/Follow8°_black.svg">
			</div>
			
			<h3>회원가입</h3>
			
			<form id="m_form" name="m_form" method="post" action="member_join_go"
				onsubmit="return check()">																																																																																																																																																																																																																												
				<div class="form_list">
					<div class="form_item_user " id="divid">
					<i class="fa-regular fa-user icon" ></i>
					<input type="text" id="id" name="userId" placeholder="아이디" class="input" value="" maxlength="20">
					<button type="button" class="id_check_button" onclick="id_check()">중복확인</button>
					</div>
					
					<div class="form_item_user" id="divpw">
					<i class="fa-solid fa-lock icon" id="ipw"></i>
					<input type="password" id="pw" name="userPw" placeholder="비밀번호" class="input" value="" maxlength="16">
					</div>
					
					<div class="form_item_user" id="divtel">
					<i class="fa-solid fa-phone icon" id="iphone"> </i>
					<input type="tel" id="phone" name="userPhone" oninput=" phonecheck(this)" placeholder="휴대전화번호" class="input" value="" maxlength="13">
					<!-- <div id="formatted-phone"></div> -->
					</div>
				</div>
				<!-- id 중복확인/pw/phone 경고문구 -->
				<div id="idcheck"></div>
				
				<div class="form_list">
					<div class="form_item_user" id="divname">
					<i class="fa-regular fa-user icon" id="iname"></i>
					<input type="text" id="name" name="userName" placeholder="이름" class="input" value="" maxlength="6">
					</div>
					
					<div class="form_item_user" id="divjumin">
					<i class="fa-regular fa-address-card icon" id="ijumin"></i>
					<input type="text" id="jumin" name="userJumin" oninput="jumincheck(this)" placeholder="주민번호" class="input" value="" maxlength="14">
					</div>
					
					<div class="form_item_user" id="divmail">
					<i class="fa-regular fa-envelope icon" id="iemail"></i>
					<input type="email" id="email" name="userEmail" placeholder="abc@zzon.com" class="input" value="" maxlength="20">
					</div>
				</div>
				<!-- 두번째폼 경고문구 -->
				<div id="namecheck"></div>
				
				
				<div class="form_list" id="gender_from">
					<input type="radio" id="gender_m" name="userGender" class="input" value="남자">
					<label for="gender_m">남자</label>
					<input type="radio" id="gender_w" name="userGender" class="input" value="여자">
					<label for="gender_w">여자</label>
				</div>
			
				<div class="form_list">
					<div class="check_wrap">
						<input type="checkbox" id="chk_agree">
						<label for="chk_agree">필수 이용약관</label>
					</div>
				</div>

				<div id="join_menu">
					<input type="submit" value="회원가입" class="input_button" id="join_button" />
				</div>
			</form>
		</div>
	</main>


</body>
</html>
