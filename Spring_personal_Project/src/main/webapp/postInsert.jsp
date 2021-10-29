<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">

<head>
<title>withPP - Write</title>
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
	</div>
		<!-- 메뉴/로그인/로그아웃/마이페이지 버튼 태그 -->
		<mytag:header />

		<div class="ftco-blocks-cover-1">
			<div class="ftco-cover-1"
				style="background-image: url('images/hero_1.jpg');">
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
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center ">
						<div class="row align-items-center justify-content-center">
						<form action="insertPost.do" class="joinTable" method="post" style="text-align: left" enctype="multipart/form-data"> 
							<table> 
								<tr>
									<td>제목</td>
									<td><input type="text" name="title" required="required"></td>
								</tr>
								<tr>
									<td>아이디</td>
									<td><input type="text" name="mid" value="${mem.mid}" required="required"></td>
								</tr>
								<tr>
									<td>닉네임</td>
									<td><input type="text" name="nickname" value="${mem.nickname}" required="required"></td>
								</tr>
								<tr>
									<td>썸네일</td>
								 <td><input type="file" name="fileUpLoad"></td>
									<!-- <td><input type="text" name="thumnail" value="images\\thumnail.png"></td> -->
								</tr>
								<tr>
									<td>내용</td>
									<td><input type="text" name="content" required="required"></td>
								</tr>
								<tr>
									<td>지역</td>
									<td><input type="text" name="location" required="required"></td>
								</tr>
								<tr>
									<td>주소</td>
									<td><input type="text" name="locaddress" required="required"></td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="text" name="loccall" required="required"></td>
								</tr>		
								<tr>
									<td colspan="2"><input type="submit" value="글작성"></td>
								</tr>
							</table>
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
	<!-- js추가  -->
	<script src="js/contact.js"></script>
</body>
</html>

