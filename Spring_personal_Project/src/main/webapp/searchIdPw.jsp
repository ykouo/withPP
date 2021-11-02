<!--  게시글 상세 보기 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">
<head>
<title>withPP - withPetDetail</title>
<!--  파비콘 추가  -->
<mytag:Fabicon />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- styleLink모음 태그 -->
<mytag:styleLink />
</head>
<script type="text/javascript">

	function loginCheck() {

		var param = "mid" + "=" + $("#mid").val();

		//   alert(param);
		$.ajax({
			url : "/tempPw.do",
			type : "GET",
			data : param,
			cache : false,
			async : false,
			dataType : "text",

			success : function(response) {
				if (response == '1') {
					alert("임시비밀번호 메일 발송완료!")
				} else {
					alert("존재하지 않는 아이디입니다. 아이디찾기를 먼저 진행해주세요:D")
					return false;
				}

				alert(check);
			},
			error : function(request, status, error) {
				if (request.status != '0') {
					alert("code : " + request.status + "\r\nmessage : "
							+ request.reponseText + "\r\nerror : " + error);
				}
			}

		});
	}
</script>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">


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
			<div class="ftco-cover-1 overlay"
				style="background-image: url('${data.thumnail}')">
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
					<div class="col-md-4 sidebar">
					<div class="col-md-8 blog-content">
						<div class="sidebar-box">
							<h3>아이디찾기</h3>
							<form action="searchID.do" method="post">
									<div class="col-md-6 mb-4 mb-lg-0 ">								
										<input type="text" id="idCheck" class="searchIDPW"
											placeholder="가입시 입력한 이메일 입력" name="email" required="required" style="width:300px;height:50px;"> 
										<br> <input type="submit"
											class="searchIDPW"
											value="아이디발송">
									</div>
								
							</form>
							<!-- END comment-list -->

						</div>
					</div>
				</div>
					<div class="col-md-4 sidebar">
					<div class="col-md-8 blog-content">
						<div class="sidebar-box ">
							<h3>비밀번호찾기</h3>
							<form action="tempPw.do" method="post">
									<div class="col-md-6 mb-4 mb-lg-0">										
										<input type="text" id="idCheck" class="searchIDPW"
											placeholder="가입시 입력한 이메일 입력" name="email" required="required" style="width:300px;height:50px;"> <br>
										<input type="text" id="idCheck" class="searchIDPW"
											placeholder="ID 입력" name="mid" id="mid" required="required" style="width:300px;height:50px;">
										<br> <input type="submit"
											class="searchIDPW"
											value="임시비밀번호전송">
									</div>								
							</form>
							<!-- END comment-list -->

						</div>
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