<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Document</title>
    <script>
        $(document).ready(function () {
           $("#email_addr").on("change",function () {
               var $selected = $(this).val();
               if($selected == "직접 입력"){
                $("#email").prop("disabled", false);
                $("#email").val("");
               }else{
                    $("#email").val($selected);
                    $("#email").prop("disabled", true);
               }
               
           }) 
        });
    </script>
</head>
<body>
    <input type="text">@
    <input type="text" id="email">
    <select id="email_addr">
        <option disabled selected>이메일을 선택해주세요.</option>
        <option>직접 입력</option>
        <option>naver.com</option>
        <option>daum.net</option>
        <option>gmail.com</option>
        <option>hanmail.net</option>
    </select>
</body>
</html>