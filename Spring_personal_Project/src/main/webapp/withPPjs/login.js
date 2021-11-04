
//로그인 유효성 검사===========================================================================================================================
var logBtn = document.querySelector('#logCheck');
if (logBtn != null)
   logBtn.onclick = function() {
      
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




