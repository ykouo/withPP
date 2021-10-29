<!--  게시글 리스트 페이지  -->
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*"%>
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
                  <h1>게시글 목록</h1>
                  <c:if test="${! empty mem}">
                  	<button type="button" onclick="location.href='postInsert.jsp;'">글작성</button>
                  </c:if>
                </div>
              </div>
            </div>
        </div>
      </div>    
      <div class="site-section">
      <div class="container">
        <div class="row align-items-stretch">
		<c:forEach var="v" items="${pfcafeList}"> 
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              <a href="showPost.do?pnum=${v.pnum}">
                <img src="${v.thumnail}" alt="썸네일"
                 class="img-fluid">
              </a>
              <div class="post-entry-1-contents">
                <span class="meta">${v.wdate} 조회수 : ${v.cnt}</span>
           		<a href="showPost.do?pnum=${v.pnum}"><h2>[${v.location}] ${v.title}</h2></a>
                <p class="my-3"><a href="showPost.do?pnum=${v.pnum}" class="more-39291">Continue Reading</a></p>
              </div>
            </div>
          </div>
       	 </c:forEach>
       	 </div>
       	 </div>
       	 </div>
		<div class="site-section-paging">
		<div class="container">
		<div class="row" style="justify-content: center;">
			<ul id="paging" class="pagenation">
					<c:if test="${paging.pageNum==paging.firstPageNum}">
						 <span class="p-3"><a href="showPostList.do?page=${paging.prevPageNum}">prev</a></span>
					</c:if>
					<c:if test="${paging.pageNum!=paging.firstPageNum}">
						<span class="p-3"><a
							href="showPostList.do?page=${paging.prevPageNum}">prev</a></span>
					</c:if>
					<c:forEach var="i" begin="${paging.startPageNum}"
						end="${paging.endPageNum}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNum}">
								<span class="p-3"><a class="page">${i}</a></span>
							</c:when>
							<c:otherwise>
								<span class="p-3">
									<a href="showPostList.do?page=${i}"class="page">${i}</a>
								</span>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${paging.pageNum==paging.finalPageNum}">
						<span class="p-3">
							<a href="showPostList.do?page=${paging.nextPageNum}"class="button disabled">next</a>
						</span>
					</c:if>
					<c:if test="${paging.pageNum!=paging.finalPageNum}">
						<span class="p-3">
							<a href="showPostList.do?page=${paging.nextPageNum}"class="button">next</a>
						</span>
					</c:if>
			</ul>
		</div>
        </div>
      </div>
    </div>

    <div class="container">
	<div class="row" style="justify-content: center;">
		<form action="searchPostList.do" method="post">
			<table>
				<!-- condition keyword -->
				<tr>
					<th><select name="condition">
							<c:forEach var="op" items="${sm}">
								<option value="${op.value}">${op.key}</option>
							</c:forEach>
					</select></th>
					<td><input type="text" name="keyword"></td>
					<td><input type="submit" value="검색"></td>
				</tr>
			</table>
		</form>
	</div>
	</div>


    <!-- footer 태그  -->
	<mytag:footer/>

    
	<!-- js리스트 태그 -->
	<mytag:js/>
  </body>

</html>
