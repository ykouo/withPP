

var signUp = document.querySelector("#signUp");
if(signUp != null){
	signUp.onclick = function(){
		console.log("회원가입");
	
	if ($('.id_ok').css("display")== "none" && $('.id_already').css("display")== "none") {
		alert("아이디 중복확인하시기 바랍니다.");
		document.getElementById("mid").focus();
		return false;
	}
	if ($('.email_ok').css("display")== "none" && $('.email_already').css("display")== "none") {
		alert("이메일 중복확인하시기 바랍니다.");
		document.getElementById("email").focus();
		return false;
	}
	}
}