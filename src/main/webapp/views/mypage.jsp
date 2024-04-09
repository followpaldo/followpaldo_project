<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/mypage.css">
</head>
<body>

    <header>
        <div class="head">
            <div class="headinner">
                <div class="logo">
                    <a href="../views/member/MainPage.jsp" class="logo">
                        <img src="./image/Follow8°_white.svg" class="logo">
                    </a>
                </div>
                <div class="profile">
                    <a href="../views/MyPage.jsp">
                        <img src="./image/profile.svg" class="profile">
                    </a>
                </div> 
            </div>
        </div>
    </header>

    <!-- Main content area -->
    <main>
        <div class="container">
            <div class="box1">
                <div class="box2">
                    <div class="box3">
                        <div class="title">마이페이지</div>
                        <div class="box4">
                            <div class="centerprofile">
                                <img src="./image/profile.svg" class="centerprofile">
                            </div>
                        </div>
                            <div class="insamal" >${id}님 환영합니다.</div>
                            <div class="buttonbox">
                               
                               <button class="btn1" onclick="location='member_logout'">로그아웃</button>
                               <button class="btn2" onclick="location='member_edit'">회원수정</button>
                               <button class="btn3" onclick="location='member_delete'">회원탈퇴</button>
                               <button class="btn4" onclick="location='zzimg'">찜목록</button>
                            </div>   
                    </div> 
                </div>
            </div>
        </div>
    </main>


    <footer>
        <div class="foot">
            <div class="footinner">
                <div class="footleft">
                    <div class="footleft">
                        <img src="./image/Follow8°_black.svg" class="footleft">
                    </div>
                </div> 
                <div class="footright">
                    <div class="footright1">
                        회사소개 | 이용약관 | 고객센터 | 공지사항 
                        | 자주묻는질문 | 개인정보처리방침
                    </div> 
                    <div class="footright2">
                        (주)쫀드기컴퍼니 <br>
                        주소 : 서울특별시 강남구 테헤란로7길 7 에스코빌딩 5,6,7층 | TEL 02-561-1 911 | FAX 02-538-2613<br> 
                        대표이사 : 김현식 | 사업자등록번호 : 123-45-67890<br><br>
                        COPYRIGHT ⓒ ZZONDIGI CORP.  ALL RIGHT RESERVED. 
                    </div>
                </div> 
            </div>
        </div>
    </footer>

    <!-- Include any necessary JavaScript files -->
    <script src="script.js"></script>
</body>
</html>