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
	confirmBtnEle.attr("href", confirm);
	$("#enableAllBtn").remove();

	if (type === "category") {
		console.log("0")
		if (status === false) {
			console.log("1")

			$("#updateStatus_confirm").before("<a id=\"enableAllBtn\" class=\"btn btn-outline-success\" href=\"#\">Enable All Children</a>");
			console.log("2")
			let confirm = "/admin/" + type + "/" + id + "/true/enableAll";
			let enableAllBtn = $("#enableAllBtn");
			enableAllBtn.attr("href", confirm);
		}
	}
};
