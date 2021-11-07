/*function quitCheck(){
	var btn = document.getElementById("quitMember");
	
	var input = confirm('정말 탈퇴를 진행하시겠습니까? ㅜㅜ',"");
	if(input == true){
		alert('이용해주셔서 감사합니다. withPP는 언제나 회원님을 기다리고있겠습니다:D');
	}else{
		return false;
	}
	return false;
}*/
$(document).ready(function(){
	$("#quitMember").click(function(){
		var isQuit = confirm('정말 탈퇴를 진행하시겠습니까? ㅜㅜ',"");
		if(input == true){
			alert('이용해주셔서 감사합니다. withPP는 언제나 회원님을 기다리고있겠습니다:D');
		}else{
			return false;
		}
	});
});