<!--  게시글 리스트 페이지  -->
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">

  <head>
    <title>withPP - withPet</title>
    <!--  파비콘 추가  -->
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
    
    <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1" style="background-image: url('images/dog3.jpg');">
            <div class="container">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-6 text-center">
                  <h1 style="color:gold;">FAVORITE POST</h1>

                </div>
              </div>
            </div>
        </div>
      </div>    
      <div class="site-section">
      <div class="container">
        <div class="row align-items-center  justify-content-center">
		<table>		
		<c:forEach var="v" items="${Fdata}"> 
         	
         	<tr>
            	<td>📌 </td>
            	<td><a href="showPost.do?pnum=${v.pnum}">${v.title}</a></td>
            </tr>
       	 </c:forEach>
       	 </table>
       	 </div>
       	 </div>
       	 </div>
		<div class="site-section-paging">
		<div class="container">
		<div class="row" style="justify-content: center;">
		<%-- 	<ul id="paging" class="pagenation">
					<c:if test="${paging.pageNum==paging.firstPageNum}">
						 <span class="p-3"><a href="showFavoriteList.do?page=${paging.prevPageNum}">prev</a></span>
					</c:if>
					<c:if test="${paging.pageNum!=paging.firstPageNum}">
						<span class="p-3"><a
							href="showFavoriteList.do?page=${paging.prevPageNum}">prev</a></span>
					</c:if>
					<c:forEach var="i" begin="${paging.startPageNum}"
						end="${paging.endPageNum}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNum}">
								<span class="p-3"><a class="page">${i}</a></span>
							</c:when>
							<c:otherwise>
								<span class="p-3">
									<a href="showFavoriteList.do?page=${i}"class="page">${i}</a>
								</span>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${paging.pageNum==paging.finalPageNum}">
						<span class="p-3">
							<a href="showFavoriteList.do?page=${paging.nextPageNum}"class="button disabled">next</a>
						</span>
					</c:if>
					<c:if test="${paging.pageNum!=paging.finalPageNum}">
						<span class="p-3">
							<a href="showFavoriteList.do?page=${paging.nextPageNum}"class="button">next</a>
						</span>
					</c:if> 
			</ul> --%>
		</div>
        </div>
      </div>
    </div>

    <div class="container">
	<div class="row" style="justify-content: center;">

	</div>
	</div>


    <!-- footer 태그  -->
	<mytag:footer/>

    
	<!-- js리스트 태그 -->
	<mytag:js/>
  </body>

</html>
