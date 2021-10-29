// 로그인 js
//임시번호 메일 보내기===========================================================================================================================
function send_mail() {
   window.open("./IInfo.jsp", "", "width=800, height=550, resizable=no, scrollbars=no, status=no");
}
//로그인 유효성 검사===========================================================================================================================
var logBtn = document.querySelector('#logCheck');
if (logBtn != null)
   logBtn.onclick = function() {
      console.log("1");
      var idCheck = document.getElementById("idCheck");
      var pwCheck = document.getElementById("pwCheck");

      if (idCheck.value == "") {
         alert("아이디를 입력하세요.");
         idCheck.focus();
         return false;
      }
      if (pwCheck.value == "") {
         alert("비밀번호를 입력하세요.");
         pwCheck.focus();
         return false;
      } else {
         return true;

      }

   };


//카카오 주소 api==========================================================================================================================

window.onload = function() {
   if (document.getElementById("address_kakao") != null) {
      document.getElementById("address_kakao").addEventListener("click", function() { //주소입력칸을 클릭하면
         //카카오 지도 발생
         new daum.Postcode(
            {
               oncomplete: function(data) { //선택시 입력값 세팅
                  document
                     .getElementById("address_kakao").value = data.address; // 주소 넣기
                  document
                     .querySelector(
                        "input[name=address_detail]")
                     .focus(); //상세입력 포커싱
               }
            }).open();
      });
   }
}

//우편번호 주소 등록==========================================================================================================================
   function searchPostCode(){new daum.Postcode({
		oncomplete: function(data){
	        // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	       // roadAddress = data.roadAddress; // 도로명 주소 변수
	        var extraRoadAddr = ''; // 참고 항목 변수

	        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	            extraRoadAddr += data.bname;
	        }
	        // 건물명이 있고, 공동주택일 경우 추가한다.
	        if(data.buildingName !== '' && data.apartment === 'Y'){
	           extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	        }
	        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	        if(extraRoadAddr !== ''){
	            extraRoadAddr = ' (' + extraRoadAddr + ')';
	        }
	        // 우편번호와 주소 정보를 해당 필드에 넣는다.
	        postcode.value = data.zonecode;
	        roadAddress.value = data.roadAddress;
	       // jibunAddress.value = data.jibunAddress;
	          
	        autoClose: true; // 선택하면 팝업창이 자동으로 닫힌다.     
	         
	        var detailAddress = document.getElementById("detailAddress");
	        detailAddress.focus(); // 팝업창이 닫히면 상세주소 란으로 포커싱 
		}
	}).open();}