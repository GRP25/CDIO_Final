$(document).ready(() => {
	$('.valgmuligheder').on('click', function () {
		var target = $(this).data('target');
		$('.mainScreen').not(target).hide();
		$(target).show();
	})

	$('.administration').on('click', function () {
		var target = $(this).data('target');
		$('.mainWindow').not(target).hide();
		$(target).show();
	});

});



function listCommodities() {
	event.preventDefault();
	console.log("test");
	// document.getElementById("loaderID").style.display = "block";
	$.ajax({
		url: "https://api.mama.sh/commodity",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			console.log("test");
			//document.getElementById("loaderID").style.display = "none";
			$("#listOfCommoditiestable").html("");
			let html = `<thead><tr><th class="w-1/2 px-4 py-2">Råvare navn</th><th class="w-1/2 px-4 py-2">Råvare id</th></tr></thead><tbody>`
			//'<table class="tableOfUsers"> <tr><th>Name</th><th>Id</th></tr>';
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2"> <span class="float-left"> ${item.commodity_Name}</td>`;
				html += `<td class="border px-4 py-2">
					<span class="commodity-id float-left"> ${item.commodity_id}</span>
					<div class="flex inline-block justify-end px-2 ">
								<button
									class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getCommodity(${item.commodity_id})">vis</button>
								<button
									class="bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right">slet</button>
							</div>
				</td>`;
				html += `</tr>`;
			});
			html += `</tbody>`
			console.log(html);
			$("#listOfCommoditiestable").append(html);
			applyModal();

			$("#listOfCommoditiestable").show();
		},
		error: function (jqXHR, text, error) {
			alert(jqXHR.status + text + error);
		},
	})
};


function applyModal() {
	var openmodal = document.querySelectorAll('.modal-open')
	for (var i = 0; i < openmodal.length; i++) {
		openmodal[i].addEventListener('click', function (event, id) {
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
}

function toggleModal() {
	const body = document.querySelector('body')
	const modal = document.querySelector('.modal')
	modal.classList.toggle('opacity-0')
	modal.classList.toggle('pointer-events-none')
	body.classList.toggle('modal-active')
}



function createPrescriptionModal(funktion) {
	toggleModal()
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
			<label>Råvare Navn:</label>
			<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
				placeholder="" id="showPrescriptionName"></input> <br />

			<label>Råvare id:</label>
			<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
				placeholder="" id="showPrescriptionId"></input> <br />

		</form>`);
	$("#modal-footer").html("");
	$("#modal-footer").append(
		`<div>
					<button
						class="modal-update px-4 bg-transparent p-3 rounded-lg text-indigo-500 hover:bg-gray-100 hover:text-indigo-400 mr-2"
						onclick=${funktion}>Opret </button>
					<button
						class="modal-close px-4 bg-indigo-500 p-3 rounded-lg text-white hover:bg-indigo-400">Close</button>
				</div>`
	);


}

function createCommodity() {
	console.log("create commodity started");
	const commodity = {
		commodity_Name: $("#showRåvareNavn").val(),
		commodity_id: $("#showRåvareId").val(),
	};
	console.log(commodity.commodity_Name);

	$.ajax({
		url: "https://api.mama.sh/commodity",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(commodity),
		succes: function (response) {
			toggleModal()
			listCommodities()
		},
		error: function (jqXHR, text, error) {
			alert(jqXHR.status + text + error);
		},
	})
}





function updateCommodity() {
	toggleModal();
	console.log("update started");
	const commodity = {
		commodity_Name: $("#showRåvareNavn").val(),
		commodity_id: $("#showRåvareId").val(),
	};

	console.log(commodity.commodity_Name);

	$.ajax({
		url: `https://api.mama.sh/commodity`,
		contentType: "application/json",
		method: "PUT",
		data: JSON.stringify(commodity),
		succes: function (response) {
			listCommodities();
		},
		error: function (jqXHR, text, error) {
			toggleModal();
			alert(jqXHR.status + text + error);
		},
	});
}



function listUsers() {
	// document.getElementById("loaderID").style.display = "block";
	console.log("Test");
	$.ajax({
		url: "https://api.mama.sh/userresource",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			//document.getElementById("loaderID").style.display = "none";
			$("#listOfUsersTable").html("");
			let html = `<thead>
			<tr>
			<th class="w-1/3 px-4 py-2">Bruger ID</th>
			<th class="w-1/3 px-4 py-2">Bruger navn</th>
			<th class="w-1/3 px-4 py-2">Bruger roller</th>
			</tr>
			</thead>
			<tbody>`;
			//'<table class="tableOfUsers"> <tr><th>Name</th><th>Id</th></tr>';
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.userID}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.firstName} ${item.surname}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.roles}</span>
				<div class="flex inline-block justify-end px-2"> 
				<button class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getUser(${item.userID})">vis</button>
				<button class="bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="inactiveUser(${item.userID}, ${item.status})">${getStatus(item.status)}</button>
				</div>
				</td>`

				html += `</tr>`;
			});
			html += `</tbody>`;
			console.log(html);
			$("#listOfUsersTable").append(html);

			$("#listOfUsersTable").show();
		},
		error: function (jqXHR, text, error) {
			document.getElementById("loaderID").style.display = "none";
			alert(jqXHR.status + text + error);
		},
	});

}

function UserModal(funktion) {
	$("#modal-title").text("Brugere");
	toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
<label>Bruger ID:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="ShowUserID"></input> <br />

<label>Fornavn:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="ShowUserFirstName"></input> <br />

<label>Efternavn:</label>
	<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
		placeholder="" id="ShowUserLastName"></input> <br />

<label>CPR nummer:</label>
	<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="ShowUserCPR"></input> <br />

<label>Initialer:</label>
	<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="ShowUserIniTxt"></input> <br />

	<label>Roller: </label> <input type="checkbox" id="ShowUserRolesAdmin"> Administrator</input>, <input type="checkbox" id="ShowUserRolesFarma">Farmaceut</input>, <input type="checkbox" id="ShowUserRolesProductionleader">Produktionsleder</input>, <input type="checkbox" id="ShowUserRolesLab">Laborant</input> <br />
	<label>Status: </label> <input  type="checkbox" id="ShowUserStatus"> Aktiv </input> <br />
</form>`);
	$("#modal-footer").html("");
	$("#modal-footer").append(
		`<div>
					<button
						class="modal-update px-4 bg-transparent p-3 rounded-lg text-indigo-500 hover:bg-gray-100 hover:text-indigo-400 mr-2"
						onclick=${funktion}>Opret </button>
					<button
						class="modal-close px-4 bg-indigo-500 p-3 rounded-lg text-white hover:bg-indigo-400">Close</button>
				</div>`
	);

}

function createCommodityModal(funktion) {
	toggleModal()
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
			<label>Råvare Navn:</label>
			<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
				placeholder="" id="showRåvareNavn"></input> <br />

			<label>Råvare id:</label>
			<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
				placeholder="" id="showRåvareId"></input> <br />

		</form>`);
	$("#modal-footer").html("");
	$("#modal-footer").append(
		`<div>
					<button
						class="modal-update px-4 bg-transparent p-3 rounded-lg text-indigo-500 hover:bg-gray-100 hover:text-indigo-400 mr-2"
						onclick=${funktion}>Opret </button>
					<button
						class="modal-close px-4 bg-indigo-500 p-3 rounded-lg text-white hover:bg-indigo-400">Close</button>
				</div>`
	);


	applyModal()


}

function getUser(id, showBox = true) {

	UserModal("updateUser()")
	console.log("getuser Started");
	$.ajax({
		url: "https://api.mama.sh/userresource/" + id,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			if (showBox === true) {
				toggleModal();
			}
			$("#ShowUserID").val(response.userID);
			$("#ShowUserFirstName").val(response.firstName);
			$("#ShowUserLastName").val(response.surname);
			$("#ShowUserCPR").val(response.cpr);
			$("#ShowUserIniTxt").val(response.initials);

			// set user status
			if (response.status == 0) {
				$("#ShowUserStatus").prop('checked', false);
			}
			else {
				$("#ShowUserStatus").prop('checked', true);
			}

			// setup for roles
			$("#ShowUserRolesAdmin").prop('checked', false);
			$("#ShowUserRolesFarma").prop('checked', false);
			$("#ShowUserRolesProductionleader").prop('checked', false);
			$("#ShowUserRolesLab").prop('checked', false);

			response.roles.forEach(role => {
				if (role === "Admin") {
					$("#ShowUserRolesAdmin").prop('checked', true);
				}
				else if (role === "Pharmaceut") {
					$("#ShowUserRolesFarma").prop('checked', true);
				}
				else if (role === "Produktionsleder") {
					$("#ShowUserRolesProductionleader").prop('checked', true);
				}
				else if (role === "Laborant") {
					$("#ShowUserRolesLab").prop('checked', true);
				}
			});
			applyModal();
			return response;
		},
		error: function (jqXHR, text, error) {
			document.getElementById("loaderID").style.display = "none";
			alert(jqXHR.status + text + error);
		},
	});

	console.log("getuser done");
}

function inactiveUser(id, state) {
	console.log("inactive user");
	if (state == 1) {
		$.ajax({
			url: `https://api.mama.sh/userresource/${id}`,
			contentType: "application/json",
			method: "DELETE",
			success: function (response) {
				alert("Bruger er blevet inaktiv");
			},
			error: function (jqXHR, text, error) {
				document.getElementById("loaderID").style.display = "none";
				alert(jqXHR.status + text + error);
			},
		});
	}
	else {
		// use the update function
		let bruger = {};
		$.ajax({
			url: `https://api.mama.sh/userresource/${id}`,
			contentType: "application/json",
			method: "GET",
			success: function (response) {
				bruger = {
					userID: response.userID,
					firstName: response.firstName,
					surname: response.surname,
					cpr: response.cpr,
					initials: response.initials,
					roles: response.roles,
					status: 1
				}
			},
			error: function (jqXHR, text, error) {
				document.getElementById("loaderID").style.display = "none";
				alert(jqXHR.status + text + error);
			},
		});
		//let user = JSON.parse(bruger);
		console.log("bruger", bruger);
		$.ajax({
			url: "https://api.mama.sh/userresource",
			contentType: "application/json",
			method: "PUT",
			data: JSON.stringify(bruger),
			success: function (response) {
				alert("Bruger opdateret");
			},
			error: function (data, text, error) {
				alert("fejl: bruger ikke opdateret");
			}

		});
	}
}

function getCommodity(id) {
	console.log("getuser Started");
	createCommodityModal("updateCommodity()");
	$.ajax({
		url: `https://api.mama.sh/commodity/${id}`,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			console.log("Hej");
			console.log(response.commodity_Name);
			toggleModal();
			$("#showRåvareNavn").val(response.commodity_Name);
			$("#showRåvareId").val(response.commodity_id);

			applyModal();

		},
		error: function (jqXHR, text, error) {
			alert(jqXHR.status + text + error);
		},
	});
}

function updateUser() {
	console.log("Update user started");
	let userRoles = [];//function () {
	//if ($("#CreateUserRolesAdmin").checked == true) {
	if (document.getElementById("ShowUserRolesAdmin").checked == true)
		userRoles.push("Admin");
	if (document.getElementById("ShowUserRolesFarma").checked == true)
		userRoles.push("Pharmaceut");

	if (document.getElementById("ShowUserRolesProductionleader").checked == true)
		userRoles.push("Produktionsleder");

	if (document.getElementById("ShowUserRolesLab").checked == true)
		userRoles.push("Laborant");

	// get status
	var userStatus;
	if (document.getElementById("ShowUserStatus").checked == true)
		userStatus = "1";
	else
		userStatus = "0";

	var user = {

		userID: $("#ShowUserID").val(),
		firstName: $("#ShowUserFirstName").val(),
		surname: $("#ShowUserLastName").val(),
		cpr: $("#ShowUserCPR").val(),
		initials: $("#ShowUserIniTxt").val(),
		roles: userRoles,

		// Adding status
		status: userStatus,
	};

	sendUpdateToServer(user);
}

function createUser() {
	let userRoles = [];//function () {
	//if ($("#CreateUserRolesAdmin").checked == true) {
	if (document.getElementById("ShowUserRolesAdmin").checked == true)
		userRoles.push("Admin");
	if (document.getElementById("ShowUserRolesFarma").checked == true)
		userRoles.push("Pharmaceut");

	if (document.getElementById("ShowUserRolesProductionleader").checked == true)
		userRoles.push("Produktionsleder");

	if (document.getElementById("ShowUserRolesLab").checked == true)
		userRoles.push("Laborant");



	// Getting user status
	var userStatus;
	if (document.getElementById("ShowUserStatus").checked == true)
		userStatus = "1";
	else
		userStatus = "0";

	var user = {

		//  userID: $("#ShowUserID").val(),
		firstName: $("#ShowUserFirstName").val(),
		surname: $("#ShowUserLastName").val(),
		cpr: $("#ShowUserCPR").val(),
		initials: $("#ShowUserIniTxt").val(),
		roles: userRoles,

		// Adding status
		status: userStatus
	};

	$.ajax({
		url: "https://api.mama.sh/userresource",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(user),
		success: function (response) {
			alert("Bruger Oprettet");
		},
		error: function (data, text, error) {
			alert("fejl: bruger ikke oprettet");
		}

	});
}
function sendUpdateToServer(user) {
	$.ajax({
		url: "https://api.mama.sh/userresource",
		contentType: "application/json",
		method: "PUT",
		data: JSON.stringify(user),
		success: function (response) {
			toggleModal();
			alert("Bruger Opdateret");
		},
		error: function (data, text, error) {
			alert("fejl: bruger ikke opdateres");
		}

	});
}

function getStatus(status) {
	if (status == 0) {
		return "aktiver";
	}
	else {
		return "deaktiver";
	}
}