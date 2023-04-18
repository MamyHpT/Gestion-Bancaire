$(document).ready(() => {
    $(document).on("keyup", "#rechercher-compte", ()=>{
        chercher_compte();
    });

    let btn = document.querySelector("#menu-btn");
    let menu = document.querySelector(".nav");
    let container = document.querySelector(".container-fluid");
    btn.onclick = function () {
        menu.classList.toggle("click");
        container.classList.toggle("click");
    };

    function chercher_compte() {
        var value = $("#rechercher-compte").val().toLowerCase();
        $("#liste-comptes tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
        });
    }

});