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
        
        userID: $("#CreateUserID").val(),
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


  var user = {
        
    userID: $("#ShowUserID").val(),
    firstName: $("#ShowUserFirstName").val(),
    surname: $("#ShowUserLastName").val(),
    cpr: $("#ShowUserCPR").val(),
    initials: $("#ShowUserIniTxt").val(),
    roles: userRoles,

    // Adding status
    status: function () {
        if ($("#ShowUserStatus").checked == true)
            return 1;
        else 
            return 0;
    },         
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
    });
  
   // $("#list").show();  
}

function getUser(id) {
    console.log("getuser Started");
    $.ajax({
        url: "https://api.mama.sh/userresource/" + id,
        contentType: "application/json",
        method: "GET",
        success: function (response) {
          document.getElementById("EditUserWindow").style.display = "block";
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
          
        },
        error: function (jqXHR, text, error) {
          document.getElementById("loaderID").style.display = "none";
          alert(jqXHR.status + text + error);
        },
      });
}

function inactiveUser(id) {
  /*  if (state === "deaktiver") { */
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
 /*   }
   else {
       // use the update function
   }*/
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

