<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">

<head>
<title>withPP - LOGIN</title>
<script src="developers.kakao.com/sdk/js/kakao/min/js" charset="utf-8" />
<script type="text/javascript">
   ${document}.ready(function(){
	   kakao.init('자바스크립트 앱키 입력');
	   kakao.isInitialized();
   });
   </script>
<script type="text/javascript">
  	function loginWithKakao(){
  		Kakao.Auth.authorize({
  			redirectUri = 'http://localhost:8088/login_kakao.do';
  		});
  	} 
  </script>
<!--  파비콘 추가  -->
<mytag:Fabicon />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- styleLink모음 태그 -->
<mytag:styleLink />
</head>

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
			<div class="ftco-cover-1 "
				style="background-image: url('images/dog4.png'); >
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-lg-6 text-center"></div>
					</div>
				</div>
			</div>
		</div>

<script type="text/javascript">
Kakao.init('카카오 developer javascript api key'); // javascript api키를 입력
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() { // 카카오로그인 메서드 
    Kakao.Auth.login({	
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
        	
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>

		<div class="site-section">
			<div class="container">
				<div class="row" style="justify-content: center;">
					<!--  style="
				justify-content: center" :가운데정렬  -->
				<div class="col-lg-8 mb-5">
					<form action="login.do" method="post">
						<input type="hidden" name="nickname"> <input type="hidden"
							name="phone"> <input type="hidden" name="address">
						<input type="hidden" name="birth"> <input type="hidden"
							name="email"> <input type="hidden" name="role"> <input
							type="hidden" name="mdate"> <input type="hidden"
							name="accesstoken">
						<div class="form-group row" style="justify-content: center;">
							<div class="col-md-6 mb-4 mb-lg-0">
								<input type="text" id="idCheck" class="form-control"
									placeholder="ID" name="mid" required="required"> <br>
								<input type="password" id="pwCheck" class="form-control"
									placeholder="Password" name="mpw" required="required">
								<!-- pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" 나중에 추가 -->
								<br> <input type="submit"
									class="btn btn-block btn-primary text-white py-3 px-5 log logCheck"
									value="LOGIN"> <br>
								<p style="text-align: center;">
									<a href="javascript:kakaoLogin();"><img
										src="images/kakao_login_medium_narrow.png"></a>
								</p>
								<p style="text-align: center;">
									<b><a href="signUp.jsp">회원가입</a> / <a href="searchIdPw.jsp">ID/PW
											찾기</a></b>
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
	</div>

	<!-- js리스트 태그 -->
	<mytag:js />

</body>

</html>
