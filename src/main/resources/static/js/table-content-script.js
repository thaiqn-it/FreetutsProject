$(document).ready(function(){
	var h2List = $("h2 strong");
	
	var i;
	for (i = 0; i < h2List.length; i++){
		let id = "goto-"+ (i+1);
		h2List[i].id = id;
		h2List[i].style.color = "#315062";
		
		$("#go-to-list").append("<li><a href=#" + id +" class='go-to-item'>" + h2List[i].innerHTML +"</a></li>");
	}
});