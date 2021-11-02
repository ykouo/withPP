
function checkId(){
        var mid = $('#mid').val(); //id값이 "id"인 입력란의 값을 저장
        console.log(mid);
        $.ajax({
            url:'idCheck.do', //Controller에서 인식할 주소
            type:'post', //POST 방식으로 전달
            data:{mid:mid},
            success:function(check){
            	const check1 = $.trim(check);
            	if(check1 == 'no'){
            	   $('.id_already').css("display","inline-block");
                   $('.id_ok').css("display", "none");
               }else{
            	   $('.id_ok').css("display","inline-block"); 
                   $('.id_already').css("display", "none");
               }
            },
            error:function(){
            	alert("에러입니다");
            }
        });
    };
 	
    function checkEmail(){
        var email = $('#email').val(); //id값이 "id"인 입력란의 값을 저장
        console.log(email);
        $.ajax({
            url:'emailCheck.do', //Controller에서 인식할 주소
            type:'post', //POST 방식으로 전달
            data:{email:email},
            success:function(check){
            	const check1 = $.trim(check);
            	if(check1 == 'no'){
            	   $('.email_already').css("display","inline-block");
                   $('.email_ok').css("display", "none");
               }else{
            	   $('.email_ok').css("display","inline-block"); 
                   $('.email_already').css("display", "none");
               }
            },
            error:function(){
            	alert("에러입니다");
            }
        });
    };
 // 비밀번호 체크 
    function passConfirm() {
    	/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
    	/* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
    	/* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
    		var password = document.getElementById('password');					//비밀번호 
    		var passwordConfirm = document.getElementById('passwordConfirm');	//비밀번호 확인 값
    		var confirmMsg = document.getElementById('confirmMsg');				//확인 메세지
    		var correctColor = "tomato";	//맞았을 때 출력되는 색깔.
    		var wrongColor ="gold";	//틀렸을 때 출력되는 색깔
    		
    		if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
    			confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
    			confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
    		}else{
    			confirmMsg.style.color = wrongColor;
    			confirmMsg.innerHTML ="비밀번호 불일치";
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

//하이픈 자동입력 & 전화번호 입력 유효성검사 
var autoHypenPhone = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 4){
	          return str;
	      }else if(str.length < 7){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3);
	          return tmp;
	      }else if(str.length < 11){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 3);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }else{              
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 4);
	          tmp += '-';
	          tmp += str.substr(7);
	          return tmp;
	      }
	  
	      return str;
	}


	var phoneNum = document.getElementById('phoneNum');

	phoneNum.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenPhone( this.value ) ;  
	}
    