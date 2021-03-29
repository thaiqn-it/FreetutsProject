function updateStatus(text,confirm,status){
	$("#updateStatus_text").html(text);
	
	var status_before = "false";
	var status_after = "true";
	if(status){
		status_before = "true";
		status_after = "false";
	}
	
	 $("#updateStatus_before").html(status_before);
	 $("#updateStatus_after").html(status_after);
	 
    var confirmBtnEle = $("#updateStatus_confirm");
	confirmBtnEle.attr('href',confirm);
};