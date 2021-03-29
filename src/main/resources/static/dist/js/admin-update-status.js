function updateStatus(id, name, status, type){
	var text = '('+ id + ') ' + name;
	$("#updateStatus_text").html(text);

	var before = "true";
	var after = "false";
	if (!status) {
		before = "false";
		after = "true";
	}

	$("#updateStatus_before").html(before);
	$("#updateStatus_after").html(after);

	var confirm = "/admin/" + type + "/" + id + "/" + !status;
	var confirmBtnEle = $("#updateStatus_confirm");
	confirmBtnEle.attr('href',confirm);
};