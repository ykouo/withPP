<!--  회원가입 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">

  <head>
    <title>SignIn - withPP </title>
    <!--  파비콘 추가  -->
    <mytag:Fabicon/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- 주소검색  -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- styleLink모음 태그 -->
	<mytag:styleLink/>    
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
                  <h1><span class="text-primary">Contact</span> </h1>
                  <p>Welcome 000 page</p>
                  
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
								<tr>
									<td class="category">미리보기</td>
								 	<td><img src="images/thumnail.png" class="thumb" style="width:150px;height:150px;"/></td>	
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
									<td colspan="4"><input type="text" name="mid" required="required"></td>
								</tr>
								<tr>
									<td>PASSWORD</td>
									<td colspan="4"><input type="password" name="mpw" required="required" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$">
									</td>
								</tr>
								<tr>
									<td>PASSWORD CHECK</td>
									<td colspan="4"><input type="password"  required="required" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"></td>
								</tr>
								<tr>
									<td>NICKNAME</td>
									<td><input type="text" name="nickname" required="required"></td>
								</tr>
								<tr>
									<td>PHONE</td>
									<td colspan="4"><input type="tel" onkeyup="" id="phoneNum"class="textbox" name="phone" required="required" maxlength="13" style="width:100%; resize:none;"></td>
								</tr>
								<tr>
									<td>BIRTH</td>
									<td colspan="4"><input type="date" name="birth" required="required"></td>
								</tr>
								<tr>
									<td>ADDRESS</td>
									<td><input id="postcode" type="text" name="address" style="width:100px;" placeholder="우편번호">    
									<input class="primary" type="button" id="btn" onClick="searchPostCode()" value="주소검색"></td>
								<tr>
									<td colspan="2"><input type="text" id="roadAddress" name="address" style="width:320px;" readonly placeholder="주소" /><br></td>
								</tr>
								<tr>
									<td colspan="2"><input type="text" id="detailAddress" name="address" style="width:320px;"  placeholder="상세 주소" /><br></td>	
								</tr>
								<tr>
									<td>EMAIL</td>
									<td><input type="email" name="email" required="required"></td>
								</tr>
								<tr>
									<td>ROLE</td>
									<td>
										<input type="radio" name="role" value="USER" checked="checked">회원
									</td>
								</tr>
								<tr >
									<td colspan="2"><input type="submit" value="회원가입"></td>
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
	<script src="withPPjs/login.js"></script>

  </body>

</html>
