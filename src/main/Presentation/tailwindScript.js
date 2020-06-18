$(document).ready(() => {

});

function listCommodities() {
	console.log("test");
	// document.getElementById("loaderID").style.display = "block";
	$.ajax({
		url: "https://api.mama.sh/userresource",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			//document.getElementById("loaderID").style.display = "none";
			$("#ListOfUsersTable").html("");
			var html = "";
			//'<table class="tableOfUsers"> <tr><th>Name</th><th>Id</th></tr>';
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td> ${item.userID}  ${item.firstName} ${item.surname}</td>`;
				html += `<td><button class="w3-dark-grey list-item-btn" onclick="inactiveUser(${item.userID});"> ${getStatus(item.status)} <i class="fa fa-close"></i></button> <button onclick="getUser(${item.userID});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
				html += `</tr>`;
			});
			console.log(html);
			$("#ListOfUsersTable").append(html);

			$("#ListOfUsersTable").show();
		},
		error: function (jqXHR, text, error) {
			document.getElementById("loaderID").style.display = "none";
			alert(jqXHR.status + text + error);
		},
	})
};