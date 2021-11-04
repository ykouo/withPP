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
<!-- 주소검색  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- styleLink모음 태그 -->
<mytag:styleLink />
<script type="text/javascript">
</script>
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
							<h1>EDIT</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<div class="row" style="justify-content: center;">
					<div class="col-lg-8 mb-5">
						<form action="updatePost.do" id="postWrite" method="post" enctype="multipart/form-data">
							<input type="hidden" name="pnum" value="${data.pnum}">
							<input type="hidden" name="mid" value="${data.mid}">
							<input type="hidden" name="thumnail" value="${data.thumnail}">							
							<c:if test="${!empty mem}">
								<input type="hidden" name="mid" value="${mem.mid}">
								<input type="hidden" name="nickname" value="${mem.nickname}">
							</c:if>
							<c:if test="${!empty kakaoVO }">
								<input type="hidden" name="mid" value="${kakaoVO.mid}">
								<input type="hidden" name="nickname" value="${kakaoVO.nickname}">
							</c:if>
							<c:if test="${!empty naverVO }">
								<input type="hidden" name="mid" value="${naverVO.mid}">
								<input type="hidden" name="nickname" value="${naverVO.nickname}">
							</c:if>
							<table> 
								<tr>
									<td class="category">PREVIEW</td>
								 	<td colspan="2"><img src="${data.thumnail}" class="thumb" style="width:150px;height:150px;"/></td>	
   								 </tr>
   								 <tr>	
   								 	<td class="category">THUMNAIL</td>
									<td colspan="2"><input type="file" class="hidden_input" id="imageSelector" name="fileUpLoad" accept="image/jpeg, image/jpg, image/png" multiple  style="resize:none;" />
									</td>
								</tr>
								<tr>
									<td class="category">TITLE</td>
									<td colspan="2"><input id="title" type="text" class="textbox" name="title" value="${data.title}" required="required"  style="resize:none;"></td>
								</tr>
								<tr>
									<td class="category">CONTENT</td>
									<td colspan="2"><textarea id="content"name="content" class="textbox" id="write"onkeyup="resize(this)" onkeydown="resize(this)"  style="resize:none;">${data.content}</textarea></td>
								</tr>
								<tr>
									<td class="category">LOCATION</td>
									<td colspan="2">
										<select class="textbox" id="location" name="location" required="required" style="width:100%; resize:none;" style="resize:none;">
											<option value="서울">서울</option>
											<option value="경기도">경기도</option>
											<option value="인천">인천</option>
											<option value="세종">세종</option>
											<option value="충남">충남</option>
											<option value="충북">충북</option>
											<option value="부산">부산</option>
											<option value="대구">대구</option>
											<option value="광주">광주</option>
											<option value="강원도">강원도</option>
											<option value="전남">전남</option>
											<option value="전북">전북</option>
											<option value="경남">경남</option>
											<option value="경북">경북</option>
											<option value="제주">제주</option>				
										</select>
									</td>
								</tr>
								<tr>
									<td>POST CODE</td>
									<td><input id="postcode" type="text" name="postcode" value="${data.postcode}"  placeholder="우편번호">    
									<input class="primary" type="button" id="btn" onClick="searchPostCode()" value="주소검색"></td>
								<tr>
									<td>ADDRESS</td>
									<td><input type="text" id="roadAddress" name="roadaddress" value="${data.roadaddress}"/><br></td>
								</tr>
								<tr>
									<td>DETAIL ADDRESS</td>
									<td><input type="text" id="detailAddress" name="detailaddress" value="${data.detailaddress}" placeholder="상세 주소" /><br></td>	
								</tr>
								<tr>
									<td class="category">CALL</td>
									<td colspan="2"><input type="tel" id="phoneNum" class="textbox" name="phone" value="${data.phone}"  required="required" maxlength="15" style="resize:none;"></td>
								</tr>		
								<tr>
									<td colspan="3" align="center"><input type="submit" class="submitBtn" value="수정"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>

<!-- footer 태그  -->
	<mytag:footer />
	</div>
	<script src="withPPjs/upload.js"></script>
	<!-- js리스트 태그 -->
	<mytag:js />
	<!-- js추가  -->
	<script src="withPPjs/searchPost.js"></script>
	<script src="withPPjs/beforeunload.js"></script>
	<script src="withPPjs/autoHypen.js"></script>

</body>
</html>
