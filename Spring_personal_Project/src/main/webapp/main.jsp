<!-- Main페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">

  <head>
    <title>withPP - with Pet&People</title>
    <!-- 파비콘 커스텀 태그 -->
  	<mytag:Fabicon/>
  	<!-- <link rel="shortcut icon" href="images/withppFabicon.ico"> -->
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
    
    <div class="owl-carousel owl-1">
      <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1" style="background-image: url('images/main1.jpg');">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center" style="margin-top: 150px;"> <!-- style="margin-top:90px;" -->
                 <h1 class="text-h1">Welcome to <span class="text-span">withPP</span>  </h1> <!-- <span class="text-primary"> -->
                  <p class="mb-0"><a href="showPostList.do" class="btn btn-primary px-4 py-2 rounded-0 btn-color">With Cafe GO</a></p>
                </div>
              </div>
            </div>
        </div>
      </div>
      <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1" style="background-image: url('images/main2.jpg');">
          <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center" style="margin-top: 150px;">
                  <h1 class="text-h1">Hava a nice day </h1>
                  <p class="mb-0"><a href="showPostList.do" class="btn btn-primary px-4 py-2 rounded-0 btn-color">With Cafe GO</a></p>
                </div>
              </div>
            </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-5">
            <h2 class="heading-39291">We Create Building, and Interior Design That Enhance The Human Experience</h2>
            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea, consequuntur, harum? Culpa, iure vel fugiat veritatis obcaecati architecto.</p>
            <p><a href="#" class="more-39291">More About Us</a></p>
          </div>

          <div class="col-md-4 ml-auto">
            <div class="year-experience-99301">
              <h2 class="heading-39291">The Best In Interior Design</h2>
              <span class="text">Years <span>of Experience</span></span>
              <span class="number"><span>75</span></span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row  mb-5">
          <div class="col-md-7">
            <h2 class="heading-39291">Our Featured <br> Services</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iusto quos veniam magni totam, architecto earum dolor id obcaecati!</p>
            <p class="my-5"><a href="#" class="more-39291">Learn More</a></p>
          </div>
        </div>

        <div class="row">
          <div class="col-md-6" data-aos="fade-up" data-aos-delay="">

            <div class="media-92812">
              <img src="images/img_1.jpg" alt="Image" class="img-fluid">
              <div class="text">
                <span class="caption">Architecture</span>
                <h3><a href="#">SED UT PERSPICIATIS UNDE THIS</a></h3>
                <p class="my-5"><a href="#" class="more-39291">Learn More</a></p>
              </div>
            </div>

          </div>

          <div class="col-md-6 ml-auto" data-aos="fade-up"  data-aos-delay="100">

            <div class="media-92812">
              <img src="images/img_2.jpg" alt="Image" class="img-fluid">
              <div class="text">
                <span class="caption">Gym &amp; Arena</span>
                <h3><a href="#">CURABITUR BIBENDUM</a></h3>
                <p class="my-5"><a href="#" class="more-39291">Learn More</a></p>
              </div>
            </div>

          </div>

          <div class="col-md-6" data-aos="fade-up" data-aos-delay="">

            <div class="media-92812">
              <img src="images/img_3.jpg" alt="Image" class="img-fluid">
              <div class="text">
                <span class="caption">Interior Design</span>
                <h3><a href="#">Obcaecati Architecto</a></h3>
                <p class="my-5"><a href="#" class="more-39291">Learn More</a></p>
              </div>
            </div>

          </div>

          <div class="col-md-6 ml-auto" data-aos="fade-up" data-aos-delay="100">

            <div class="media-92812">
              <img src="images/img_4.jpg" alt="Image" class="img-fluid">
              <div class="text">
                <span class="caption">Product Design</span>
                <h3><a href="#">QUISQUE NON AUGUE</a></h3>
                <p class="my-5"><a href="#" class="more-39291">Learn More</a></p>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-5 align-items-center">
          <div class="col-md-7">
            <h2 class="heading-39291">Latest <br>Projects</h2>
          </div>
          <div class="col-md-5 text-right">
            <p><a href="#" class="more-39291">View All Projects</a></p>
          </div>
        </div>
      </div>
      <div class="media-29191">
        <div class="owl-2 owl-carousel">
          <img src="images/hero_1.jpg" alt="Image" class="img-fluid">
          <img src="images/hero_2.jpg" alt="Image" class="img-fluid">
          <img src="images/hero_3.jpg" alt="Image" class="img-fluid">
        </div>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-md-7">
              <div class="text">
                <span class="caption mb-3 d-block">Interior Design</span>
                <h3 class="mb-3"><a href="#">Obcaecati Architecto</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non libero blanditiis dignissimos natus, necessitatibus consequatur vel alias delectus!</p>
                <p class="my-5"><a href="#" class="more-39291">View This Project</a></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  
    <div class="site-section section-4">
      <div class="container">

        <div class="row justify-content-center text-center">
          <div class="col-md-7">
            <div class="slide-one-item owl-carousel">
              <blockquote class="testimonial-1">
                <span class="quote quote-icon-wrap"><span class="icon-format_quote"></span></span>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus totam sit delectus earum facere ex ea sunt, eos?</p>
                <cite><span class="text-black">Mike Dorney</span> &mdash; <span class="text-muted">CEO and Co-Founder</span></cite>
              </blockquote>

              <blockquote class="testimonial-1">
                <span class="quote quote-icon-wrap"><span class="icon-format_quote"></span></span>
                <p>Eligendi earum ad perferendis dolores, dolor quas. Ullam in, eaque mollitia suscipit id aspernatur rerum! Sit quibusdam ullam tempora quis, in voluptatum maiores veritatis recusandae!</p>
                <cite><span class="text-black">James Smith</span> &mdash; <span class="text-muted">CEO and Co-Founder</span></cite>
              </blockquote>

              <blockquote class="testimonial-1">
                <span class="quote quote-icon-wrap"><span class="icon-format_quote"></span></span>
                <p> Officia, eius omnis rem non quis eos excepturi cumque sequi pariatur eaque quasi nihil dicta tempore voluptate culpa, veritatis incidunt voluptatibus qui?</p>
                <cite><span class="text-black">Mike Dorney</span> &mdash; <span class="text-muted">CEO and Co-Founder</span></cite>
              </blockquote>
            </div>
          </div>
        </div>
      </div>
    </div>
    

    <div class="site-section">
      <div class="container">
        <div class="row  mb-5">
          <div class="col-md-7">
            <h2 class="heading-39291">Blog and Updates</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iusto quos veniam magni totam, architecto earum dolor id obcaecati!</p>
            
          </div>
        </div>
        <div class="row align-items-stretch">
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              <a href="#">
                <img src="images/post_1.jpg" alt="Image"
                 class="img-fluid">
              </a>
              <div class="post-entry-1-contents">
                <span class="meta">July 17, 2019</span>
                <h2><a href="#">Iusto quos veniam magni totam</a></h2>
                <p class="my-3"><a href="#" class="more-39291">Continue Reading</a></p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              <a href="#">
                <img src="images/post_2.jpg" alt="Image"
                 class="img-fluid">
              </a>
              <div class="post-entry-1-contents">
                <span class="meta">July 17, 2019</span>
                <h2><a href="#">Iusto quos veniam magni totam</a></h2>
                <p class="my-3"><a href="#" class="more-39291">Continue Reading</a></p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              <a href="#">
                <img src="images/post_3.jpg" alt="Image"
                 class="img-fluid">
              </a>
              <div class="post-entry-1-contents">
                <span class="meta">July 17, 2019</span>
                <h2><a href="#">Iusto quos veniam magni totam</a></h2>
                <p class="my-3"><a href="#" class="more-39291">Continue Reading</a></p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              <a href="#">
                <img src="images/post_4.jpg" alt="Image"
                 class="img-fluid">
              </a>
              <div class="post-entry-1-contents">
                <span class="meta">July 17, 2019</span>
                <h2><a href="#">Iusto quos veniam magni totam</a></h2>
                <p class="my-3"><a href="#" class="more-39291">Continue Reading</a></p>
              </div>
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
