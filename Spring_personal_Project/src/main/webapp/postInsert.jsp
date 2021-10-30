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
						<form action="insertPost.do" class="postTable" method="post" style="text-align: left" enctype="multipart/form-data"> 
							<input type="hidden" name="mid" value="${mem.mid}">
							<input type="hidden" name="nickname" value="${mem.nickname}">
							<table> 
								<tr>
									<td class="category">미리보기</td>
								 	<td><img src="images/thumnail.png" class="thumb" style="width:150px;height:150px;"/></td>	
   								 	<td><a  href="javascript:void(0);" class="dellink btn">삭제</a></td>
   								 </tr>
   								 <tr>	
   								 	<td class="category">썸네일</td>
									<td colspan="2"><input type="file" class="hidden_input"" id="imageSelector"
										name="fileUpLoad" accept="image/jpeg, image/jpg, image/png"
										multiple/>
									</td>
								</tr>
								<tr>
									<td class="category">제목</td>
									<td colspan="2"><input type="text" class="textbox" name="title" required="required"></td>
								</tr>
								<tr>
									<td class="category">아이디</td>
									<td colspan="2"><input type="text" class="textbox" name="mid" value="${mem.mid}" required="required" disabled="disabled"></td>
								</tr>
								<tr>
									<td class="category">닉네임</td>
									<td colspan="2"><input type="text" class="textbox" name="nickname" value="${mem.nickname}" required="required" disabled="disabled"></td>
								</tr>

								<tr>
									<td class="category">내용</td>
									<td colspan="2"><input type="text" class="textbox" name="content" required="required"></td>
								</tr>
								<tr>
									<td class="category">지역</td>
									<td colspan="2"><input type="text" class="textbox" name="location" required="required"></td>
								</tr>
								<tr>
									<td class="category">주소</td>
									<td colspan="2"><input type="text"class="textbox" name="locaddress" required="required"></td>
								</tr>
								<tr>
									<td class="category">전화번호</td>
									<td colspan="2"><input type="text" class="textbox"name="loccall" required="required"></td>
								</tr>		
								<tr>
									<td colspan="3" align="center"><input type="submit" class="submitBtn" value="글작성"></td>
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
	<script src="withPPjs/upload.js"></script>
</body>
</html>

