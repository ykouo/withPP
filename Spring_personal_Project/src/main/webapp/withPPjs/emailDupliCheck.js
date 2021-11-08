// 이메일 중복체크 
function checkEmail() {
	var email = $('#email').val(); //id값이 "id"인 입력란의 값을 저장
	if(email==''){
		alert('이메일을 입력해주세요.');
		return false;
	}
	console.log(email);
	$.ajax({
		url : 'emailCheck.do', //Controller에서 인식할 주소
		type : 'post', //POST 방식으로 전달
		data : {
			email : email
		},
		success : function(check) {
			const check1 = $.trim(check);
			if (check1 == 'no') {
				$('.email_already').css("display", "inline-block");
				$('.email_ok').css("display", "none");
				 $("input[name='email']").val("");
				return false;
			} else {
				$('.email_ok').css("display", "inline-block");
				$('.email_already').css("display", "none");
				return false;
			}
		},
		error : function() {
			alert("에러입니다");
			return false;
		}
	});
	return false;
};
