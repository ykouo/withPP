function loginCheck() {

	var param = "mid" + "=" + $("#mid").val();
	//   alert(param);
	$.ajax({
		url : "/tempPw.do",
		type : "GET",
		data : param,
		cache : false,
		async : false,
		dataType : "text",

		success : function(response) {
			if (response == '1') {
				alert("임시비밀번호 메일 발송완료!")
			} else {
				alert("존재하지 않는 아이디입니다. 아이디찾기를 먼저 진행해주세요:D")
				return false;
			}

			alert(check);
		},
		error : function(request, status, error) {
			if (request.status != '0') {
				alert("code : " + request.status + "\r\nmessage : "
						+ request.reponseText + "\r\nerror : " + error);
			}
		}

	});
}