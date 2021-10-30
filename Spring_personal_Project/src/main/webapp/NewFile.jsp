<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        .dellink{
          display: none;
        }
        .thumb{
          width : 100px;
       	  height: 100px;
       	  }
    </style>
</head>
   <script type="text/javascript" src="withPPjs/upload.js"></script>
<body>
	<input type="file" class="hidden_input" id="imageSelector"
		name="imageSelector" accept="image/jpeg, image/jpg, image/png"
		multiple />
	<img src="" class="thumb"/>
	<a href="javascript:void(0);" class="dellink">썸네일삭제</a>
</body>
</html>