<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>    
<!doctype html>
<html lang="en">

  <head>
    <title>withPP - Contact</title>
    <!--  파비콘 추가  -->
    <mytag:Fabicon/>
 	<!-- 구글맵 API 추가 -->
	<script src="http://maps.google.com/maps/api/js?key=구글맵API등록&region=kr"></script>
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
    
    
    <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1" style="background-image: url('images/dog5.jpg');">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                </div>
              </div>
            </div>
        </div>
      </div>

		<!-- 구글 맵 추가 -->
		<div class="site-section">
			<div class="container" style="margin-top: -50px; margin-bottom: -150px;">
				<h1>Contact <span class="text-primary">withPP</span> Now!</h1>
					
				<div class="row" style="justify-content: center;">
				
					<div id="map" style="width:100%; height:300px;"></div>
				</div>
			</div>
		</div>
		

	<div class="site-section">
      <div class="container">     
        <div class="row">
          <div class="col-lg-8 mb-5" >
            <h2>Q&A Send</h2>
            <form action="mail.do" method="post">
	          <input type="hidden" name="to" value="anykouo@gmail.com"/>
              <div class="form-group row">
                <div class="col-md-6 mb-4 mb-lg-0">
                  <input type="text" name="from" class="form-control" placeholder="답변받을 이메일주소"  onsubmit="emailCheck();">
                </div>
              </div>
              <c:if test="${empty mem}">
               <div class="form-group row">
                <div class="col-md-12">
                  <input type="text" name="subject" class="form-control" value="[Guest]님의 문의메일입니다." readonly="readonly">
                </div>
              </div>
              </c:if>
              <c:if test="${! empty mem}">
              <div class="form-group row">
                <div class="col-md-12">
                  <input type="text" name="subject" class="form-control" value="[${mem.mid}]님의 문의메일입니다." readonly="readonly">
                </div>
              </div>
              </c:if>

              <div class="form-group row">
                <div class="col-md-12">
                  <textarea name="content"  id="write" class="form-control" placeholder="문의내용을 작성하세요" cols="30" rows="10" maxlength="500" style="resize: none;"></textarea>
                </div>
              </div>
              <div class="form-group row">
                <div class="col-md-6 mr-auto">
                  <input type="submit" class="btn btn-block btn-primary text-white py-3 px-5" value="Send Message">
                </div>
              </div>
            </form>
          </div>
      
          <div class="col-lg-4 ml-auto">
            <div class="bg-white p-3 p-md-5">
              <h3 class="text-black mb-4">Contact Info</h3>
              <ul class="list-unstyled footer-link">
                <li class="d-block mb-3">
                  <span class="d-block text-black">Address:</span>
                  <span>서울특별시 강남구 테헤란로 146 현익빌딩 3층, 4층 (신한은행건물)</span></li>
                <li class="d-block mb-3"><span class="d-block text-black">Phone:</span><span>010-with-with</span></li>
                <li class="d-block mb-3"><span class="d-block text-black">Email:</span><span>withPP@withPP.com</span></li>
              </ul>
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
    <!-- js추가  -->
    <script src="js/contact.js"></script>
	<script src="withPPjs/resize.js"></script>
	<script src="withPPjs/emailCheck.js"></script>
  </body>
</html>