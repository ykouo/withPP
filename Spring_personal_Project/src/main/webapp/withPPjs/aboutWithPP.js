window.onload = function(){
	var sdt = new Date("2021-10-24 00:00:00");
	var edt = new Date();
	var startDate = document.getElementById('startDate');
	var dateDiff = Math.ceil((edt.getTime()-sdt.getTime())/(1000*3600*24));
	console.log(dateDiff);
	startDate.innerHTML = dateDiff;
};