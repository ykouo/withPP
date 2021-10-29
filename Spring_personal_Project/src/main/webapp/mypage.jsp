<!--  회원가입 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<form action="updateMember.do" class="joinTable" method="post" style="text-align: left">
							<input type="hidden" name="mid" value="${mem.mid}">
							<table>
								<tr>
									<td>ID</td>
									<td><input type="text" name="mid" value="${mem.mid}" disabled="disabled"></td>
								</tr>
								<tr>
									<td>PASSWORD</td>
									<td><input type="password" name="mpw" value="${mem.mpw}" required="required"></td>
								</tr>
								<tr>
									<td>PASSWORD CHECK</td>
									<td><input type="password" value="${mem.mpw}" required="required"></td>
								</tr>
								<tr>
									<td>NICKNAME</td>
									<td><input type="text" name="nickname" value="${mem.nickname}" required="required"></td>
								</tr>
								<tr>
									<td>PHONE</td>
									<td><input type="tel" name="phone" value="${mem.phone}" required="required"></td>
								</tr>
								<tr>
									<td>BIRTH</td>
									<td><input type="date" name="birth" value="${mem.birth}" disabled="disabled" required="required"></td>
								</tr>
								<tr>
									<td>변경전 ADDRESS</td>
									<td colspan="4"><input type="text" name="address" id="address_kakao"value="${mem.address}" required="required"></td>
								</tr> 
								<tr>
									<td>ADDRESS</td>
									<td><input id="postcode" type="text" name="address" placeholder="우편번호"></td>
									<td><input class="primary" type="button" id="btn" onClick="searchPostCode()" value="주소검색"></td>	
									<td><input type="text" id="roadAddress" name="address" readonly placeholder="주소" /><br></td>
									<td><input type="text" id="detailAddress" name="address" placeholder="상세 주소" /><br></td>	
								</tr>

								<tr>
									<td>EMAIL</td>
									<td><input type="email" name="email" value="${mem.email}" required="required"></td>
								</tr>
								<tr>
									<td>ROLE</td>
									<td>
										<input type="radio" name="role" value="USER" checked="checked">회원
									</td>
								</tr>
								<tr align="center">
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
	<mytag:js/>
	<!-- js추가  -->
	<script src="withPPjs/login.js"></script>
  </body>

</html>
