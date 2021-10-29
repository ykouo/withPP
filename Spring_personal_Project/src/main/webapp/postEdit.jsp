<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">

<head>
<title>withPP - Edit</title>
<!--  파비콘 추가  -->
<mytag:Fabicon />
<!-- 구글맵 API 추가 -->
<script src="http://maps.google.com/maps/api/js?key=구글맵API등록&region=kr"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- styleLink모음 태그 -->
<mytag:styleLink />
</head>

<body data-spy="scroll" data-target=".site-navbar-target"data-offset="300">
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
			<div class="ftco-cover-1"
				style="background-image: url('${data.thumnail}');">
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-lg-6 text-center">
							<h1>WritePage</h1>
							<span>작성자 아이디 : ${mem.mid}</span><span>작성자 닉네임 : ${mem.nickname}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<div class="row" style="justify-content: center;">
					<div class="col-lg-8 mb-5">
						<form action="updatePost.do" method="post" enctype="multipart/form-data">
							<input type="hidden" name="pnum" value=${data.pnum}>
							<input type="hidden" name="mid" value="${mem.mid}">
							<input type="hidden" name="nickname" value="${mem.nickname}">
							<div class="form-group row">
								<div class="col-md-6 mb-4 mb-lg-0">
									<input type="text" class="form-control" name="title" value="${data.title}" > 
									<%-- <input type="hidden" name="thumnail" value="${data.thumnail}"> --%>
									<input type="file" name="fileUpLoad">
									<input type="text" class="form-control" name="location" value="${data.location}" >
									<input type="text" class="form-control" name="locaddress" value="${data.locaddress}" >
									<input type="text" class="form-control" name="loccall" value="${data.loccall}">
									<textarea name="content" class="form-control" cols="30" rows="10" style="resize: none;">${data.content }</textarea>
								</div>
							</div>
							<div class="col-md-6 mr-auto">
								<input type="submit" class="btn btn-block btn-primary text-white py-3 px-5"value="수정">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

<!-- footer 태그  -->
	<mytag:footer />
	</div>
	<!-- js리스트 태그 -->
	<mytag:js />
	<!-- js추가  -->
	<script src="js/contact.js"></script>
</body>
</html>
