<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">

<head>
<title>withPP - LOGIN</title>

<!--  파비콘 추가  -->
<mytag:Fabicon />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- styleLink모음 태그 -->
<mytag:styleLink />
</head>
<script src="developers.kakao.com/sdk/js/kakao/min/js" charset="utf-8"></script>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

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
		<mytag:header />

		<div class="ftco-blocks-cover-1">
			<div class="ftco-cover-1 "style="background-image: url('images/dog4.png');" >
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-lg-6 text-center"></div>
					</div>
				</div>
			</div>
		</div>


		<div class="site-section">
			<div class="container">
				<div class="row justify-content-center">
				<div class="col-lg-8 mb-5">
					<form action="login.do" method="post">
						<input type="hidden" name="nickname"> <input type="hidden" name="phone"> <input type="hidden" name="address">
						<input type="hidden" name="birth"> <input type="hidden" name="email"> <input type="hidden" name="role"> 
						<input type="hidden" name="mdate"> <input type="hidden" name="accesstoken">
						<div class="form-group row justify-content-center">
							<div class="col-md-6 mb-4 mb-lg-0">
								<input type="text" id="idCheck" class="form-control" placeholder="ID" name="mid"> <br>
								<input type="password" id="pwCheck" class="form-control" placeholder="Password"  name="mpw">
								<br> 
								<input type="submit" id="logCheck" class="btn btn-block btn-primary text-white py-3 px-5 log logCheck" value="LOGIN"> <br>
								<p style="text-align: center;">
									<span><a href="kakaoLogin.do"><img src="images/kakao_login_medium.png"></a></span>
									<span><a href="naverLogin.do"><img src="images/naver_login_medium.png" class="naverLoginBtn" style="width:110px; height:45px;"></a></span>
								</p>
								<p style="text-align: center;">
									<b><a href="signUp.jsp">회원가입</a> / <a href="searchIdPw.jsp">ID/PW찾기</a></b>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		</div>
	</div>

	<!-- footer 태그  -->
	<mytag:footer />
	

	<!-- js리스트 태그 -->
	<mytag:js />
	<!-- js추가  -->
	<script src="withPPjs/login.js"></script>
	

</body>

</html>
