<!--  회원가입 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <title>SignUp- withPP </title>
    <!--  파비콘 추가  -->
    <mytag:Fabicon/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- 주소검색  -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- styleLink모음 태그 -->
	<mytag:styleLink/>    
  	<!-- ajax 사용을 위한  jquery추가  -->
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
	//우편번호 주소 등록==========================================================================================================================
    function searchPostCode(){new daum.Postcode({
		oncomplete: function(data){
	        // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	       //	roadAddress = data.roadAddress; // 도로명 주소 변수
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
	        //jibunAddress.value = data.jibunAddress;
	          
	        autoClose: true; // 선택하면 팝업창이 자동으로 닫힌다.     
	         
	        var detailAddress = document.getElementById("detailAddress");
	        detailAddress.focus(); // 팝업창이 닫히면 상세주소 란으로 포커싱 
		}
	}).open();}
	</script>
  </head> 
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300"> 
    <div class="site-wrap" id="home-section">   
	<!-- 메뉴/로그인/로그아웃/마이페이지 버튼 태그 -->
	<mytag:header/>
	<!-- <메인 이미지> -->  
    <div class="ftco-blocks-cover-10" style="height:300px;">
        <div class="ftco-cover-1">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                  <h1><span class="text-primary">🎀 SIGN UP 🎀</span> </h1>
                  <p>🎈 Welcome withPP🤗  </p>
                </div>
              </div>
            </div>
        </div>
      </div> 
	<!-- </메인 이미지>  -->
	<div class="site-section">
		<div class="container">
			<div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center ">
					<div class="row align-items-center justify-content-center">
						<form action="insertMember.do" class="joinTable" method="post" style="text-align: left" enctype="multipart/form-data">
							<table>
								<tr class="tableCenter">
									<td class="category">미리보기</td>
									<td colspan="2">
										<img src="images/thumnail.png" class="thumb" style="width: 150px; height: 150px;" />
									</td>
								</tr>
								<tr class="tableCenter">
									<td class="category">프로필이미지</td>
									<td colspan="2"><input type="file" class="hidden_input" id="imageSelector" name="fileUpLoad" 
										accept="image/jpeg, image/jpg, image/png" multiple />
									</td>
								</tr>
								<tr class="tableCenter">
									<td>ID <b style="color: red">*</b></td>
									<td colspan="2"><input type="text" name="mid" id="mid" style="width: 80%" required="required"> 
									<input class="checkDupli" type="button" onclick="checkId();" value="중복"> 
									<span class="id_ok">사용 가능한 아이디입니다.</span>
									<span class="id_already">사용중인 아이디입니다.</span></td>
								</tr>
								<tr class="tableCenter">
									<td>PASSWORD <b style="color: red">*</b></td>
									<td colspan="2"><input type="password" name="mpw" id="password" required="required"
										onkeyup="javascript:passConfirm()" placeholder="영문,특수문자(@!%*#?&),숫자를 포함한 8~16자리"
										pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$">
									</td>
								</tr>
								<tr>
									<td>PASSWORD CHECK <b style="color: red">*</b></td>
									<td colspan="2"><input type="password" id="passwordConfirm" onkeyup="javascript:passConfirm()"
										placeholder="비밀번호 확인" required="required" 
										pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$">
										<span id="confirmMsg"></span>
									</td>
								</tr>
								<tr>
									<td>NICKNAME <b style="color: red">*</b></td>
									<td><input type="text" name="nickname" required="required"></td>
								</tr>
								<tr class="tableCenter">
									<td>PHONE <b style="color: red">*</b></td>
									<td colspan="2">
										<input type="tel" id="phoneNum"	class="textbox" name="phone" required="required"
										maxlength="13" style="resize: none;">
									</td>
								</tr>
								<tr class="tableCenter">
									<td>BIRTH <b style="color: red">*</b></td>
									<td colspan="2"><input type="date" name="birth" required="required"></td>
								</tr>
								<tr>
									<td>POST CODE</td>
									<td colspan="2"><input id="postcode" type="text" name="postcode" placeholder="우편번호"> 
										<input class="primary" type="button" id="btn" onClick="searchPostCode()" value="주소검색">
									</td>
								<tr class="tableCenter">
									<td>ADDRESS <b style="color: red">*</b></td>
									<td colspan="2"><input type="text" id="roadAddress"name="roadaddress" /><br></td>
								</tr>
								<tr class="tableCenter">
									<td>DETAIL ADDRESS</td>
									<td colspan="2"><input type="text" id="detailAddress" name="detailaddress" placeholder="상세 주소" /><br></td>
								</tr>
								<tr class="tableCenter">
									<td>EMAIL <b style="color: red">*</b></td>
									<td colspan="2"><input type="email" name="email" id="email" required="required">
										<input type="button" onclick="checkEmail()" value="이메일확인"> 
										<span class="email_ok">사용 가능한 이메일입니다.</span> 
										<span class="email_already">이미 등록된 이메일입니다.</span>
									</td>
								</tr>
								<tr class="tableCenter">
									<td>ROLE</td>
									<td colspan="2"><input type="radio" name="role" value="USER" checked="checked">회원</td>
								</tr>
								<tr class="tableCenter">
									<td colspan="3"><input type="submit" value="회원가입"></td>
								</tr>
							</table>
						</form>
					</div>
				<div>
					<a href="index.jsp">메인바로가기</a>
				</div>
				</div>
			</div>
		</div>
	</div>
    <!-- footer 태그  -->
	<mytag:footer/>
    </div>  
	<!-- js리스트 태그 -->
	<mytag:js/>
	<script src="withPPjs/upload.js"></script>
	<script src="withPPjs/autoHypen.js"></script>
	<script src="withPPjs/emailCheck.js"></script>
	<script src="withPPjs/emailDupliCheck.js"></script>
	<script src="withPPjs/idCheck.js"></script>
	<script src="withPPjs/passwordCheck.js"></script>
  </body>
</html>
