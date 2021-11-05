//글작성시 textarea가 자동으로 길어짐
function resize(obj) {
	obj.style.height = "1px";
	obj.style.height = (obj.scrollHeight) + "px";
}

// 글작성시 null값 방지를 위해 입력값이 없을경우 alert창을 띄움
$(document).ready(function() {
	$("#postWrite").click(function() {
		if ($("#title").val().length == 0) {
			alert("제목을 입력해주세요");
			$("#title").focus();
			return false;
		}
		if ($("#content").val().length == 0) {
			alert("내용을 입력해주세요");
			$("#content").focus();
			return false;
		}
	});
});