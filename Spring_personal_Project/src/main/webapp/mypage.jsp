<!--  회원가입 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">

  <head>
    <title>MYPAGE - withPP </title>
    <!--  파비콘 추가  -->
    <mytag:Fabicon/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- styleLink모음 태그 -->
	<mytag:styleLink/>    
	<!-- 주소검색  -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  </head>
 
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300"> 
    <div class="site-wrap" id="home-section">
      <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
          </div>
        </div>
        <div class="site-mobile-menu-body"></div>
      </div>
      
	<!-- 메뉴/로그인/로그아웃/마이페이지 버튼 태그 -->
	<mytag:header/>
	<!-- <메인 이미지> -->  
    <div class="ftco-blocks-cover-10" style="height:300px;">
        <div class="ftco-cover-1"> <!-- style="background-image: url('images/hero_1.jpg');" -->
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                  <h1><span class="text-primary">Mypage</span> </h1>
                  <p>회원정보 변경</p>
                  
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
						<form action="updateMember.do" class="joinTable" method="post" style="text-align: left" enctype="multipart/form-data">
							<input type="hidden" name="profileimage" value="${mem.profileimage}">
							<%-- <input type="hidden" name="mid" value="${mem.mid}"> --%>
							<table>
								<tr>
									<td class="category">미리보기</td>
								 	<td><img src="images/thumnail.png" alt="프로필이미지" class="thumb" style="width:150px;height:150px;"/></td>	
   								 	<td><a  href="javascript:void(0);" class="dellink btn">삭제</a></td>
   								 </tr>
   								 <tr>	
   								 	<td class="category">프로필이미지</td>
									<td colspan="2"><input type="file" class="hidden_input" id="imageSelector"
										name="fileUpLoad" accept="image/jpeg, image/jpg, image/png"
										multiple/>
									</td>
								</tr>
								<tr>
									<td>ID</td>
									<td colspan="2">
										<input type="text" name="mid" id="mid" value="${mem.mid}" readonly="readonly" >
									</td>
									
								</tr>
								<tr>
									<td>PASSWORD</td>
									<td colspan="2"><input type="password" name="mpw" id="password" value="${mem.mpw}"  required="required" placeholder="영문,특수문자(@!%*#?&),숫자를 포함한 8~16자리" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$">
									</td>
								</tr>
								<tr>
									<td>PASSWORD CHECK</td>
									<td colspan="2"><input type="password" id="passwordConfirm" onkeyup="javascript:passConfirm()" placeholder="비밀번호 확인" required="required" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"><span id="confirmMsg"></span></td>
									
								</tr>
								<tr>
									<td>NICKNAME</td>
									<td><input type="text" name="nickname" value="${mem.nickname}" required="required"></td>
								</tr>
								<tr>
									<td>PHONE</td>
									<td colspan="4"><input type="tel" onkeyup="" id="phoneNum"class="textbox" name="phone" value="${mem.phone}" required="required" maxlength="13" style="width:100%; resize:none;"></td>
								</tr>
								<tr>
									<td>BIRTH</td>
									<td colspan="4"><input type="date" name="birth" value="${mem.birth}"  required="required"></td>
								</tr>
								<tr>
									<td>ADDRESS</td>
									<td><input id="postcode" type="text" name="address" style="width:100px;" placeholder="우편번호">    
									<input class="primary" type="button" id="btn" onClick="searchPostCode()" value="주소검색"></td>
								<tr>
									<td colspan="2"><input type="text" id="roadAddress" name="address" value="${mem.address}" style="width:320px;" placeholder="주소" /><br></td>
								</tr>
								<tr>
									<td colspan="2"><input type="text" id="detailAddress" name="address" style="width:320px;"  placeholder="상세 주소" /><br></td>	
															
								</tr>
								<tr>
									<td>EMAIL</td>
									<td><input type="email" name="email" id="email" value="${mem.email}"  required="required"><input type="button"  onclick= "checkEmail()" value="이메일확인">
										<span class="email_ok">사용 가능한 이메일입니다.</span>
										<span class="email_already">이미 등록된 이메일입니다.</span>
									</td>
								</tr>
								<tr>
									<td>ROLE</td>
									<td>
										<input type="radio" name="role" value="USER" checked="checked">회원
									</td>
								</tr>
								<tr >
									<td colspan="2"><input type="submit" value="회원정보변경"></td>
								</tr>
							</table>
					
						</form>
						</div>
						<div class="site-section">
						<div class="container">
							<div class="row align-items-center justify-content-center">
								<a href="index.jsp">메인바로가기</a>
							</div>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<form action="deleteMember.do" class="joinTable" method="post"
						style="text-align: left">
						<input type="hidden" name="mid" value="${mem.mid}"> <input
							type="hidden" name="mpw" value="${mem.mpw}"> <input
							type="submit" value="회원탈퇴">
					</form>
				</div>
			</div>
		</div>


		<!-- footer 태그  -->
	<mytag:footer/>
    </div>
    
	<!-- js리스트 태그 -->
	<script src="withPPjs/upload.js"></script>
	<mytag:js/>
	<!-- js추가  -->
	<script src="withPPjs/mypage.js"></script>

  </body>

</html>
