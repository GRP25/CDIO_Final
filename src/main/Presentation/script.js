function createUser() {
    var userID;
    var firstName;
    var surname;
    var cpr;
    var initials;
    var roles;
    var status;


    var xhttp = new XMLHttpRequest;
    xhttp.open("GET", "/api/users");
    xhttp.send();

}

function listUser() {
    
}

function printUserToTable(id, name, status) {
    return "<tr><td>" + id + "  " + name + "</td><td><button class=" +'"w3-dark-grey list-item-btn">' + getStatus(status); ' <i class="fa fa-close"></i></button> <button id="EditBtn" class="w3-dark-grey list-item-btn">Updater <i class="fa fa-cog fa-fw"></i></button></td></tr>';
   // document.getElementById("ListOfUsersTable").innerHTML = "<tr><td> My new user</td></tr>";
}

function getStatus(status) {
    if (status == 1) {
        return "aktiver";
    }
    else {
        return "inaktiver";
    }
}