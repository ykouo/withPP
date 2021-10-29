<!--  About 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>     
<!doctype html>
<html lang="en">

  <head>
    <title>withPP - About withPP</title>
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
        <div class="ftco-cover-1" style="background-image: url('images/hero_1.jpg');">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                  <h1>About <span class="text-primary">withPP?</span>  </h1>
                  <p>with 함께 Pet 반려동물 People </p> 
                </div>
              </div>
            </div>
        </div>
      </div>
    

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-5">
            <h2 class="heading-39291">우리는 언제나 함께하는 생활을 꿈꿉니다.</h2>
            <p class="mb-5">withPP 는 언제나 함께하고 싶은 반려동물 가정을 응원합니다:D <br> 함께하고 싶지만 함께하기 어려운 현실. 작은 도움이라도 되고자 합니다</p>
            <p><a href="#" class="more-39291">More About Us</a></p>
          </div>

          <div class="col-md-4 ml-auto">
            <div class="year-experience-99301">
              <h2 class="heading-39291">Create withPP</h2>
              <span class="text">Since <span>2021/10/24 ~</span></span>
              <span class="number"><span>75</span></span>
            </div>
          </div>
        </div>
      </div>
    </div>


    <div class="site-section">
      <div class="container">
        <div class="row justify-content-center text-center mb-5 section-2-title">
          <div class="col-md-6">
            <h2 class="heading-39291">Meet Our Team</h2>
            <p>withPP의 팀원을 소개합니다:D</p>
          </div>
        </div>
        <div class="row align-items-stretch" style="justify-content: center">
          <div class="col-lg-4 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              <a href="https://blog.naver.com/ykouo">
                <img src="images/member_yk.jpg" alt="멤버:yk"class="img-fluid" style="width:260px;height:260px;">
              </a>
              <div class="post-entry-1-contents">
                <span class="meta">Developer</span>
                <h2>AnYeoKyeong</h2>
                <p>개발자  / </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    

    

    
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="row">
              <div class="col-md-7">
                <h2 class="footer-heading mb-4">About Us</h2>
                <p>withPP is with+pet+people :D </p>

              </div>
              <div class="col-md-4 ml-auto">
                <h2 class="footer-heading mb-4">Features</h2>
                <ul class="list-unstyled">
                  <li><a href="#">About Us</a></li>
                  <li><a href="#">Testimonials</a></li>
                  <li><a href="#">Terms of Service</a></li>
                  <li><a href="#">Privacy</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
              </div>

            </div>
          </div>
          <div class="col-md-4 ml-auto">

            <div class="mb-5">
              <h2 class="footer-heading mb-4">Subscribe to Newsletter</h2>
              <form action="#" method="post" class="footer-suscribe-form">
                <div class="input-group mb-3">
                  <input type="text" class="form-control border-secondary text-white bg-transparent enterEmail" placeholder="Enter Email" aria-label="Enter Email" aria-describedby="button-addon2">
                  <div class="input-group-append">
                    <button class="btn btn-primary text-white" type="button" id="button-addon2">Subscribe</button>
                  </div>
                </div>
            </div>


            <h2 class="footer-heading mb-4">Follow Us</h2>
            <a href="#about-section" class="smoothscroll pl-0 pr-3"><span class="icon-facebook"></span></a>
            <a href="#" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
            <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
            <a href="#" class="pl-3 pr-3"><span class="icon-linkedin"></span></a>
            </form>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <div class="border-top pt-5">
              <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
            </div>
          </div>

        </div>
      </div>
    </footer>

    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/jquery.fancybox.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/aos.js"></script>

    <script src="js/main.js"></script>

  </body>

</html>
