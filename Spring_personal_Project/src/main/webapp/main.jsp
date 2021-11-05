<!-- Main페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <title>withPP - with Pet&amp;People</title>
    <!-- 파비콘 커스텀 태그 -->
  	<mytag:Fabicon/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- styleLink모음 태그 -->
	<mytag:styleLink/>  
  </head>	 
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
	<div class="site-wrap" id="home-section">
  	<!-- 메뉴/로그인/로그아웃/마이페이지 버튼 태그 -->
	<mytag:header/>    
    <div class="owl-carousel owl-1">
      <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1" style="background-image: url('images/main1.jpg');">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center" style="margin-top: 150px;">
					<h1 class="text-h1">Welcome to <span class="text-span">withPP</span></h1>
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
        <div class="col-md-7">
            <div class="slide-one-item owl-carousel">
              <blockquote class="testimonial-1">
                <span class="quote quote-icon-wrap"><span class="icon-format_quote"></span></span>
                <p>❤🐶피곤한 강아지가 가장 행복한 강아지🐶❤</p>
                <cite><span class="text-black">Mr.설채현</span> &mdash; <span class="text-muted">Veterinarian</span></cite>
              </blockquote>
              <blockquote class="testimonial-1">
                <span class="quote quote-icon-wrap"><span class="icon-format_quote"></span></span>
                <p>🐶🐶🐶🐶🐶🐶🐶🐶🐶🐶🐶🐶🐶</p>
                <cite><span class="text-black">James Smith</span> &mdash; <span class="text-muted">CEO and Co-Founder</span></cite>
              </blockquote>
              <blockquote class="testimonial-1">
                <span class="quote quote-icon-wrap"><span class="icon-format_quote"></span></span>
                <p>🌼🌼👀👀👀👀👀👀👀👀👀👀👀👀🌼🌼</p>
                <cite><span class="text-black">Mike Dorney</span> &mdash; <span class="text-muted">CEO and Co-Founder</span></cite>
              </blockquote>
            </div>
          </div>
           <div class="col-md-4 ml-auto">
            <div class="year-experience-99301">
              <h2 class="heading-39291">Create withPP</h2>
              <span class="text">Since <span>2021/10/24 ~</span></span>
              <span class="number"><span id="startDate"></span></span>
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
	<script src="withPPjs/startDate.js"></script>
  </body>
</html>
