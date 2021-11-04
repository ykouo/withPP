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
				<input type="hidden" name="roadaddress" value="${data.roadaddress}">
				<input type="hidden" name="detailaddress" value="${data.detailaddress}">
				<input type="hidden" name="phone" value="${data.phone}">
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
           		<c:if test="${mem.mid eq data.mid || kakaoVO.mid eq data.mid || naverVO.mid eq data.mid }">
           		<input type="submit" value="수정하기">
           	 	</c:if>
           	 </form>
           	 <c:if test="${mem.mid eq data.mid || kakaoVO.mid eq data.mid || naverVO.mid eq data.mid}">
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
            <p class="lead"><b>주소 :</b> [${data.postcode}] ${data.roadaddress} ${data.detailaddress}</p>
           	<blockquote><p><b> 연락처 :</b> ${data.phone}</p></blockquote>
           	<blockquote><p><b> 참고사항 : </b>${data.content}</p></blockquote>

            <div class="pt-5">
              <p>Tags: <a href="#">#${data.location}</a></p>
            </div>

<!--  댓글 시작  -->
            <div class="pt-5">
              <h3 class="mb-5">Comments</h3>
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
                    <c:if test="${mem.mid eq comm.mid || kakaoVO.mid eq comm.mid}">
                    	<p><button onclick="location.href='deleteComm.do?cnum=${comm.cnum}&pnum=${data.pnum}'" class="btn-primary">댓글삭제</button></p>
                    </c:if>
                    <p><a href="clickLike.do?cnum=${comm.cnum}&pnum=${data.pnum}" >👍🏻</a> : ${comm.likecnt}</p>
                  </div>
                </li>
                </c:forEach>
                
                <li>
                <c:if test="${empty mem && empty kakaoVO && empty naverVO}">
                	<div class="comment-body">
                    <textarea disabled="disabled" readonly="readonly" style="resize: none; width:50%;height:100px;">로그인후 이용가능합니다:D</textarea>
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
                    <input type="text" id="commBox" name="comm" style="resize: none;" required="required">                
                    <input type="submit" class="reply" value="등록">
                  </div>
                </form>
                </c:if>
                <c:if test="${!empty kakaoVO}">
                <form action="insertComm.do" method="post">
                 <div class="vcard bio">
                    <img src="images/thumnail.png" alt="Free Website Template by Free-Template.co">
                  </div>
                
 				<div class="comment-body">
                    <h3>${kakaoVO.nickname}</h3>
                <div class="meta"></div>
                    <input type="hidden" name="pnum" value="${data.pnum}">
                    <input type="hidden" name="mid" value="${kakaoVO.mid}">
                    <input type="hidden" name="nickname" value="${kakaoVO.nickname}">
                    <input type="hidden" name="profileimage" value="images/thumnail.png">
                    <input type="text" name="comm" style="resize: none;" required="required">                
                    <input type="submit" class="reply" value="등록">
                  </div>
                </form>
                </c:if>
                <c:if test="${!empty naverVO}">
                <form action="insertComm.do" method="post">
                 <div class="vcard bio">
                    <img src="images/thumnail.png" alt="Free Website Template by Free-Template.co">
                  </div>
                
 				<div class="comment-body">
                    <h3>${naverVO.nickname}</h3>
                <div class="meta"></div>
                    <input type="hidden" name="pnum" value="${data.pnum}">
                    <input type="hidden" name="mid" value="${naverVO.mid}">
                    <input type="hidden" name="nickname" value="${naverVO.nickname}">
                    <input type="hidden" name="profileimage" value="images/thumnail.png">
                    <input type="text" name="comm" style="resize: none;" required="required">                
                    <input type="submit" class="btn btn-primary btn-md text-white" value="등록">
                  </div>
                </form>
                </c:if>
                </li>
             
              </ul> 
              <!-- END comment-list -->

            </div>

          </div>
          <div class="col-md-4 sidebar">


            <div class="sidebar-box">
              <img src="${mem.profileimage}" alt="Free Website Template by Free-Template.co" class="img-fluid mb-4 w-50 rounded-circle">
              <h3 class="text-black">${mem.nickname}</h3>
              <!-- <p><a href="#" class="btn btn-primary btn-md text-white">Read More</a></p> -->
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
