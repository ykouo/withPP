(function($) {

	var title = document.getElementById("title");
	var content = document.getElementById("content");
	var location = document.getElementById("titleInputCheck");
	var locaddress = document.getElementById("titleInputCheck");
	var loccall = document.getElementById("titleInputCheck");

	

	if(!((title==null && content==null && location==null && loccall==null && locaddress==null) || (title=="" && content=="" && location=="" && loccall=="" && locaddress==""))){
		$(window).on("beforeunload", function() {
			return "작성중인 글이 존재합니다. 페이지를 나가시겠습니까?";
		});

		$("#postWrite").on("submit", function() {
			console.log("1");
			$(window).off("beforeunload");
			console.log("2");
			/*beforeunload 이벤트는 페이지를 벗어나기 전 확인 메시지를 출력하는 이벤트*/
		});
/*		 // edit.jsp페이지에서 삭제버튼 클릭시 변경사항이 있다는 alert창 뜨지 않겠끔 막음 
        $("#delete").click(function() {
            $(window).off("beforeunload");
            
        });*/
	}
})(jQuery);