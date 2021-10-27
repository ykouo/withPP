<!--  회원가입 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<form action="joinMember.do" class="joinTable" method="post" style="text-align: left">
							<table>
								<tr>
									<td>아이디</td>
									<td><input type="text" name="mid" required="required"></td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td><input type="password" name="mpw" required="required"></td>
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td><input type="password" name="mpw" required="required"></td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" name="mname" required="required"></td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="tel" name="call" required="required"></td>
								</tr>
								<tr>
									<td>생일</td>
									<td><input type="birth" name="birth" required="required"></td>
								</tr>
								<tr>
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

  </body>

</html>
