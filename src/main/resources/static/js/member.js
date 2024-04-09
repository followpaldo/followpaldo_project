//로그인
function login_check(){
	
	 if($.trim($("#login_id").val())==""){
		 $("#logincheck").text("아이디를 입력하세요.").css('display','block');//idcheck span 아이디 영역을 숨긴다.
		 $("#iid").addClass('on');
		 $("#login_id").val("").focus();
		 $("#ipw").removeClass('on');
		 return false;
	 }else{
		 $("#iid").removeClass('on');
	 }
	 
	 if($.trim($("#login_pw").val())==""){
		 $("#logincheck").text("비밀번호를 입력하세요.").css('display','block');
		 $("#ipw").addClass('on');
		 $("#login_pw").val("").focus();
		 return false;
	 }
}

// 회원가입 유효성 검사
function check(){
	
	$("#idcheck").hide();//idcheck 아이디 영역을 숨긴다.
	
	 if($.trim($("#id").val())==""){
		 $("#iid").addClass('on');
		 $("#idcheck").show().text("아이디를 입력하세요.").addClass('on');
		 $("#id").val("").focus();
		 return false;
	 }else{
		 $("#iid").removeClass('on');
	 }
	 
	 if($.trim($("#pw").val())==""){
		 $("#ipw").addClass('on');
		 $("#idcheck").show().text("비밀번호를 입력하세요.").addClass('on');
		 $("#pw").val("").focus();
		 return false;
	 }else{
		 $("#ipw").removeClass('on');
	 }

	if($.trim($("#phone").val())==""){
		 $("#iphone").addClass('on');
		 $("#idcheck").show().text("휴대전화번호를 입력하세요.").addClass('on');
		 $("#phone").val("").focus();
		 return false;
	 }else{
		 $("#iphone").removeClass('on');
	 }

	 if($.trim($("#name").val())==""){
		 $("#iname").addClass('on');
		 $("#namecheck").show().text("이름을 입력하세요.").addClass('on');
		 $("#name").val("").focus();
		 return false;
	 }else{
		 $("#iname").removeClass('on');
	 }

	 if($.trim($("#jumin").val())==""){
		 $("#ijumin").addClass('on');
		 $("#namecheck").show().text("주민번호를 입력하세요.").addClass('on');
		 $("#jumin").val("").focus();
		 return false;
	 }else{
		 $("#ijumin").removeClass('on');
	 }
	 
	 if($.trim($("#email").val())==""){
		 $("#iemail").addClass('on');
		 $("#namecheck").show().text("이메일을 입력하세요.").addClass('on');
		 $("#email").val("").focus();
		 return false;
	 } else{
		 $("#iemail").removeClass('on');
	 }
	 
	 if(!$('#chk_agree').is(':checked')){
//		 alert("필수 이용약관에 동의해주세요!");
		 $("#namecheck").show().text("필수 이용약관을 입력하세요.").addClass('on');
		 $("#chk_agree").focus();
		 return false;
	 }	 
 }

//유효성검사 id 체크
function id_check(){
$("#idcheck").hide();//idcheck 아이디 영역을 숨긴다.
var memid=$("#id").val();

//1.입력글자 길이 체크
if($.trim($("#id").val()).length < 3){
	var newtext='<font color="#ff3f3f">아이디는 3자 이상이어야 합니다.</font>';
	$("#idcheck").text('');
	$("#idcheck").show();
	$("#iid").addClass('on');
	$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
	$("#id").val("").focus();
	return false;
	};
if($.trim($("#id").val()).length >12){
	var newtext='<font color="#ff3f3f">아이디는 12자 이하이어야 합니다.</font>';
	$("#idcheck").text('');
	$("#idcheck").show();
	$("#iid").addClass('on');
	$("#idcheck").append(newtext);
	$("#id").val("").focus();
	return false;
	};


//아이디 중복확인
$.ajax({
    type:"Get",
    url:"member_idchek",//요 요청으로 이동
    data: {"memid":memid},        
    success: function (data) { 
  	  if(data==1){			//중복 ID
  		var newtext='<font color="#ff3f3f">중복 아이디입니다.</font>';
  			$("#idcheck").text('');
    		$("#idcheck").show();
			$("#iid").addClass('on');
    		$("#idcheck").append(newtext);
      		$("#id").val('').focus();
      		return false;
     
  	  }else{				//사용 가능한 ID
  		var newtext='<font color="blue">사용가능한 아이디입니다.</font>';
  		$("#idcheck").text('');
  		$("#idcheck").show();
  		$("#iid").removeClass('on');
  		$("#idcheck").append(newtext);
  		$("#pw").focus();
  	  }  	    	  
    }
    ,
	  error:function(e){
		  alert("data error"+e);
	  }
  });//$.ajax
}	
	
//전화번호
function phonecheck(){
$('#phone').on('keyup',function(){
	$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
	});
}

//주민번호
function jumincheck(){
	$('#jumin').on('keyup',function(){
		$(this).val( $(this).val().replace(/[^0-9]/g, '').replace(/^(\d{0,6})(\d{0,7})$/g, '$1-$2').replace(/-{1,2}$/g, ''));
	});
}



// 회원정보 수정 경고창 
function edit_check(){
	
	$("#idcheck").hide();//idcheck 아이디 영역을 숨긴다.
	
	
	 
	 if($.trim($("#pw").val())==""){
		 $("#ipw").addClass('on');
		 $("#idcheck").show().text("비밀번호를 입력하세요.").addClass('on');
		 $("#pw").val("").focus();
		 return false;
	 }else{
		 $("#ipw").removeClass('on');
	 }

	if($.trim($("#phone").val())==""){
		 $("#iphone").addClass('on');
		 $("#idcheck").show().text("휴대전화번호를 입력하세요.").addClass('on');
		 $("#phone").val("").focus();
		 return false;
	 }else{
		 $("#iphone").removeClass('on');
	 }

	 if($.trim($("#name").val())==""){
		 $("#iname").addClass('on');
		 $("#namecheck").show().text("이름을 입력하세요.").addClass('on');
		 $("#name").val("").focus();
		 return false;
	 }else{
		 $("#iname").removeClass('on');
	 }

	 if($.trim($("#jumin").val())==""){
		 $("#ijumin").addClass('on');
		 $("#namecheck").show().text("주민번호를 입력하세요.").addClass('on');
		 $("#jumin").val("").focus();
		 return false;
	 }else{
		 $("#ijumin").removeClass('on');
	 }
	 
	 if($.trim($("#email").val())==""){
		 $("#iemail").addClass('on');
		 $("#namecheck").show().text("이메일을 입력하세요.").addClass('on');
		 $("#email").val("").focus();
		 return false;
	 } else{
		 $("#iemail").removeClass('on');
	 }
	 
}