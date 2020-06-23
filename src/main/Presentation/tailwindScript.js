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

var userobject;

function listCommodities() {
	event.preventDefault();
	$("#loaderID").show();
	console.log("test");
	// document.getElementById("loaderID").style.display = "block";
	$.ajax({
		url: "https://api.mama.sh/commodity",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
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
									class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getCommodity(${item.commodity_id});toggleModal();">vis</button>
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
			$("#loaderID").hide();
			alert(jqXHR.status + text + error + "Liste ikke indlæst rigtigt");
		},
	})
};

function applyModal() {
	var openmodal = document.querySelectorAll('.modal-open')
	for (var i = 0; i < openmodal.length; i++) {
		openmodal[i].addEventListener('click', function (event, id) {
			event.preventDefault();
			toggleModal();
		})
	}
	const overlay = document.querySelector('.modal-overlay');
	overlay.addEventListener('click', toggleModal);

	var closemodal = document.querySelectorAll('.modal-close');
	for (var i = 0; i < closemodal.length; i++) {
		closemodal[i].addEventListener('click', toggleModal);
	}

	document.onkeydown = function (evt) {
		evt = evt || window.event;
		var isEscape = false;
		if ("key" in evt) {
			isEscape = (evt.key === "Escape" || evt.key === "Esc");
		} else {
			isEscape = (evt.keyCode === 27);
		}
		if (isEscape && document.body.classList.contains('modal-active')) {
			toggleModal();
		}
	};
}

function toggleModal() {
	const body = document.querySelector('body');
	const modal = document.querySelector('.modal');
	modal.classList.toggle('opacity-0');
	modal.classList.toggle('pointer-events-none');
	body.classList.toggle('modal-active');
}

function listPrescriptions() {
	$("#loaderID").show();
	event.preventDefault();
	console.log("test");
	// document.getElementById("loaderID").style.display = "block";
	$.ajax({
		url: "https://api.mama.sh/Prescriptions",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			console.log("test");
			//document.getElementById("loaderID").style.display = "none";
			$("#listOfPrescriptionsTable").html("");
			let html = `<thead><tr><th class="w-1/2 px-4 py-2">Råvare navn</th><th class="w-1/2 px-4 py-2">Råvare id</th></tr></thead><tbody>`
			//'<table class="tableOfUsers"> <tr><th>Name</th><th>Id</th></tr>';
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2"> <span class="float-left"> ${item.prescription_name}</td>`;
				html += `<td class="border px-4 py-2">
					<span class="commodity-id float-left"> ${item.prescription_id}</span>
					<div class="flex inline-block justify-end px-2 ">
								<button
									class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getPrescription(${item.prescription_id})">vis</button>
							</div>
				</td>`;
				html += `</tr>`;
			});
			html += `</tbody>`
			console.log(html);
			$("#listOfPrescriptionsTable").append(html);
			applyModal();

			$("#listOfPrescriptionsTable").show();
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error +"Liste ikke indlæst rigtigt");
		},
	})
}

function listPrescriptionComp() {
	event.preventDefault();
	$("#loaderID").show();
	// document.getElementById("loaderID").style.display = "block";
	$.ajax({
		url: "https://api.mama.sh/PrescriptionComp",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			//document.getElementById("loaderID").style.display = "none";
			$("#listOfPrescriptionCompTable").html("");
			let html = `<thead><tr><th class="w-1/2 px-4 py-2">Recept id</th><th class="w-1/2 px-4 py-2">Råvare id</th></tr></thead><tbody>`
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2"> <span class="float-left"> ${item.prescription_id}</td>`;
				html += `<td class="border px-4 py-2">
					<span class="commodity-id float-left"> ${item.commodity_id}</span>
					<div class="flex inline-block justify-end px-2 ">
								<button
									class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getPrescriptionComp(${item.prescription_id}, ${item.commodity_id})">vis</button>
							</div>
				</td>`;
				html += `</tr>`;
			});
			html += `</tbody>`
			console.log(html);
			$("#listOfPrescriptionCompTable").append(html);
			applyModal();

			$("#listOfPrescriptionCompTable").show();
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error +"Liste ikke indlæst rigtigt");
		},
	})
}

async function getPrescription(id) {
	$("#loaderID").show();
	createPrescriptionModal("updatePrescription()");

	await $.ajax({
		url: `https://api.mama.sh/Prescriptions/ID/${id}`,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#showPrescriptionName").val(response.prescription_name);
			$("#showPrescriptionId").val(response.prescription_id);
			applyModal();

			$("#WeightPrescriptionName").text(response.prescription_name);

		},
		error: function (response) {
			$("#loaderID").hide();
			alert("Recept ikke hentet prøv et andet ID")
		}
	})
}

function updatePrescription() {
	$("#loaderID").show();
	toggleModal();
	let prescription = {
		prescription_name: $("#showPrescriptionName").val(),
		prescription_id: $("#showPrescriptionId").val(),
	}

	$.ajax({
		url: `https://api.mama.sh/Prescriptions`,
		contentType: "application/json",
		method: "PUT",
		data: JSON.stringify(prescription),
		success: function (response) {
			$("#loaderID").hide();
			alert("Recept opdateret");
			listPrescriptions();
		},
		error: function (response) {
			$("#loaderID").hide();
			alert("Recept ikke opdateret")
		}
	})
}

function createPrescriptionModal(funktion) {
	$("#modal-title").text("Recept");
	//toggleModal()
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
			<label>Recept Navn:</label>
			<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
				placeholder="" id="showPrescriptionName"></input> <br />

			<label>Recept id:</label>
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

	applyModal();


}

function prescriptionCompModal(funktion) {
	$("#modal-title").text("Recept komponent");
	//toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
<label>Recept id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showReceptCompID"></input> <br />

<label>Råvare id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showRåvarePrescriptionId"></input> <br />

<label>nom netto:</label>
	<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
		placeholder="" id="showReceptCompNomNetto"></input> <br />

<label>Tolerance:</label>
	<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showReceptCompTolerance"></input> <br />
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
	applyModal();
}

function getPrescriptionComp(prescription_id, commodity_id) {
	event.preventDefault();
	$("#loaderID").show();
	prescriptionCompModal("updatePrescriptionComp()");
	$.ajax({
		url: `https://api.mama.sh/PrescriptionComp/component?presID=${prescription_id}&comID=${commodity_id}`,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#showReceptCompID").val(response.prescription_id);
			$("#showRåvarePrescriptionId").val(response.commodity_id);
			$("#showReceptCompNomNetto").val(response.nomNetto);
			$("#showReceptCompTolerance").val(response.tolerance);
			applyModal();
		},
		error: function (response) {
			$("#loaderID").hide();
			alert("Recept ikke hentet prøv et andet ID")
		}
	})
}

function createPrescription() {
	$("#loaderID").show();
	toggleModal();
	let prescription = {
		prescription_name: $("#showPrescriptionName").val(),
		prescription_id: $("#showPrescriptionId").val(),
	}

	$.ajax({
		url: `https://api.mama.sh/Prescriptions`,
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(prescription),
		success: function (response) {
			$("#loaderID").hide();
			alert("Recept lavet");
			listPrescriptions();
		},
		error: function (response) {
			$("#loaderID").hide();
			alert("Recept ikke lavet")
		}
	})
}

function updatePrescriptionComp() {
	$("#loaderID").show();
	let prescriptionComp = {
		prescription_id: $("#showReceptCompID").val(),
		commodity_id: $("#showRåvarePrescriptionId").val(),
		nomNetto: $("#showReceptCompNomNetto").val(),
		tolerance: $("#showReceptCompTolerance").val(),

	}

	$.ajax({
		url: `https://api.mama.sh/PrescriptionComp`,
		contentType: "application/json",
		method: "PUT",
		data: JSON.stringify(prescriptionComp),
		success: function (response) {
			$("#loaderID").hide();
			toggleModal();
			listPrescriptionComp();
			alert("Update successfull");
		},
		error: function (response) {
			$("#loaderID").hide();
			alert("Recept komponent ikke opdateret");
		}
	});
}

function createPrescriptionComp() {
	$("#loaderID").show();
	let prescriptionComp = {
		prescription_id: $("#showReceptCompID").val(),
		commodity_id: $("#showRåvarePrescriptionId").val(),
		nomNetto: $("#showReceptCompNomNetto").val(),
		tolerance: $("#showReceptCompTolerance").val(),

	}

	$.ajax({
		url: `https://api.mama.sh/PrescriptionComp`,
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(prescriptionComp),
		success: function (response) {
			$("#loaderID").hide();
			toggleModal();
			listPrescriptionComp();
			alert("Create successfull");
		},
		error: function (response) {
			$("#loaderID").hide();
			alert("Recept komponent ikke lavet");
		}
	});
}

function createCommodity() {
	$("#loaderID").show();
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
			toggleModal();
			$("#loaderID").hide();
			listCommodities()
			alert("Råvare lavet")
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error + "Råvare ikke lavet");
		},
	});
}

function updateCommodity() {
	toggleModal();
	$("#loaderID").show();
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
			$("#loaderID").hide();
			listCommodities();
			alert("Råvare opdateret")
		},
		error: function (jqXHR, text, error) {
			toggleModal();
			$("#loaderID").hide();
			alert(jqXHR.status + text + error +" Råvare ikke opdateret");
		},
	});
}

function listUsers() {
	$("#loaderID").show();
	// document.getElementById("loaderID").style.display = "block";
	console.log("Test");
	$.ajax({
		url: "https://api.mama.sh/userresource",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
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
			$("#loaderID").hide();
			alert(jqXHR.status + text + error+"Brugere ikke hentet");
		},
	});

}

function UserModal(funktion) {
	$("#modal-title").text("Brugere");
//	toggleModal();
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
	$("#modal-title").text("Råvare");
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

async function getUser(id, showBox = true) {

	UserModal("updateUser()")
	$("#loaderID").show();
	console.log("getuser Started");
	await $.ajax({
		url: "https://api.mama.sh/userresource/" + id,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
	//		if (showBox === true) {
	//			toggleModal();
	//		}
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
			$("#loaderID").hide();
			document.getElementById("loaderID").style.display = "none";
			alert(jqXHR.status + text + error+"Bruger ikke hentet prøv et andet ID");
		},
	});

	console.log("getuser done");
}

function inactiveUser(id, state) {
	$("#loaderID").show();
	console.log("inactive user");
	if (state == 1) {
		$.ajax({
			url: `https://api.mama.sh/userresource/${id}`,
			contentType: "application/json",
			method: "DELETE",
			success: function (response) {
				$("#loaderID").hide();
				alert("Bruger er blevet inaktiv");
			},
			error: function (jqXHR, text, error) {
				$("#loaderID").hide();
				document.getElementById("loaderID").style.display = "none";
				alert(jqXHR.status + text + error+" Bruger er ikke blevet inaktiv");
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
				$("#loaderID").hide();
				bruger = {
					userID: response.userID,
					firstName: response.firstName,
					surname: response.surname,
					cpr: response.cpr,
					initials: response.initials,
					roles: response.roles,
					status: 1

				}
				alert("Bruger er inaktiv");
			},
			error: function (jqXHR, text, error) {
				$("#loaderID").hide();
				document.getElementById("loaderID").style.display = "none";
				alert(jqXHR.status + text + error +"Bruger ikke opdateret");
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

async function getCommodity(id) {
	$("#loaderID").show();
	console.log("getuser Started");
	createCommodityModal("updateCommodity()");
	await $.ajax({
		url: `https://api.mama.sh/commodity/${id}`,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			console.log("Hej");
			console.log(response.commodity_Name);
			//toggleModal();
			$("#showRåvareNavn").val(response.commodity_Name);
			$("#showRåvareId").val(response.commodity_id);

			applyModal();

		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error +" Råvare ikke hentet prøv et andet ID");
		},
	});
}

function updateUser() {
	$("#loaderID").show();
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
	$("#loaderID").show();
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
			$("#loaderID").hide();
		//	alert("Bruger Oprettet");
			console.log("Bruger oprettet");
			listUsers();
			toggleModal();
			alert("Bruger oprettet")
			
		},
		error: function (data, text, error) {
			$("#loaderID").hide();
			alert("Bruger ikke oprettet");
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
			$("#loaderID").hide();
			toggleModal();
			alert("Bruger Opdateret");
		},
		error: function (data, text, error) {
			$("#loaderID").hide();
			alert("Bruger ikke opdateret");
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

function showProductModal(hasToggleModal) {
	$("#modal-title").text("Produkt Batch");
	if (hasToggleModal) toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`
<label>Produkt Batch ID:</label>
<span class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showProductBatchID"></span> <br />

<label>Recept ID:</label>
<span class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showPrescriptionID"></span> <br />

<label>Start Dato:</label>
<span class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showStartDate"></span> <br />

<label>Slut Dato:</label>
<span class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showEndDate"></span> <br />

	<label>Status:</label>
<span class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="showInputStatus"></span> <br />

`);
	$("#modal-footer").html("");
	$("#modal-footer").append(
		`<div>
					<button
						class="modal-close px-4 bg-indigo-500 p-3 rounded-lg text-white hover:bg-indigo-400">Close</button>
				</div>`
	);
	applyModal();
}

function productModal(funktion) {
	$("#modal-title").text("Produkt Batch");
	toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
<label>Produkt Batch id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="InputProductBatchID"></input> <br />

<label>Recept id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="InputPrescriptionID"></input> <br />

<label>Status: </label><input class="px-2" name="status" type="radio" id="InputStatusBegin"> Oprettet  </input> <input class="px-2" name="status" type="radio" id="InputstatusProgress"> Under Produktion </input> <input class="px-2" name="status" type="radio" id="InputStatusDone"> Afsluttet </input> <br/>

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
	applyModal();
}

function CreateProductBatch() {
	$("#loaderID").show();
	let productBatchStatus;
	if (document.getElementById("InputStatusBegin").checked == true)
		productBatchStatus = 1;
	else if (document.getElementById("InputstatusProgress").checked == true)
		productBatchStatus = 2;
	else if (document.getElementById("InputStatusDone").checked == true)
		productBatchStatus = 3;

	var productBatch = {
		productBatch_id: $("#InputProductBatchID").val(),
		prescription_id: $("#InputPrescriptionID").val(),
		status: productBatchStatus
	};

	toggleModal();

	$.ajax({
		url: "https://api.mama.sh/ProductBatchs",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(productBatch),
		success: function (response) {
			$("#loaderID").hide();
			getProductBatchList();
			alert("Product Batch Oprettet");
		},
		error: function (data, text, error) {
			$("#loaderID").hide();
			alert("Product Batch ikke oprettet");
		}

	});
}

function getProductBatchList() {
	$("#loaderID").show();
	$.ajax({
		url: "https://api.mama.sh/ProductBatchs",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#ListOfProductBatchTable").html("");
			let html = `<thead>
					<tr>
					<th class="w-1/2 px-4 py-2">Produkt Batch id</th>
					<th class="w-1/2 px-4 py-2">Recept id</th>
					</tr>
					</thead>
					<tbody>`;
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.productBatch_id}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.prescription_id}</span>
				<div class="flex inline-block justify-end px-2">
				<button class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getProductBatch(${item.productBatch_id})">vis</button>
				</div></td>`
				html += `</tr>`;
			});
			console.log(html);
			$("#ListOfProductBatchTable").append(html);

			$("#ListOfProductBatchTable").show();
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			document.getElementById("loaderID").style.display = "none";
			alert(jqXHR.status + text + error+"Produkt Batch liste ikke hentet");
		}
	})
}

async function getProductBatch(id, hasToggleModal = true) {
	$("#loaderID").show();
	showProductModal(hasToggleModal);
	console.log("getuser Started");
	await $.ajax({
		url: "https://api.mama.sh/ProductBatchs/ID/" + id,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#showProductBatchID").text(response.productBatch_id);
			$("#showPrescriptionID").text(response.prescription_id);

			$("#showStartDate").html(new Date(response.startDate).toDateString());
			if (response.endDate <= 0) {
				$("#showEndDate").html("")
			} else {
				$("#showEndDate").html(new Date(response.endDate).toDateString());

			}

			switch (response.status) {
				case 1:
					$("#showInputStatus").text("Oprettet");
					break;
				case 2:
					$("#showInputStatus").text("Under Produktion");
					break;
				case 3:
					$("#showInputStatus").text("Afsluttet");
					break;
			}
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error+" Produkt Batch ikke hentet");
		},
	});
}

function productBatchCompModal(funktion) {
	$("#modal-title").text("Produkt Batch Komponent");
	toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
<label>Produkt Batch id:</label>
<span class=""
	placeholder="" id="ViewProductBatchID"></span> <br />

<label>Råvare id:</label>
<span class=""
	placeholder="" id="ViewCommodityID"></span> <br />

	<label>Bruger id:</label>
<span class=""
	placeholder="" id="ViewUserID"></span> <br />

	<label>Tara:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="ViewTara"></input> <br />

	<label>Netto:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="ViewNetto"></input> <br />

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
	applyModal();
}

function getProductBatchCompList() {
	$("#loaderID").show();
	$.ajax({
		url: "https://api.mama.sh/productbatchcomp",
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#listOfProductsCompTable").html("");
			let html = `<thead>
					<tr>
					<th class="w-1/2 px-4 py-2">Produkt Batch id</th>
					<th class="w-1/2 px-4 py-2">Råvare id</th>
					</tr>
					</thead>
					<tbody>`;
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.productBatch_id}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.commodityBatch_id}</span>
                <div class="flex inline-block justify-end px-2">
				<button class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getOneProductBatchComp(${item.commodityBatch_id}, ${item.productBatch_id})">vis</button>
				</div></td>`
				html += `</tr>`;
			});
			console.log(html);
			$("#listOfProductsCompTable").append(html);

			$("#listOfProductsCompTable").show();
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error+" Produkt Batch komponenter ikke hentet");
		}
	})
}

function getOneProductBatchComp(CommodityID, ProductBatchID) {
	$("#loaderID").show();
	productBatchCompModal("updateProductBatchComp()");
	$.ajax({
		url: "https://api.mama.sh/productbatchcomp/component?productBatchId=" + ProductBatchID + "&commodityBatchId=" + CommodityID,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#ViewProductBatchID").text(response.productBatch_id);
			$("#ViewCommodityID").text(response.commodityBatch_id);
			$("#ViewUserID").text(response.user_id);
			$("#ViewTara").val(response.tara);
			$("#ViewNetto").val(response.netto);
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error+"Produkt Batch komponent ikke hentet");
		},
	});
}

function updateProductBatchComp() {
	$("#loaderID").show();
	toggleModal();
	var productBachComp = {
		productBatch_id: $("#ViewProductBatchID").text(),
		commodityBatch_id: $("#ViewCommodityID").text(),
		user_id: $("#ViewUserID").text(),
		tara: $("#ViewTara").val(),
		netto: $("#ViewNetto").val()
	};

	$.ajax({
		url: "https://api.mama.sh/productbatchcomp",
		contentType: "application/json",
		method: "PUT",
		data: JSON.stringify(productBachComp),
		success: function (response) {
			$("#loaderID").hide();
			alert("Produkt Batch Comp Opdateret");
		},
		error: function (data, text, error) {
			$("#loaderID").hide();
			alert("Produkt Batch Comp ikke opdateret");
		}

	});
}

function getOneCompModal(funktion) {
	$("#modal-title").text("Indtast komponent ID");
	toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
<label>Id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="inputCompId"></input> <br />

</form>`);
	$("#modal-footer").html("");
	$("#modal-footer").append(
		`<div>
					<button
						class="modal-update px-4 bg-transparent p-3 rounded-lg text-indigo-500 hover:bg-gray-100 hover:text-indigo-400 mr-2"
						onclick="${funktion}"> Vis </button>
					<button
						class="modal-close px-4 bg-indigo-500 p-3 rounded-lg text-white hover:bg-indigo-400">Close</button>
				</div>`
	);
	applyModal();
}

function getProductBatchCompListOneBatch() {
	$("#loaderID").show();
	toggleModal();
	let id = $('#inputCompId').val();
	console.log(id);
	$.ajax({
		url: "https://api.mama.sh/productbatchcomp/ID/" + id,
		contentType: "application/json",
		method: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#listOfProductsCompTable").html("");
			let html = `<thead>
					<tr>
					<th class="w-1/2 px-4 py-2">Produkt Batch id</th>
					<th class="w-1/2 px-4 py-2">Råvare id</th>
					</tr>
					</thead>
					<tbody>`;
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.productBatch_id}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.commodityBatch_id}</span>
                <div class="flex inline-block justify-end px-2">
				<button class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getOneProductBatchComp(${item.commodityBatch_id}, ${item.productBatch_id})">vis</button>
				</div></td>`
				html += `</tr>`;
			});

			$("#listOfProductsCompTable").append(html);

			$("#listOfProductsCompTable").show();
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error+"Produkt Batch komponenter ikke hentet");
		}
	});
}

function getCommodityBatchList() {
	$("#loaderID").show();
	elements = [];
	let element;
	console.log("getCommodityBatchList method")
	$.ajax({
		url: 'https://api.mama.sh/commodityBatch',
		contentType: "application/json",
		type: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#listOfCommodityBatchTable").html("");
			let html = `<thead>
					<tr>
					<th class="w-1/2 px-4 py-2">Råvare batch id</th>
					<th class="w-1/2 px-4 py-2">Råvare id</th>
					</tr>
					</thead>
					<tbody>`;
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.commodityBatch_id}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.commodity_id}</span>
						<div class="flex inline-block justify-end px-2">
						<button class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getCommodityBatch(${item.commodityBatch_id})">vis</button>
						</div></td>`
				html += `</tr>`;
			});

			$("#listOfCommodityBatchTable").append(html);

			$("#listOfCommodityBatchTable").show();
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error+" Råvare Batch liste ikke hentet");
		}
	});

}

function commodityBatchModal(funktion) {
	$("#modal-title").text("Råvare Batch");
	toggleModal();
	$("#modal-body").html("");
	$("#modal-body").append(`<form>
<label>Råvare Batch id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="commodityBatch_id-input"></input> <br />

<label>Råvare id:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="commodity_id-input"></input> <br />

	<label>Vægt:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="weight-input"></input> <br />

	<label>Leverandør:</label>
<input class="shadow appearance-none border rounded text-gray-700 py-2 px-3" type="text"
	placeholder="" id="supplier-input"></input> <br />


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
	applyModal();
}

function getCommodityBatch(commodityBatch_id) {
	$("#loaderID").show();
	console.log("getElement method");
	commodityBatchModal(`updateCommodityBatch(${commodityBatch_id})`);
	$.ajax({
		url: 'https://api.mama.sh/commodityBatch/' + commodityBatch_id,
		contentType: "application/json",
		type: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$('#commodityBatch_id-input').val(response.commodityBatch_id);
			$('#commodity_id-input').val(response.commodity_id);
			$('#weight-input').val(response.weight);
			$('#supplier-input').val(response.supplier)
			
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error +" Råvare Batch ikke hentet")
		}
	});

	// To hide other windows og show element information
}

function updateCommodityBatch(commodityBatch_id) {
	$("#loaderID").show();
	let element;

	// Store user input in variables
	let commodity_id = $('#commodity_id-input').val();
	let weight = $('#weight-input').val();
	let supplier = $('#supplier-input').val();

	element = {
		commodityBatch_id: commodityBatch_id,
		commodity_id: commodity_id,
		weight: weight,
		supplier: supplier
	};



	$.ajax({
		url: 'https://api.mama.sh/commodityBatch',
		contentType: "application/json",
		method: 'PUT',
		data: JSON.stringify(element),
		success: function (response) {
			$("#loaderID").hide();
			getCommodityBatchList();
			alert(JSON.stringify(response))
		},
		error: function (jqXHR, textStatus, error) {
			$("#loaderID").hide();
			alert(jqXHR.responseText + textStatus + " Råvare Batch ikke opdateret ")
		}
	});
}

function createCommodityBatch() {
	$("#loaderID").show();
	toggleModal();
	let element;

	// Store user input in variables
	let commodityBatch_id = $('#commodityBatch_id-input').val();
	let commodity_id = $('#commodity_id-input').val();
	let weight = $('#weight-input').val();
	let supplier = $('#supplier-input').val();

	element = {
		commodityBatch_id: commodityBatch_id,
		commodity_id: commodity_id,
		weight: weight,
		supplier: supplier
	};

	$.ajax({
		url: 'https://api.mama.sh/commodityBatch',
		method: 'POST',
		contentType: "application/json",
		data: JSON.stringify(element),
		success: function (response) {
			$("#loaderID").hide();
			alert("Råvare Batch lavet");
			// Display elements
			getCommodityBatchList()
		},
		error: function (jqXHR, textStatus, error) {
			$("#loaderID").hide();
			alert(jqXHR.responseText + textStatus + "Råvare Batch ikke lavet")
		}
	});
}

function getCommodityBatchListByCommodityId() {
	$("#loaderID").show();
	toggleModal();
	let commodity_id = $('#inputCompId').val();
	console.log("getCommodityBatchList method")
	$.ajax({
		url: 'https://api.mama.sh/commodityBatch/list/' + commodity_id,
		contentType: "application/json",
		type: "GET",
		success: function (response) {
			$("#loaderID").hide();
			$("#listOfCommodityBatchListTable").html("");
			let html = `<thead>
					<tr>
					<th class="w-1/2 px-4 py-2">Råvare id</th>
					<th class="w-1/2 px-4 py-2">Råvare Batch id</th>
					</tr>
					</thead>
					<tbody>`;
			jQuery.each(response, (i, item) => {
				html += `<tr>`;
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.commodity_id}</span></td>`
				html += `<td class="border px-4 py-2">  <span class="float-left">${item.commodityBatch_id}</span>
                <div class="flex inline-block justify-end px-2">
				<button class="modal-open bg-purple-600 hover:bg-purple-800 text-white font-bold px-2 py-1 mx-2 rounded float-right" onClick="getCommodityBatch(${item.commodityBatch_id})">vis</button>
				</div></td>`
				html += `</tr>`;
			});
			$("#listOfCommodityBatchListTable").append(html);

			$("#listOfCommodityBatchListTable").show();

		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			alert(jqXHR.status + text + error + " Råvare Batch liste ikke hentet");
		}
	});

}


async function openProductBatch() {
	var productBatchID = $("#ProductBatchToWeight").val();
	await getProductBatch(productBatchID, false);
	//$("#EditProductBatchWindow").hide();

	// Get status for productbatch
	
	var productBatchStatus;
	/*if ($("#InputStatusBegin").is(`:checked`))
		productBatchStatus = "Startet";
	else if ($("#InputstatusProgress").is(`:checked`))
		productBatchStatus = "Underproduktion";
	else
		productBatchStatus = "Afsluttet";*/
	productBatchStatus = $("#showInputStatus").text();
	

	// show productBatch information
	document.getElementById("WeightSumTara").innerHTML = "";
	document.getElementById("WeightSumNetto").innerHTML = "";
	document.getElementById("WeightProductBatchStatus").innerHTML = productBatchStatus;
	document.getElementById("WeightProductBatchStartDate").innerHTML = document.getElementById("showStartDate").innerHTML;
	document.getElementById("WeightProductBatchEndDate").innerHTML = document.getElementById("showEndDate").innerHTML;

	var presID = $("#showPrescriptionID").html();
	await getPrescription(presID);
	$("#WeightPrescriptionID").html(presID);
	getPrescriptionCompList(presID, productBatchID);
	//document.getElementById("WeightPrescriptionName").innerHTML = ;
}

function WeightPrint() {
	// 2 linjer taget fra nettet "https://tecadmin.net/get-current-date-time-javascript/"
	var today = new Date();
	var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();

	$("#PrintDate").html("Udskrevet: " + date);
	$("#PrintDate").show();
	$("#OpenProductBtn").hide();
	$("#PrintBtn").hide();

	window.print();


	$("#PrintDate").hide();
	$("#OpenProductBtn").show();
	$("#PrintBtn").show();
}

async function CreateProductBatchComp(commodityID, number) {
	$("#loaderID").show();
	// work in progress
	var productBatchID = $('#ProductBatchToWeight').val();

	var productbatchcomp = {
		productBatch_id: productBatchID,
		commodityBatch_id: commodityID, //$('#WeightCommodityID').val(),
		user_id: userobject.userID, // add current user
		tara: $("#WeightTara" + commodityID).val(),
		netto: $("#WeightNetto" + commodityID).val(),
	};

	// setup for weight tolerance
	var weightLineNonNetto = $('#WeightLineNonNetto' + number).html();
	var WeightLineTolerance = $('#WeightLineTolerance' + number).html();
	console.log(weightLineNonNetto + ', ' + WeightLineTolerance);

	// get the tollance weight
	let minWeightTolerance = weightLineNonNetto * (1- (WeightLineTolerance/100));
	let maxWeightTolerance = weightLineNonNetto * (1+ (WeightLineTolerance/100));

	// test for variable
	console.log(minWeightTolerance + ' , ' + maxWeightTolerance);

	// test if weight is acceptable
	if (minWeightTolerance < productbatchcomp.netto && maxWeightTolerance > productbatchcomp.netto) {
		console.log("Netto weight: good to go");

		await $.ajax ({
			url: "https://api.mama.sh/productbatchcomp",
			contentType: "application/json",
			type: "POST",
			data : JSON.stringify(productbatchcomp),
			success : function (response) {
				$("#loaderID").hide();
				alert("ProductBatch Comp has been added");
			},
			error: function (jqXHR, text, error) {
				$("#loaderID").hide();
				alert(jqXHR.status + text + error);
				console.log(productbatchcomp);

			}

		});

		console.log("Not skipped!");

		UpdateToSubmitedProductBatchComp(productBatchID, commodityID, number);

	}
	else {
		$("#loaderID").hide();
		alert("Netto vægt ikke inden for tolerancen");
		console.log("Netto weight: not accepted");
	}


}

async function ShowPrescriptionCompToLab(PrescriptionComp, number, productBatchID) {
	var commoditybatchList = document.getElementById("WeightCommodityBatchList");
	var isShown = "none";
	
	
	await getCommodity(PrescriptionComp.commodity_id);
	
	
	

	if (number == 1) {
		isShown = "block";
	}

	var commodityName = $("#showRåvareNavn").val();

	commoditybatchList.innerHTML += '<div > '
		+ ' <h5>Råvare nr: <label id="WeightCommodityID">'+ PrescriptionComp.commodity_id+'</label></h5> '
		+ '<h5>Råvare Navn: ' + commodityName + '</h5> '
		+ ' <table id="ListOfProductBatchTable" class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white"> '
		+ ' <tr> '
		+ '<td>Del</td> '
		+ '<td>Mængde</td>'
		+ '<td>Tolerance</td>'
		+ '<td>Tara</td>'
		+ '<td>Netto (kg)</td>'
		+ '<td>Batch</td>'
		+ '<td>Opr</td>'
		+ '<td>Terminal</td>'
		+ '</tr>'
		+ '<tr >'
		+ '<td>1</td>'
		+ '<td id="WeightLineNonNetto' + number + '">' + PrescriptionComp.nomNetto +'</td>'
		+ '<td id="WeightLineTolerance' + number + '">' + PrescriptionComp.tolerance + '</td>'
		+ '<td id="WeightLineTara' + number + '"><input type="text" id="WeightTara' + PrescriptionComp.commodity_id +'"></input></td>'
		+ '<td id="WeightLineNetto' + number + '"><input type="text" id="WeightNetto' + PrescriptionComp.commodity_id + '"></input></td>'
		+ '<td id="WeightLineBatch' + number + '"><input type="text"></input></td>'
		+ '<td id="WeightLineOpr' + number + '">' + userobject.userID + '</input></td>'
		+ '<td id="WeightLineTerminal' + number + '">1</td>'
		+ '</tr>'
		+ '</table>'
		+ '<br>'
		+ '<button style="display: ' + isShown +';" id="WeightSubmitBtn' + number +'" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 border border-blue-700 rounded" onclick="CreateProductBatchComp('+ PrescriptionComp.commodity_id+',' + number + ');"> submit Råvare: ' + PrescriptionComp.commodity_id + '</button>'
		+ '</div> <br/>';

		
		//$(document).ready( function () {toggleModal();});
	UpdateToSubmitedProductBatchComp(productBatchID, PrescriptionComp.commodity_id, number);

}

function UpdateToSubmitedProductBatchComp(productBatchID,commodityID,number) {
	$("#loaderID").show();
	console.log("starting update");

	$.ajax ({
		url: "https://api.mama.sh/productbatchcomp/component?productBatchId=" + productBatchID + "&commodityBatchId=" + commodityID,
		contentType: "application/json",
		type: "GET",
		success : function (response) {
			$("#WeightLineTara" + number).html(response.tara);
			$("#WeightLineNetto" + number).html(response.netto);
			$("#WeightLineBatch" + number).html(response.commodityBatch_id);
			$("#WeightLineOpr" + number).html(response.user_id);
			$("#WeightLineTerminal" + number).html(1);


			// show and hide button stuff
			console.log("started to show BTN");
			$("#WeightSubmitBtn" + number).hide();
			console.log("End og BTN")
			// end of document ready

			// test for last button
			try {
				document.getElementById("WeightSubmitBtn" + (number + 1)).style.display = "block";
			}
			catch { // end of commodity to productbatch
				console.log ("done!");

				// get all netto and tara weight
				var weightNettoTotal = 0;
				var weightTaraTotal = 0;

				for (let index = 1; index <= number; index++) {
					// test stuff
					console.log(Number($('#WeightLineTara' + index).html()));
					console.log($('#WeightLineTara' + index).html());
					console.log(Number($('#WeightLineNetto' + index).html()));
					console.log($('#WeightLineNetto' + index).html());

					weightTaraTotal += Number($('#WeightLineTara' + index).html());

					weightNettoTotal += Number($('#WeightLineNetto' + index).html());
				}
				console.log('Tara Total: ' + weightTaraTotal + ', Netto Total: ' + weightNettoTotal);

				// print to screen
				$('#WeightSumTara').html(weightTaraTotal);
				$('#WeightSumNetto').html(weightNettoTotal);

				// update status to "Afsluttet" and update end date
				updateProductBatchToFinish();
				$("#loaderID").hide();
			}
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			//  alert(jqXHR.status + text + error);
			console.log("Doenst exit in database");
		}




		// end of document ready
	});
}

function getPrescriptionCompList(prescriptionID, productBatchID) {
	$("#loaderID").show();
	$.ajax ( {
		url: "https://api.mama.sh/PrescriptionComp/" + prescriptionID,
		contentType: "application/json",
		type: "GET",
		success: function (response) {
			$("#loaderID").hide();
			var number = 0;
			document.getElementById("WeightCommodityBatchList").innerHTML = "";
			response.forEach(prescriptionComp => {
				number++;
				ShowPrescriptionCompToLab(prescriptionComp, number, productBatchID);

			})
		},
		error: function (jqXHR, text, error) {
			$("#loaderID").hide();
			console.log(jqXHR.status + text + error);
		}
	});
}


async function login() {

	var id = $("#LoginUserID").val();

	await getUser(id, true);

	var statusTemp = 0;
	if ($("#ShowUserStatus").is(':checked')) {
		statusTemp = 1;
	}

	let userRoles = [];

	if ($("#ShowUserRolesAdmin").is(':checked')) {
		userRoles.push("Admin");
	}
	if ($("#ShowUserRolesFarma").is(':checked')) {
		userRoles.push("Pharmaceut");
	}
	if ($("#ShowUserRolesProductionleader").is(':checked')) {
		userRoles.push("Produktionsleder");
	}
	if ($("#ShowUserRolesLab").is(':checked')) {
		userRoles.push("Laborant");
	}


	userobject = {
		// set user status

		userID: $("#ShowUserID").val(),
		firstName: 	$("#ShowUserFirstName").val(),
		surname: $("#ShowUserLastName").val(),
		cpr: $("#ShowUserCPR").val(),
		initials: $("#ShowUserIniTxt").val(),
		roles: userRoles,

		// Adding status
		status: statusTemp
	};
	//$("#userIDInsert").content = $("#ShowUserID").value;
	console.log(userobject);
	
	// console.log("ready function");
	if (!($("#ShowUserID").val() === "") && $("#ShowUserStatus").is(':checked')) {
		console.log("du kan logge ind");
		$("#loginContainer").hide();
		//$("#logoutBtn").style.display = "block";
		// admin portal
		if ($("#ShowUserRolesAdmin").is(':checked')) {
			// user portal
			AdminAccess();
		}

		// Pharmaceut portal
		if ($("#ShowUserRolesFarma").is(':checked')) {
			//Commodity
			// Prescriptions and prescription components
			// and produktionsleder access
			PharmaceutAccess();
		}

		// Producktion leader
		if ($("#ShowUserRolesProductionleader").is(':checked')) {
			// commodity batches
			// productbatches
			// and has Lab guy access
			ProductionleaderAccess();
		}

		// Lab guy
		if ($("#ShowUserRolesLab").is(':checked')) {
			// weight access
			LabAccess();
		}

	} else {
		console.log("Du kan ikke logge ind i systemet");
	}
}

function LabAccess() {
	$("#WeightPortal").show();
}

function ProductionleaderAccess() {
	$("#ProductBatchPortal").show();
	$("#CommodityBatchPortal").show();
	LabAccess();
}

function PharmaceutAccess() {
	// TODO: needs to be fixed
	//Commodity
	// Prescriptions and prescription components
	// and produktionsleder access
	$("#CommodityBatchPortal").show();
	$("#CommodityPortal").show();
	ProductionleaderAccess();
}

function AdminAccess() {
	$("#AdminPortal").show();
}

function logout() {
	$("#AdminPortal").show();
	$("#CommodityPortal").show();
	$("#CommodityBatchPortal").show();

	$("#ProductBatchPortal").show();
	$("#WeightPortal").show();

//	$("#logoutBtn").show();
}
// setTimeout(

function updateProductBatchToFinish() {
	$("#loaderID").show();

		var today = new Date();
	
		var productBatch = { 
			prescription_id: $("#showPrescriptionId").val(),
			productBatch_id: $("#ProductBatchToWeight").val(),
			status: 3,
	//		startDate: 1,
	//		endDate: 1
		};
	
		$.ajax ({
			url: "https://api.mama.sh/ProductBatchs",
			contentType: "application/json",
			method: "PUT",
			data: JSON.stringify(productBatch),
			success: function (response) {
				$("#loaderID").hide();
				getProductBatch(productBatch.productBatch_id, true);
			},
			error: function (data, text, error) {
				$("#loaderID").hide();
				console.log("fejl: Produkt Batch ikke opdateres");
			}
	
		});
}