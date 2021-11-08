
function quitCheck(mid,mpw){
		var mid = document.getElementById('mid').value;
		var mpw = document.getElementById('mpw').value;
		console.log(mid);
		console.log(mpw);
		var isQuit = confirm('정말 탈퇴를 진행하시겠습니까? ㅜㅜ');
		if(isQuit == true){
			alert('이용해주셔서 감사합니다. withPP는 언제나 회원님을 기다리고있겠습니다:D');
			document.location.href="deleteMember.do?mid="+mid+"&mpw="+mpw;
		}else{
			return false;
		}
	}
