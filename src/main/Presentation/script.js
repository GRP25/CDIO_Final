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

function getProductBatchListWithID(){
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
        },
        error: function (jqXHR, text, error) {
            document.getElementById("loaderID").style.display = "none";
            alert(jqXHR.status + text + error);
        },
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

    // Get status for productbatch
    var productBatchStatus;
    if (document.getElementById("EditInputStatusBegan").checked == true)
        productBatchStatus = "Startet";
    else if (document.getElementById("EditInputstatusProgress").checked == true)
        productBatchStatus = "Underproduktion";
    else
        productBatchStatus = "Afsluttet";

    // show productBatch information
    document.getElementById("WeightSumTara").innerHTML = "";
    document.getElementById("WeightSumNetto").innerHTML = "";
    document.getElementById("WeightProductBatchStatus").innerHTML = productBatchStatus;
    document.getElementById("WeightProductBatchStartDate").innerHTML = document.getElementById("EditStartDate").innerHTML;
    document.getElementById("WeightProductBatchEndDate").innerHTML = document.getElementById("EditEndDate").innerHTML;

    var presID = document.getElementById("EditPrescriptionID").value;
    await getPrescription(presID);
    document.getElementById("WeightPrescriptionID").innerHTML = presID;
    getPrescriptionCompList(presID, productBatchID);
    //document.getElementById("WeightPrescriptionName").innerHTML = ;
}

async function getPrescriptionCompList(prescriptionID, productBatchID) {

    await $.ajax ( {
        url: "https://api.mama.sh/PrescriptionComp/" + prescriptionID,
        contentType: "application/json",
        type: "GET",
        success: function (response) {
            var number = 0;
            document.getElementById("WeightCommodityBatchList").innerHTML = "";
            response.forEach(prescriptionComp => { 
                number++;
                ShowPrescriptionCompToLab(prescriptionComp, number, productBatchID);
                
            })
        },
        error: function (jqXHR, text, error) {
            alert(jqXHR.status + text + error);
        }
    });
}

async function ShowPrescriptionCompToLab(PrescriptionComp, number, productBatchID) {
    var commoditybatchList = document.getElementById("WeightCommodityBatchList");
    var isShown = "none";

    if (number == 1) {
        isShown = "block";
    }

    commoditybatchList.innerHTML += '<div class="w3-container"> ' 
                                + ' <h5>Råvare nr: <label id="WeightCommodityID">'+ PrescriptionComp.commodity_id+'</label></h5> '
                                + '<h5>Råvare Navn: <label>Implement commodity name</label></h5> '
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
                                + '<td id="WeightLineOpr' + number + '"><input type="text"></input></td>'
                                + '<td id="WeightLineTerminal' + number + '"><input type="text"></input></td>'
                                + '</tr>'
                                + '</table>'
                                + '<br>'
                                + '<button style="display: ' + isShown +';" id="WeightSubmitBtn' + number +'" onclick="CreateProductBatchComp('+ PrescriptionComp.commodity_id+',' + number + ');"> submit Råvare: ' + PrescriptionComp.commodity_id + '</button>'
                                + '</div>';
    
    await UpdateToSubmitedProductBatchComp(productBatchID, PrescriptionComp.commodity_id, number);
}

async function CreateProductBatchComp(commodityID, number) {
    // work in progress
    var productBatchID = $('#ProductBatchToWeight').val();

    var productbatchcomp = {
        productBatch_id: productBatchID,
        commodityBatch_id: commodityID, //$('#WeightCommodityID').val(),
        user_id: 1, // add current user
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
                alert("ProductBatch Comp has been added");
            },
            error: function (jqXHR, text, error) {
                alert(jqXHR.status + text + error);
                console.log(productbatchcomp);
                
            }
        
        });
    
        console.log("Not skipped!");
        
        await UpdateToSubmitedProductBatchComp(productBatchID, commodityID, number);
        
    }
    else {
        alert("Netto vægt ikke inden for tolerancen");
        console.log("Netto weight: not accepted");
    }
    

}

async function UpdateToSubmitedProductBatchComp(productBatchID,commodityID,number) {
    
    console.log("starting update");
    
    await $.ajax ({
        url: "https://api.mama.sh/productbatchcomp/component?productBatchId=" + productBatchID + "&commodityBatchId=" + commodityID,
        contentType: "application/json",
        type: "GET",
        success : function (response) {
            document.getElementById("WeightLineTara" + number).innerHTML = response.tara;
            document.getElementById("WeightLineNetto" + number).innerHTML = response.netto;
            document.getElementById("WeightLineBatch" + number).innerHTML = response.commodityBatch_id;
            document.getElementById("WeightLineOpr" + number).innerHTML = response.user_id;
            document.getElementById("WeightLineTerminal" + number).innerHTML = 1;
            
        },
        error: function (jqXHR, text, error) {
          //  alert(jqXHR.status + text + error);
            console.log("Doenst exit in database");
        }
    });

        
    $( document ).ready(function() {
        console.log("started to show BTN");
        document.getElementById("WeightSubmitBtn" + number).style.display = "none";
        console.log("End og BTN")
            // end of document ready
    });

    $( document ).ready(function() {
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
    }
         // end of document ready
        });
}

function WeightPrint() {
    var today = new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();

    document.getElementById("PrintDate").innerHTML = "Udskrevet: " + date;
    document.getElementById("PrintDate").style.display = "block";
    document.getElementById("OpenProductBtn").style.display = "none";
    document.getElementById("PrintBtn").style.display = "none";

    window.print();

    document.getElementById("PrintDate").style.display = "none";
    document.getElementById("OpenProductBtn").style.display = "inline";
    document.getElementById("PrintBtn").style.display = "inline";
}
