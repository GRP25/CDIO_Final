$(document).ready(() => {
	var openmodal = document.querySelectorAll('.modal-open')
	for (var i = 0; i < openmodal.length; i++) {
		openmodal[i].addEventListener('click', function (event) {
			event.preventDefault()
			toggleModal()
		})
	}

	const overlay = document.querySelector('.modal-overlay')
	overlay.addEventListener('click', toggleModal)

	var closemodal = document.querySelectorAll('.modal-close')
	for (var i = 0; i < closemodal.length; i++) {
		closemodal[i].addEventListener('click', toggleModal)
	}

	document.onkeydown = function (evt) {
		evt = evt || window.event
		var isEscape = false
		if ("key" in evt) {
			isEscape = (evt.key === "Escape" || evt.key === "Esc")
		} else {
			isEscape = (evt.keyCode === 27)
		}
		if (isEscape && document.body.classList.contains('modal-active')) {
			toggleModal()
		}
	};
});




function toggleModal() {
	const body = document.querySelector('body')
	const modal = document.querySelector('.modal')
	modal.classList.toggle('opacity-0')
	modal.classList.toggle('pointer-events-none')
	body.classList.toggle('modal-active')
}

function listCommodities() {
	console.log("test");
	// document.getElementById("loaderID").style.display = "block";
	$.ajax({
		url: "https://api.mama.sh/userresource",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			//document.getElementById("loaderID").style.display = "none";
			$("#listOfCommoditiestable").html("");
			var html = "";
			//'<table class="tableOfUsers"> <tr><th>Name</th><th>Id</th></tr>';
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td> ${item.userID}  ${item.firstName} ${item.surname}</td>`;
				html += `<td><button class="w3-dark-grey list-item-btn" onclick="inactiveUser(${item.userID});"> ${getStatus(item.status)} <i class="fa fa-close"></i></button> <button onclick="getUser(${item.userID});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
				html += `</tr>`;
			});
			console.log(html);
			$("#listOfCommoditiestable").append(html);

			$("#listOfCommoditiestable").show();
		},
		error: function (jqXHR, text, error) {
			document.getElementById("loaderID").style.display = "none";
			alert(jqXHR.status + text + error);
		},
	})
};