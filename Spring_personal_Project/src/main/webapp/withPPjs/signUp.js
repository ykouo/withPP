function signUpCheck(){
	console.log("여기 들어왔니");
	var mid = document.getElementById("mid");
	var email = document.getElementById("email");
	if($('.id_ok').css("display")== "none" && $('.id_already').css("display")== "none"){
		alert("아이디 중복체크를 진행하세요");
		return false;
	}
	if($('.email_ok').css("display")== "none" && $('.email_already').css("display")== "none"){
		alert("이메일 중복체크를 진행하세요");
		return false;
	}
	return false;
}