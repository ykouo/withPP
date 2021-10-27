<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!doctype html>
<html lang="en">

  <head>
    <title>Error</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="css/aos.css">

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="css/style.css">
	<style type="text/css">
	.errorImage{
		margin-top: 50px;
		width:260px;
		height:260px;
	}
	
	
	</style>
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


<!--  메뉴바  -->
      <header class="site-navbar site-navbar-target" role="banner">
        <div class="container">
        
          </div>
        </div>
      </header>
<!--  /메뉴바  -->

	<!-- <메인 이미지> -->
	<div class="ftco-blocks-cover-10" style="height: 300px; margin-top:100px;">
		<div class="ftco-cover-1">
			<!-- style="background-image: url('images/hero_1.jpg');" -->
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-lg-6 text-center">
						<h1>오류 발생</h1>
						<hr>
						<h3>요청 처리 실패 :(</h3>
						<hr>
						예외유형   : ${pageContext.errorData.throwable}<br> 
						상태코드   : ${pageContext.errorData.statusCode}<br> 
						실패 URl : ${pageContext.errorData.requestURI}<br>
						<a href="index.jsp">메인바로가기</a>
					</div>
					
					<img class="errorImage" src="images/sorry.png" alt="404에러이미지">
					
				</div>
			</div>
		</div>
	</div>
	<!-- </메인 이미지>  -->




	<footer class="site-footer">
      <div class="container">
        <div class="row">


          </div>
        </div>

    </footer> 


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









