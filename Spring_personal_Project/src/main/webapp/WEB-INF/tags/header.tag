<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 
      <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
          </div>
        </div>
        <div class="site-mobile-menu-body"></div>
      </div>
	
	<!--  메뉴바  -->
 	 <header class="site-navbar site-navbar-target" role="banner">
	<!-- 로그인 버튼 -->
	<c:if test="${empty mem && empty kakaoVO && empty naverVO}">
		<div class = "login-div" align="right"> <!-- 로그인버튼 오른쪽 배치  -->
			<a href="login.jsp" class="login nav-link">login</a> <!-- class="nav-link" -->
        </div>
    </c:if>
    <!-- 로그인 완료시 mypage, 로그아웃 버튼 생성  -->
    <c:if test="${!empty mem}">
    	<form name="mypage" action="goMypage.do" method="post">
				<input type="hidden" name="mid" value="${mem.mid}">
				<input type="hidden" name="mpw" value="${mem.mpw}">
		</form> 
    	<div class = "login-div" align="right"> <!-- 로그인버튼 오른쪽 배치  -->
			<span class="nickname">[${mem.nickname}]님
			<a href="#" onclick="javascript:document.mypage.submit();" class="login nav-link" style="display:inline-block;">Mypage</a>
			<a href="logout.do" class="login nav-link" style="display:inline-block;">logout</a></span> <!-- class="nav-link" -->
        </div> 
    </c:if>
    <!-- 카카오 로그인 -->
     <c:if test="${!empty kakaoVO}">
         <div class = "login-div" align="right"> <!-- 로그인버튼 오른쪽 배치  -->
			<span class="nickname">[${kakaoVO.mid}]님
			<a href="kakaoLogout.do" class="login nav-link" style="display:inline-block;">logout</a></span> <!-- class="nav-link" -->
        </div>    
     </c:if>
    <!-- 네이버 로그인 -->
     <c:if test="${!empty naverVO}">
         <div class = "login-div" align="right"> <!-- 로그인버튼 오른쪽 배치  -->
			<span class="nickname">[${naverVO.mid}]님
			<a href="naverLogout.do" class="login nav-link" style="display:inline-block;">logout</a></span> <!-- class="nav-link" -->
        </div>    
     </c:if>    
    <!-- /로그인 버튼 -->  
        <div class="container">
          <div class="row align-items-center position-relative">
	<!-- 메뉴바   -->
            <div class="col-lg-4">
              <nav class="site-navigation text-right ml-auto " role="navigation">
                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li class="active"><a href="index.jsp" class="nav-link">Home</a></li>
                  <li><a href="aboutwithPP.jsp" class="nav-link">About</a></li>
                </ul>
              </nav>
            </div>
      
     <!-- 메인 로고   -->     
            <div class="col-lg-4 text-center">
              <div class="site-logo">
                <a href="index.jsp">with<b>PP</b></a>
              </div>
	 <!-- /메인 로고   --> 
              <div class="ml-auto toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-white"><span class="icon-menu h3 text-white"></span></a></div>
            </div>
            <div class="col-lg-4">
              <nav class="site-navigation text-left mr-auto " role="navigation">
                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li><a href="contact.jsp" class="nav-link">Contact</a></li>
                  <li><a href="showPostList.do" class="nav-link">ForCafe</a></li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </header>
	<!--  /메뉴바  -->
	
	