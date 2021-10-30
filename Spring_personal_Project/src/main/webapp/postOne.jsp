<!--  게시글 상세 보기 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <title>withPP - withPetDetail</title>
    <!--  파비콘 추가  -->
    <mytag:Fabicon/>
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
      <div class="ftco-cover-1 overlay" style="background-image: url('${data.thumnail}')">
        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-lg-6 text-center">
             <form action="goEditPost.do" method="post" > 
				<input type="hidden" name="pnum" value="${data.pnum}">
				<input type="hidden" name="mid" value="${data.mid}">
				<input type="hidden" name="nickname" value="${data.nickname}">
				<input type="hidden" name="title" value="${data.title}">
				<input type="hidden" name="thumnail" value="${data.thumnail}">
				<input type="hidden" name="content" value="${data.content}">
				<input type="hidden" name="locaddress" value="${data.locaddress}">
				<input type="hidden" name="loccall" value="${data.loccall}">
				<input type="hidden" name="location" value="${data.location}">
				<input type="hidden" name="cnt" value="${data.cnt}">
				<input type="hidden" name="heart" value="${data.heart}">
				<input type="hidden" name="wdate" value="${data.wdate}">
            	 <span class="d-block mb-3 text-white" data-aos="fade-up">            	
            	 	 <c:if test ="${data.heart eq 'N'}">
            	 		<a href="updateHeart.do?pnum=${data.pnum}&heart=Y">🤍</a>
            	 	</c:if>
            	 	<c:if test ="${data.heart eq 'Y'}">
            	 		<a href="updateHeart.do?pnum=${data.pnum}&heart=N">🖤</a>
            		</c:if>
            	 </span>
            	  <span class="d-block mb-3 text-white" data-aos="fade-up">${data.wdate} 
            	  <span class="mx-2 text-primary">&bullet;</span> by ${data.mid} <span class="mx-2 text-primary">&bullet;</span> 조회수 [${data.cnt}]</span>
            	  
                	<h1 class="mb-4" data-aos="fade-up" data-aos-delay="100">[${data.location}]${data.title}</h1>
           		<c:if test="${mem.mid eq data.mid}">
           		<input type="submit" value="수정하기">
           	 	</c:if>
           	 </form>
           	 <c:if test="${mem.mid eq data.mid}">
           	  <form action="deletePost.do" method="post" > 
           	 	<input type="hidden" name="pnum" value="${data.pnum}">
           	 	<input type="submit" value="삭제하기">
           	 </form>
           	 </c:if>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-8 blog-content">
            <p class="lead">${data.content}</p>
            <blockquote><p>${data.loccall}</p></blockquote>

            <blockquote><p>${data.locaddress}</p></blockquote>

            <div class="pt-5">
              <p>Categories:${data.location} <a href="#">Design</a>, <a href="#">Events</a>  Tags: <a href="#">#html</a>, <a href="#">#trends</a></p>
            </div>

            <div class="pt-5">
              <h3 class="mb-5"><%-- ${commCnt} --%>Comments</h3>
               <ul class="comment-list">
                <c:forEach var="comm" items="${commData}">
                <li class="comment">
                  <div class="vcard bio">
                    <img src="${comm.profileimage}" alt="Free Website Template by Free-Template.co">
                  </div>
                  <div class="comment-body">
                    <h3>${comm.nickname}</h3>
                    <div class="meta">${comm.cdate}</div>
                    <p>${comm.comm}</p>
                    <p><a href="#" class="reply">like</a></p>
                  </div>
                </li>
                </c:forEach>
                
                <li>
                <c:if test="${empty mem}">
                	<div class="comment-body">
                    <textarea disabled="disabled" readonly="readonly" style="resize: none; width:300px;">로그인후 이용가능합니다:D</textarea>
                    <div class="meta"></div>
                  </div>
                	
                </c:if>
                <c:if test="${!empty mem}">
                <form action="insertComm.do" method="post">
                  <div class="vcard bio">
                    <img src="${mem.profileimage}" alt="Free Website Template by Free-Template.co">
                  </div>
                  <div class="comment-body">
                    <h3>${mem.nickname}</h3>
                    <div class="meta"></div>
                    <input type="hidden" name="pnum" value="${data.pnum}">
                    <input type="hidden" name="mid" value="${mem.mid}">
                    <input type="hidden" name="nickname" value="${mem.nickname}">
                    <input type="hidden" name="profileimage" value="${mem.profileimage}">
                    <input type="text" name="comm" style="resize: none;">                
                    <input type="submit" class="reply" value="등록">
                  </div>
                </form>
                </c:if>
                </li>
                
              </ul> 
              <!-- END comment-list -->
              
              
              
              
              
              
              
              
              <div class="comment-form-wrap pt-5">
                <h3 class="mb-5">Leave a comment</h3>
                <form action="#" class="">
                  <div class="form-group">
                    <label for="name">Nickname</label>
                    <input type="text" class="form-control" id="name" name="nickname">
                  </div>
                  <div class="form-group">
                    <label for="website">Website</label>
                    <input type="url" class="form-control" id="website">
                  </div>

                  <div class="form-group">
                    <label for="message">Message</label>
                    <textarea name="" id="message" cols="30" rows="10" class="form-control"></textarea>
                  </div>
                  <div class="form-group">
                    <input type="submit" value="Post Comment" class="btn btn-primary btn-md text-white">
                  </div>

                </form>
              </div>
            </div>

          </div>
          <div class="col-md-4 sidebar">
            <div class="sidebar-box">
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="icon fa fa-search"></span>
                  <input type="text" class="form-control" placeholder="Type a keyword and hit enter">
                </div>
              </form>
            </div>
            <div class="sidebar-box">
              <div class="categories">
                <h3>Categories</h3>
                <li><a href="#">Creatives <span>(12)</span></a></li>
                <li><a href="#">News <span>(22)</span></a></li>
                <li><a href="#">Design <span>(37)</span></a></li>
                <li><a href="#">HTML <span>(42)</span></a></li>
                <li><a href="#">Web Development <span>(14)</span></a></li>
              </div>
            </div>
            <div class="sidebar-box">
              <img src="images/person_1.jpg" alt="Free Website Template by Free-Template.co" class="img-fluid mb-4 w-50 rounded-circle">
              <h3 class="text-black">About The Author</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
              <p><a href="#" class="btn btn-primary btn-md text-white">Read More</a></p>
            </div>

            <div class="sidebar-box">
              <h3 class="text-black">Paragraph</h3>
              <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
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
  </body>

</html>























<%-- 
<!doctype html>
<html lang="en">
  <head>
    <title>withPP - withPetDetail</title>
 	<mytag:Fabicon/>
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
   <header class="site-navbar site-navbar-target" role="banner">
	<!-- 로그인 버튼 -->
	<c:if test="${empty mem}">
		<div class = "login-div" align="right"> <!-- 로그인버튼 오른쪽 배치  -->
			<a href="login.jsp" class="login nav-link">login</a> <!-- class="nav-link" -->
        </div>
    </c:if>
    <c:if test="${! empty mem}">
    	<div class = "login-div" align="right"> <!-- 로그인버튼 오른쪽 배치  -->
			<span>${mem}님
			<a href="logout.do" class="login nav-link" style="display:inline-block;">mypage</a>
			<a href="logout.do" class="login nav-link" style="display:inline-block;">logout</a></span> <!-- class="nav-link" -->
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
                  <li><a href="AboutwithPP.jsp" class="nav-link">About</a></li>
                  <li><a href="services.html" class="nav-link">Services</a></li>
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
                  <li><a href="about.html" class="nav-link">what</a></li>
                  <li><a href="showBoardList.do" class="nav-link">Blog</a></li>
                  <li><a href="contact.jsp" class="nav-link">Contact</a></li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
	<!-- /메뉴바   -->  
      </header>

    
    
    <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1" style="background-image: url('images/hero_1.jpg');">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                  <h1>${data.title}</h1>
                  <p>작성자 : ${data.mid} | 작성일 : ${data.wdate} </p>
                </div>
              </div>
            </div>
        </div>
      </div>

      <div class="site-section "> 
      <div class="container site-section">
        <div class="row align-items-stretch feature-2">
          <div class="col-lg-9 feature-2-img">
            <img src="images/img_3.jpg" alt="Image" class="img-fluid">
          </div>
          <div class="col-lg-3 feature-2-contents pl-lg-5">
            <div class="fixed-content">
              <span class="caption">${data.bid}</span>
              <h2 class="heading-39291">${data.title}</h2>
              <p>${data.content}</p>
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
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>

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
                  <input type="text" class="form-control border-secondary text-white bg-transparent" placeholder="Enter Email" aria-label="Enter Email" aria-describedby="button-addon2">
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
</html> --%>