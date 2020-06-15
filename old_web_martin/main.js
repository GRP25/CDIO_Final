$(document).ready(function () {
  document.getElementById("loader-bg").style.display = "none";
  var modal = document.getElementById("myModal");
  var span = document.getElementsByClassName("close")[0];

  function hideTheModal() {
    modal.style.display = "none";
  }

  $(".close, #modal-close").click(() => {
    hideTheModal();
  });

  window.onclick = function () {
    if (this.event.target == modal) {
      hideTheModal();
    }
  };

  function updateList() {
    document.getElementById("loader-bg").style.display = "block";
    $.ajax({
      url: "https://api.mama.sh/",
      type: "GET",
      success: function (data, textStatus, xhr) {
        document.getElementById("loader-bg").style.display = "none";
        $("#oot").html("");
        jQuery.each(data, function (index, item) {
          var li = $("<tr></tr>");
          var name = $("<td></td>").text(item.name);
          var edit = $('<td><i class="fa fa-edit"></i></td>');
          var dele = $('<td><i class="fa fa-trash"></i></td>');
          li.append(name);
          li.append(edit);
          li.append(dele);
          $("#oot").append(li);
          //Creates the update-user-form
          edit.on("click", function () {
            modal.style.display = "block";
            $("#info").css("display", "block");
            $("#initials").val(item.initials);
            $("#cpr").val(item.cpr);
            $("#password").val(item.password);
            $("#name").val(item.name);
            //Checks all the roles that the user has.
            $(".roles").prop("checked", false);
            item.roles.forEach(function (i, e) {
              $("#" + i).prop("checked", true);
            });
            $("#save").val("UPDATE USER");
            $("#save").click(function () {
              saveUser(true, item.id);
            });
          });
          dele.on("click", function () {
            document.getElementById("loader-bg").style.display = "block";
            $.ajax({
              url: `https://api.mama.sh/${item.id}`,
              type: "DELETE",
              success: function (msg) {
                hideTheModal();
                updateList();
              },
              error: function () {
                document.getElementById("loader-bg").style.display = "none";
              },
            });
          });
        });
      },
      error: function (xhr, textStatus, errorThrown) {
        console.log("Fejler bejler");
      },
    });
  }

  $("#crbtn").click(() => {
    modal.style.display = "block";
    $("#initials").val("");
    $("#cpr").val("");
    $("#password").val("");
    $("#name").val("");
    //Checks all the roles that the user has.
    $(".roles").prop("checked", false);
    $("#save").val("SAVE USER");
    $("#save").click(() => {
      saveUser(false, 0);
    });
  });

  $("#get").click(function () {
    updateList();
  });

  function saveUser(update, identification) {
    $(".form").each(function (e, i) {
      i.style.border = "2px solid black";
    });
    $(".error").each(function (e, i) {
      console.log(e);
      console.log(i);
      i.innerHTML = "";
    });

    document.getElementById("loader-bg").style.display = "block";
    var roles = [];
    $(".roles:checked").each(function (i, e) {
      roles.push($(this).val());
    });

    var user = {
      name: $("#name").val(),
      initials: $("#initials").val(),
      cpr: $("#cpr").val(),
      password: $("#password").val(),
      roles: roles,
    };

    if (update) {
      user["id"] = identification;
      $.ajax({
        url: `https://api.mama.sh/`,
        type: "PUT",
        data: JSON.stringify(user),
        contentType: "application/json",
        success: function (msg) {
          hideTheModal();
          updateList();
        },
        error: function (data, textStatus, xhr) {
          var resp = data.responseJSON;
          document.getElementById("loader-bg").style.display = "none";
          if (resp.errorCode == 3) {
            document.getElementById("name").style.border = "2px solid red";
            $("#ename").html(resp.errorMessage);
          }
          if (resp.errorCode == 2) {
            document.getElementById("cpr").style.border = "2px solid red";
            $("#ecpr").html(resp.errorMessage);
          }
          if (resp.errorCode == 1) {
            document.getElementById("password").style.border = "2px solid red";
            $("#epass").html(resp.errorMessage);
          }
          console.log(data.responseJSON.errorMessage);
        },
      });
    } else {
      $.ajax({
        url: "https://api.mama.sh",
        type: "POST",
        data: JSON.stringify(user),
        contentType: "application/json",
        success: function (msg) {
          hideTheModal();
          updateList();
        },
        error: function (data, textStatus, xhr) {
          document.getElementById("loader-bg").style.display = "none";
          alert(data + "Hejsa");
        },
      });
    }
  }
});
