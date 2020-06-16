function createUser() {
    const user = {
        userID: $("#CreateUserID").val(),
        firstName: $("#CreateUserFirstName").val(),
        surname: $("#CreateUserLastName").val(),
        cpr: $("#CreateUserCPR").val(),
        initials: $("#CreateUserIniTxt").val(),

        // adding roles
        roles: function () {
            var arr = [];
            if ($("#CreateUserRolesAdmin").checked == true)
                arr.push("Administrator");

            if ($("#CreateUserFarma").checked == true)
                arr.push("Farmaceut");

            if ($("#CreateUserRolesProductionleader").checked == true)
                arr.push("Produktionsleder");

            if (($("#CreateUserRolesLab").checked == true))
                arr.push("Laborant");

            return arr;
        },

        // Adding status
        status: function () {
            if ($("#CreateUserStatus").checked == true)
                return "1";
            else 
                return "0";
        }
      };

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
          html += `<td><button class="w3-dark-grey list-item-btn"> ${getStatus(item.status)} <i class="fa fa-close"></i></button> <button onclick="getUser(${item.userID});" id="EditBtn" class="w3-dark-grey list-item-btn">Vis <i class="fa fa-cog fa-fw"></i></button></td>`;
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
            $("#ShowUserStatus").checked = false;
          }
          else {
            $("#ShowUserStatus").checked = true;
          }

          // Show user roles
          for (const role in response.roles) {
              if (role == "Administrator") {
                $("#ShowUserRolesAdmin").checked = true;
              }
              else if (role == "Farmaceut") {
                $("#ShowUserRolesFarma").checked = true;
              }
              else if (role == "Produktionsleder") {
                $("#ShowUserRolesProductionleader").checked = true;
              }
              else if (role == "Laborant") {
                $("#ShowUserRolesLab").checked = true;
              }
          }
          
        },
        error: function (jqXHR, text, error) {
          document.getElementById("loaderID").style.display = "none";
          alert(jqXHR.status + text + error);
        },
      });
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
        return "inaktiver";
    }
}