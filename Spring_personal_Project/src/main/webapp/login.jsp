<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">

  <head>
    <title>withPP - LOGIN</title>
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
        <div class="ftco-cover-1 " style="background-color: #FEE4A6" >
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                </div>
              </div>
            </div>
        </div>
      </div>


    <div class="site-section">
      <div class="container" >   
        <div class="row" style="justify-content: center;"> <!--  style="justify-content: center" : 가운데정렬  -->
          <div class="col-lg-8 mb-5" >
            <form action="login.do" method="post">
              <div class="form-group row" style="justify-content: center;">
                <div class="col-md-6 mb-4 mb-lg-0" >
                  <input type="text" class="form-control" placeholder="ID" name="mid" required="required">   	   
                  <br>
                  <input type="password" class="form-control" placeholder="Password" name="mpw" required="required">
                  <br>
                  <input type="submit" class="btn btn-block btn-primary text-white py-3 px-5" value="Login">
               	  <br>
               	  <p style="text-align: center;"><b><a href="signIn.jsp">회원가입</a></b></p>
                </div>
              </div>		
            </form>
            
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