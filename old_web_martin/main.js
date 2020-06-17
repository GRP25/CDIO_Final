$(document).ready(function () {
  $("#crbtn").click(() => {
      saveUser();
  });
  function saveUser() {
    var roles = ["Admin"];
    var user = {
      firstName: "Martin",
      surname: "Nitram",
      initials: "MN",
      cpr: "1102924444",
      status: 1,
      roles: roles,
    };

  $.ajax({
    url: "https://api.mama.sh/userresource",
    type: "POST",
    data: JSON.stringify(user),
    contentType: "application/json",
    success: function (msg) {
        console.log("GODKENDT!");
    },
    error: function (data, textStatus, xhr) {
        console.log("FEJL!");
    },
  });
  }
});
