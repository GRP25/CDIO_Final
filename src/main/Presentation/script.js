/*
// event liseners
$(document).ready(function () {
    $("#CreateUserClose").click (() => {
        createUser();
    });
});
*/

function ajaxtest() {
    const user = "hej";
 //   event.preventDefault();
    $.ajax ({
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
      })
}


function createUser() {
    let userRoles = [];//function () {
        //if ($("#CreateUserRolesAdmin").checked == true) {
        if(document.getElementById("CreateUserRolesAdmin").checked == true)
            userRoles.push("Admin");
        if (document.getElementById("CreateUserFarma").checked == true)
            userRoles.push("Pharmaceut");

        if (document.getElementById("CreateUserRolesProductionleader").checked == true)
            userRoles.push("Produktionsleder");

        if (document.getElementById("CreateUserRolesLab").checked == true)
            userRoles.push("Laborant");


        
        // Getting user status
        var userStatus;
        if (document.getElementById("CreateUserStatus").checked == true)
          userStatus = "1";
        else
          userStatus = "0";
      
    //console.log(userRoles);
/*//    console.log($("#CreateUserID").val());
  //  console.log($("#CreateUserFirstName").val());
  //  console.log($("#CreateUserLastName").val());
  //  console.log($("#CreateUserCPR").val());
  //  console.log($("#CreateUserIniTxt").val());*/
    var user = {
        
      //  userID: $("#CreateUserID").val(),
        firstName: $("#CreateUserFirstName").val(),
        surname: $("#CreateUserLastName").val(),
        cpr: $("#CreateUserCPR").val(),
        initials: $("#CreateUserIniTxt").val(),
        roles: userRoles,

        // Adding status
        status: userStatus
      };
/*
  // test values
      var roles = ["Admin", "Pharmaceut"];
      var user = {
      firstName: "thomas",
      surname: "tobias",
      initials: "MN",
      cpr: "1102924440",
      status: 1,
      roles: roles,
    };  */
    

      $.ajax ({
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

function updateUser() {
  let userRoles = [];//function () {
    //if ($("#CreateUserRolesAdmin").checked == true) {
    if(document.getElementById("ShowUserRolesAdmin").checked == true)
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

function sendUpdateToServer(user) {
  $.ajax ({
    url: "https://api.mama.sh/userresource",
    contentType: "application/json",
    method: "PUT",
    data: JSON.stringify(user),
    success: function (response) {
        alert("Bruger Opdateret");            
    },
    error: function (data, text, error) {
        alert("fejl: bruger ikke opdateres");
    }
    
  });
}

function listUsers() {
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
          html += `<td> ${item.userID} | ${item.firstName} ${item.surname} | ${item.roles}</td>`;
          html += `<td><button class="w3-dark-grey list-item-btn" onclick="inactiveUser(${item.userID}, ${item.status});"> ${getStatus(item.status)} <i class="fa fa-close"></i></button> <button onclick="getUser(${item.userID});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
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
    });
  
   // $("#list").show();  
}

async function getUser(id, showBox=true) {
    console.log("getuser Started");
    await $.ajax({
        url: "https://api.mama.sh/userresource/" + id,
        contentType: "application/json",
        method: "GET",
        success: function (response) {
          if (showBox == true) {
            document.getElementById("EditUserWindow").style.display = "block";
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

      /*    // Show user roles
          for (const role in response.roles) {
              if (role === "Admin") {
                $("#ShowUserRolesAdmin").prop('checked', true);
              }
              else if (role === "Farmaceut") {
                $("#ShowUserRolesFarma").prop('checked', true);
              }
              else if (role.localeCompare("Produktionsleder")) {
                $("#ShowUserRolesProductionleader").prop('checked', true);
              }
              else if (role === "Laborant") {
                $("#ShowUserRolesLab").prop('checked', true);
              }
          }  */

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
    if (state == 1) {
        $.ajax({
            url: "https://api.mama.sh/userresource/" + id,
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
        getUser(id, false);
        document.getElementById("ShowUserStatus").checked = true;
        updateUser();
   }
}

function printUserToTable(id, name, status) {
    return "<tr><td>" + id + "  " + name + "</td><td><button class=" +'"w3-dark-grey list-item-btn">' + getStatus(status); ' <i class="fa fa-close"></i></button> <button id="EditBtn" class="w3-dark-grey list-item-btn">Opdater <i class="fa fa-cog fa-fw"></i></button></td></tr>';
   // document.getElementById("ListOfUsersTable").innerHTML = "<tr><td> My new user</td></tr>";
}

function getStatus(status) {
    if (status == 0) {
        return "aktiver";
    }
    else {
        return "deaktiver";
    }
}

/**************** *
 * ProductBatch   *
 **************** */

function CreateProductBatch() {

    let productBatchStatus;
    if(document.getElementById("InputStatusBegin").checked == true)
        productBatchStatus = 1;
    else if(document.getElementById("InputstatusProgress").checked == true)
        productBatchStatus = 2;
    else if (document.getElementById("InputStatusDone").checked == true)
        productBatchStatus = 3;

    var productBatch = {
        productBatch_id: $("#CreateProductBatchID").val(),
        prescription_id: $("#InputPrescriptionID").val(),
        status: productBatchStatus
    };

    $.ajax ({
        url: "https://api.mama.sh/ProductBatchs",
        contentType: "application/json",
        method: "POST",
        data: JSON.stringify(productBatch),
        success: function (response) {
            alert("Product Batch Oprettet");
        },
        error: function (data, text, error) {
            alert("Error: Product Batch ikke oprettet");
        }

    });
}

function getProductBatchList() {
    $.ajax({
        url: "https://api.mama.sh/ProductBatchs",
        contentType: "application/json",
        method: "GET",
        success: function (response) {
            $("#ListOfProductBatchTable").html("");
            var html = "";
            jQuery.each(response, (i, item) => {
                html += `<tr>`;
                html += `<td><h5>Produkt Bacth ID</h5> ${item.productBatch_id} <h5>Prescription ID </h5> ${item.prescription_id}</td>`;
                html += `<td><button onclick="getProductBatch(${item.productBatch_id});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
                html += `</tr>`;
            });
            console.log(html);
            $("#ListOfProductBatchTable").append(html);

            $("#ListOfProductBatchTable").show();
        },
        error: function (jqXHR, text, error) {
            document.getElementById("loaderID").style.display = "none";
            alert(jqXHR.status + text + error);
        }
    })
}

function updateProductBatch() {

    let productBatchStatus;
    if(document.getElementById("EditInputStatusBegin").checked == true)
        productBatchStatus = 1;
    else if(document.getElementById("EditInputstatusProgress").checked == true)
        productBatchStatus = 2;
    else if (document.getElementById("EditInputStatusDone").checked == true)
        productBatchStatus = 3;

    var productBatch = {
        productBatch_id: $("#EditProductBatchID").text(),
        prescription_id: $("#EditPrescriptionID").val(),
        status: productBatchStatus
    };

    $.ajax ({
        url: "https://api.mama.sh/ProductBatchs",
        contentType: "application/json",
        method: "PUT",
        data: JSON.stringify(productBatch),
        success: function (response) {
            alert("Produkt Batch Opdateret");
        },
        error: function (data, text, error) {
            alert("fejl: Produkt Batch ikke opdateres");
        }

    });
}

async function getProductBatch(id) {
    console.log("getuser Started");
    await $.ajax({
        url: "https://api.mama.sh/ProductBatchs/ID/"+id,
        contentType: "application/json",
        method: "GET",
        success: function (response) {
            document.getElementById("EditProductBatchWindow").style.display = "block";
            $("#EditProductBatchID").text(response.productBatch_id);
            $("#EditPrescriptionID").val(response.prescription_id);
            $("#EditStartDate").html(new Date(response.startDate).toDateString());
            if(response.endDate <= 0){
                $("#EditEndDate").html("")
            } else {
                $("#EditEndDate").html(new Date(response.endDate).toDateString());

            }

            switch(response.status){
                case 1:
                    $("#EditInputStatusBegin").prop('checked', true);
                    break;
                case 2:
                    $("#EditInputstatusProgress").prop('checked', true);
                    break;
                case 3:
                    $("#EditInputStatusDone").prop('checked', true);
                    break;
            }
            return response.productBatch_id;
        },
        error: function (jqXHR, text, error) {
            document.getElementById("loaderID").style.display = "none";
            alert(jqXHR.status + text + error);
        },
    });
}

function getProductBatchCompList() {
    $.ajax({
        url: "https://api.mama.sh/productbatchcomp",
        contentType: "application/json",
        method: "GET",
        success: function (response) {
            $("#ListOfProductBatchCompTable").html("");
            var html = "";
            jQuery.each(response, (i, item) => {
                html += `<tr>`;
                html += `<td><h5>Produkt Bacth ID</h5> ${item.productBatch_id} <h5>Råvare ID </h5> ${item.commodityBatch_id}</td>`;
                html += `<td><button onclick="getOneProductBatchComp(${item.commodityBatch_id},${item.productBatch_id});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
                html += `</tr>`;
            });
            console.log(html);
            $("#ListOfProductBatchCompTable").append(html);

            $("#ListOfProductBatchCompTable").show();
        },
        error: function (jqXHR, text, error) {
            document.getElementById("loaderID").style.display = "none";
            alert(jqXHR.status + text + error);
        }
    })
}

function getOneProductBatchComp(CommodityID, ProductBatchID) {
    $.ajax({
        url: "https://api.mama.sh/productbatchcomp/component?productBatchId="+ProductBatchID+"&commodityBatchId="+CommodityID,
        contentType: "application/json",
        method: "GET",
        success: function (response) {
            document.getElementById("ViewProductBatchCompWindow").style.display= "block";
            $("#ViewProductBatchID").text(response.productBatch_id);
            $("#ViewCommodityID").val(response.commodityBatch_id);
            $("#ViewUserID").val(response.user_id);
            $("#ViewTara").val(response.tara);
            $("#ViewNetto").val(response.netto);
        },
        error: function (jqXHR, text, error) {
            document.getElementById("loaderID").style.display = "none";
            alert(jqXHR.status + text + error);
        },
    });
}

function getProductBatchCompListOneBatch(id) {
    $.ajax({
        url: "https://api.mama.sh/productbatchcomp/ID/"+id,
        contentType: "application/json",
        method: "GET",
        success: function (response) {
            $("#ListOfOneProductBatchTable").html("");
            var html = "";
            jQuery.each(response, (i, item) => {
                html += `<tr>`;
                html += `<td><h5>Produkt Bacth ID</h5> ${id}</td>`;
                html += `<td><button onclick="getOneProductBatchComp(${item.commodity_id},${id});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
                html += `</tr>`;
            });
            $("#ListOfOneProductBatchTable").append(html);

            $("#ListOfOneProductBatchTable").show();
        },
        error: function (jqXHR, text, error) {
            document.getElementById("loaderID").style.display = "none";
            alert(jqXHR.status + text + error);
        }
    });
}

function updateProductBatchComp(){
    var productBachComp = {
        productBatch_id: $("#ViewProductBatchID").text(),
        commodityBatch_id: $("#ViewCommodityID").val(),
        user_id: $("#ViewUserID").val(),
        tara: $("#ViewTara").val(),
        netto: $("#ViewNetto").val()
    };

    $.ajax ({
        url: "https://api.mama.sh/productbatchcomp",
        contentType: "application/json",
        method: "PUT",
        data: JSON.stringify(productBachComp),
        success: function (response) {
            alert("Produkt Batch Opdateret");
        },
        error: function (data, text, error) {
            alert("fejl: Produkt Batch ikke opdateres");
        }

    });
}

/**************** *
 * CommodityBatch *
 **************** */
function getCommodityBatch(id) {
    console.log("getCommodityBatch method")
    $.ajax({
        url  : 'REST/Resources/commodityBatch/' + commodityBatch_id,
        contentType : "application/json",
        type : "GET",
        success : function (response) {
            document.getElementById('modal-add').style.display = 'none'
            $('#commodityBatch_id-input').val(response.commodityBatch_id)
            $('#commodity_id-input').val(response.commodity_id)
            $('#weight-input').val(response.weight)
            $('#supplier-input').val(response.supplier)
        },
        error: function (jqXHR, text, error) {  
            alert(jqXHR.status + text + error);
        }
    });
}

function getCommodityBatchList() {
    console.log("getCommodityBatchList method")
    $.ajax({
        url  : 'REST/Resources/commodityBatch',
        contentType : "application/json",
        type : "GET",
        success : function (response) {

        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }
    });
}

function getCommodityBatchList(commodityBatch_id) {
    console.log("getCommodityBatchList method")
    $.ajax({
        url  : 'REST/Resources/commodityBatch/list/' + commodityBatch_id,
        contentType : "application/json",
        type : "GET",
        success : function (response) {

        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }
    });
}

function createCommodityBatch() {
    let data = [
        {
            commodityBatch_id: $('#commodityBatch_id-input').val(),
            commodity_id: $('#commodity_id-input').val(),
            weight: $('#weight-input').val(),
            supplier: $('#supplier-input')
        }
    ];

    console.log("createCommodityBatch method")
    $.ajax( {
        url : 'REST/Resources/commodityBatch',
        contentType : "application/json",
        type : "POST",
        data : JSON.stringify(data),
        success : function (response) {
            alert("CommodityBatch is being created")
        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }

    });
}

function updateCommodityBatch() {
    let data = [
        {
            commodityBatch_id: $('#commodityBatch_id-input').val(),
            commodity_id: $('#commodity_id-input').val(),
            weight: $('#weight-input').val(),
            supplier: $('#supplier-input')
        }
    ];

    console.log("createCommodityBatch method")
    $.ajax( {
        url : 'REST/Resources/commodityBatch',
        contentType : "application/json",
        type : "PUT",
        data : JSON.stringify(data),
        success : function (response) {
            alert("CommodityBatch is being created")
        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }

    });
}



async function getPrescription(id) {
    await $.ajax ({
        url: "https://api.mama.sh/Prescriptions/ID/" + id,
        contentType: "application/json",
        type: "GET",
        success: function (response) {
            // CAN be changed to another value when the admin portal has been added !!!
            // Just can the openProductBatch() to match the new id;
            $("#WeightPrescriptionName").text(response.prescription_name);
            console.log(response.prescription_name);
            
        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }
    });
}

async function openProductBatch() {
    var productBatchID = document.getElementById("ProductBatchToWeight").value;
    await getProductBatch(productBatchID);
    document.getElementById("EditProductBatchWindow").style.display = "none";

    var presID = document.getElementById("EditPrescriptionID").value;
    await getPrescription(presID);
    document.getElementById("WeightPrescriptionID").innerHTML = presID;
    getPrescriptionCompList(presID);
    //document.getElementById("WeightPrescriptionName").innerHTML = ;
}

function getPrescriptionCompList(prescriptionID) {
    $.ajax ( {
        url: "https://api.mama.sh/PrescriptionComp/" + prescriptionID,
        contentType: "application/json",
        type: "GET",
        success: function (response) {
            response.forEach(prescriptionComp => { 

                ShowPrescriptionCompToLab(prescriptionComp);
            })
        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }
    });
}

function ShowPrescriptionCompToLab(PrescriptionComp) {
    var commoditybatchList = document.getElementById("WeightCommodityBatchList");

    commoditybatchList.innerHTML += '<div class="w3-container"> ' 
                                + ' <h5>Råvare nr: <label>'+ PrescriptionComp.commodity_id+'</label></h5> '
                                + '<h5>Råvare Navn: <label>Vand</label></h5> '
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
                                + '<tr>'
                                + '<td>1</td>'
                                + '<td>' + PrescriptionComp.nomNetto +'</td>'
                                + '<td>' + PrescriptionComp.tolerance + '</td>'
                                + '<td><input type="text"></input></td>'
                                + '<td><input type="text"></input></td>'
                                + '<td><input type="text"></input></td>'
                                + '<td><input type="text"></input></td>'
                                + '<td><input type="text"></input></td>'
                                + '</tr>'
                                + '</table>'
                                + '<br>'
                                + '</div>';

}