// 아이디 중복체크 
function checkId(){
        var mid = $('#mid').val(); //id값이 "id"인 입력란의 값을 저장
        
        if(mid== '' || mid==null){
        	alert('아이디 입력해주세요');
        	return;
        }
        console.log(mid);
        $.ajax({
            url:'checkID.do', //Controller에서 인식할 주소
            type:'post', //POST 방식으로 전달
            data:{mid:mid},
            success:function(check){
            	const check1 = $.trim(check);
            	if(check1 == 'no'){
            	   $('.id_already').css("display","inline-block");
                   $('.id_ok').css("display", "none");
                   $("input[name='mid']").val("");
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
 	

