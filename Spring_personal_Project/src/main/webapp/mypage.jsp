<!--  회원가입 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<!-- 메뉴/로그인/로그아웃/마이페이지 버튼 태그 -->
	<mytag:header/>
	<!-- <메인 이미지> -->  
	<div class="site-section">
    <div class="ftco-blocks-cover-10" style="height:300px;">
        <div class="ftco-cover-1">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                  <h1><span class="text-primary">MYPAGE</span> </h1>
                 	<div class="row align-items-center justify-content-center">
						<a href="updateMember.jsp">회원정보변경</a>
					</div>
					<div class="row align-items-center justify-content-center">
						<a href="showFavoriteList.do?mid=${mem.mid}">관심글 보기</a>
					</div>
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
	  </div>
	 </div>
	</div>

	<!-- footer 태그  -->
	<mytag:footer/>
	<!-- js리스트 태그 -->
	<script src="withPPjs/upload.js"></script>
	<mytag:js/>
	<!-- js추가  -->
	<script src="withPPjs/idCheck.js"></script>
	<script src="withPPjs/autoHypen.js"></script>
	<script src="withPPjs/passwordCheck.js"></script>
	<script src="withPPjs/emailCheck.js"></script>
	<script src="withPPjs/emailDupliCheck.js"></script>
  </body>
</html>


