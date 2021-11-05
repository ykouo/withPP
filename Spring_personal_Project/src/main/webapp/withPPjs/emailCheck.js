// 이메일 형식 유효성검사 
function emailCheck() {
	var email = document.getElementById("email").value;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	if (exptext.test(email) == false) {
		// 이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐 경우
		alert("이메일 형식이 올바르지 않습니다.");
		return false;
	}

}
