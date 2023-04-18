<%-- 
    Document   : operation
    Created on : 9 mars 2023, 08:28:27
    Author     : Mamy Hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./framework/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="./framework/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="./framework/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="./css/style-app.css">
        <title>LISTE DES OPERATIONS</title>
    </head>

    <body>
        <div class="menu">
            <nav class="nav">
                <ul>
                    <li>
                        <a class="text-info">
                            <span class="icon"><i class="fas fa-money-check-alt fa-3x"></i></span>
                            <span class="title h6"> BANQUE DEMADAGASCAR</span>
                        </a>
                    </li>
                    <hr class="hr">
                    <li>
                        <a href="Accueil">
                            <span class="icon"><i class="fas fa-home fa-2x"></i></span>
                            <span class="title"> ACCUEIL</span>
                        </a>
                    </li>
                    <li>
                        <a href="Versement">
                            <span class="icon"><i class="fas fa-piggy-bank fa-2x"></i></span>
                            <span class="title"> VERSEMENT</span>
                        </a>
                    </li>
                    <li>
                        <a href="Retrait">
                            <span class="icon"><i class="fas fa-dollar-sign fa-2x"></i></span>
                            <span class="title"> RETRAIT</span>
                        </a>
                    </li>
                    <li>
                        <a href="Transfert">
                            <span class="icon"><i class="fas fa-exchange-alt fa-2x"></i></span>
                            <span class="title"> TRANSFERT</span>
                        </a>
                    </li>
                    <li>
                        <a href="Solde">
                            <span class="icon"><i class="fas fa-money-bill-alt fa-2x"></i></span>
                            <span class="title"> SOLDE</span>
                        </a>
                    </li>
                    <li>
                        <a href="Operation" style="background-color: cyan; color: rgb(20, 8, 73); border-radius: 30px 0 0 30px;">
                            <span class="icon"><i class="fas fa-tasks fa-2x"></i></span>
                            <span class="title"> OPERATION</span>
                        </a>
                    </li>
                    <hr class="hr">
                    <li>
                        <a href="Compte">
                            <span class="icon"><i class="far fa-user-circle fa-2x"></i></span>
                            <span class="title"> COMPTES</span>
                        </a>
                    </li>
                    <li>
                        <a href="Login">
                            <span class="icon"><i class="fas fa-sign-out-alt fa-2x"></i></span>
                            <span class="title"> SE DECONNECTER</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="container-fluid">
            <div class="row bg-white pt-3 pb-1">
                <div class="col-2">
                    <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i> OPERATION
                    </div>
                </div>
                <div class="col-1 form-floating" style="font-weight: bolder;">
                    <select class="form-select text-info" name="filtre" id="filtre" aria-label="Filtrer par :">
                        <option value="versement" selected>Versement</option>
                        <option value="retrait">Retrait</option>
                        <option value="transfert">Transfert</option>
                    </select>
                    <label for="filtre" style="color: rgb(20, 8, 73);"><i class="fas fa-filter"></i> Filtrer par :</label>
                </div>
                <div class="col-lg-3 offset-2">
                    <h3 class="text-info">BANQUE DE MADAGASCAR</h3>
                </div>
                <div class="col-lg-4">
                    <div class="row text-end">
                        <div class="col offset-1">
                            <i class="fas fa-user-shield p-1 fa-3x"></i>
                        </div>
                        <div class="col text-start my-auto h5" style="color: rgb(20, 8, 73);">${ pseudo } <span class="text-danger">(@admin)</span></div>
                    </div>
                </div>
            </div>
            <div class="row mx-auto mt-3 bg-white p-3 ps-5 pe-5 rounded table-responsive">
                <div class="col rounded-pill p-2 bg-light text-center ms-5">
                    <h5>TOTAL VERSEMENT</h5>
                    <div class="row">
                        <div class="col-6 offset-1">
                            <select class="form-select text-info" name="vers" id="vers" aria-label="Filtrer par :">
                                <option value="today" selected>Ajourd'hui</option>
                                <option value="month">Mois</option>
                                <option value="year">Année</option>
                            </select>
                        </div>
                        <div class="col-3 ps-3 pe-3 p-1 alert-info text-center my-auto h-75" id="versVal">${ nbVersement }</div>
                    </div>
                </div>
                <div class="col rounded-pill p-2 bg-light text-center ms-5">
                    <h5>TOTAL RETRAIT</h5>
                    <div class="row">
                        <div class="col-6 offset-1">
                            <select class="form-select text-success" name="ret" id="ret" aria-label="Filtrer par :">
                                <option value="today" selected>Ajourd'hui</option>
                                <option value="month">Mois</option>
                                <option value="year">Année</option>
                            </select>
                        </div>
                        <div class="col-3 ps-3 pe-3 p-1 alert-success text-center my-auto h-75" id="retVal">${ nbRetrait }</div>
                    </div>
                </div>
                <div class="col rounded-pill p-2 bg-light text-center ms-5">
                    <h5>TOTAL TRANSFERT</h5>
                    <div class="row">
                        <div class="col-6 offset-1">
                            <select class="form-select text-warning" name="trans" id="trans" aria-label="Filtrer par :">
                                <option value="today" selected>Ajourd'hui</option>
                                <option value="month">Mois</option>
                                <option value="year">Année</option>
                            </select>
                        </div>
                        <div class="col-3 ps-3 pe-3 p-1 alert-warning text-center my-auto h-75" id="transVal">${ nbTransfert }</div>
                    </div>
                </div>
            </div>
            <div class="row pb-5 ps-3" id="contenu">
                <!-- CONTENU DE LA PAGE -->
                <div class="row mx-auto mt-3 bg-white p-5 rounded table-responsive">
                    <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle" id="table-versements">
                        <div class="row mb-3">
                            <div class="col-1 form-floating" style="font-weight: bolder;">
                                <select class="form-select text-info" name="tri-versement" id="tri-versement" aria-label="Trier par :">
                                    <option value="id" selected>Numero</option>
                                    <option value="nom">Nom</option>
                                    <option value="num">Numero bancaire</option>
                                    <option value="nouveau">Nouveau</option>
                                    <option value="montant-sup">Montant Supérieur</option>
                                    <option value="montant-inf">Montant Inférieur</option>
                                </select>
                                <label for="tri-versement" style="color: rgb(20, 8, 73);"><i class="fas fa-filter"></i> Trier par :</label>
                            </div>
                            <div class="col h3 text-center text-info">
                                <b><i class="fas fa-list"></i> LISTE DES VERSEMENTS</b>
                            </div>
                            <div class="col-4">
                                <form>
                                    <div class="input-group mb-3">
                                        <input type="search" id="rechercher-versement" class="form-control" placeholder="Rechercher ...">
                                        <button class="btn" type="button" id="btn-recherche-versement">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <thead class="text-center text-light border-light">
                            <tr>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">N°</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Nom et Prénoms</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Numéro de compte</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Montant (Ar)</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Date et Heure</th>
                            </tr>
                        </thead>
                        <tbody id="liste-versements">
                            <c:forEach var="versement" items="${ versements }">
                                <tr>
                                    <td><c:out value="${ versement.num_versement }"></c:out></td>
                                    <td><c:out value="${ versement.nom_et_prenoms }"></c:out></td>
                                    <td><c:out value="${ versement.num_compte }"></c:out></td>
                                    <td class="text-end"><c:out value="${ versement.montant_versement }"></c:out></td>
                                    <td class="text-end"><c:out value="${ versement.date_versement }"></c:out></td>
                                        <td class="text-center">
                                            <button class="btn btn-outline-danger" role="button" title="Supprimer" data-bs-toggle="modal" data-bs-target="#modal-supprimer-versement" id="supprimer-versement">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </td>
                                    </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>

        <!-- MODAL SUPPRESION VERSEMENT -->
        <div class="modal fade" id="modal-supprimer-versement" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger" id="staticBackdropLabel">
                            <i class="fas fa-exclamation-circle"></i> SUPPRESSION
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-mod-sup-vers"></button>
                    </div>
                    <div class="modal-body">
                        <h5 class="alert alert-danger text-center" style="color: rgb(20, 8, 73);">
                            SUPPRIMMER CETTE HISTORIQUE ?<br>
                            (action irreversible)
                        </h5>
                    </div>
                    <div class="modal-footer">
                        <div class="form-floating">
                            <input class="form-control" type="password" id="pass-sup-vers" name="pass-sup-vers" placeholder="password">
                            <label for="pass-sup-vers">Mot de passe admin :</label>
                        </div>
                        <button type="button" class="btn btn-danger" id="confirmer-supprimer-versement">Supprimer</button>
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-supprimer-versement">Annuler</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- MODAL SUPPRESION RETRAIT -->
        <div class="modal fade" id="modal-supprimer-retrait" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger" id="staticBackdropLabel">
                            <i class="fas fa-exclamation-circle"></i> SUPPRESSION</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-mod-sup-ret"></button>
                    </div>
                    <div class="modal-body">
                        <h5 class="alert alert-danger text-center" style="color: rgb(20, 8, 73);">
                            SUPPRIMMER CETTE HISTORIQUE ?<br>
                            (action irreversible)
                        </h5>
                    </div>
                    <div class="modal-footer">
                        <div class="form-floating">
                            <input class="form-control" type="password" id="pass-sup-ret" name="pass-sup-ret" placeholder="password">
                            <label for="pass-sup-ret">Mot de passe admin :</label>
                        </div>
                        <button type="button" class="btn btn-danger" id="confirmer-supprimer-retrait">Supprimer</button>
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-supprimer-retrait">Annuler</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- MODAL SUPPRESION TRANSFERT -->
        <div class="modal fade" id="modal-supprimer-transfert" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger" id="staticBackdropLabel">
                            <i class="fas fa-exclamation-circle"></i> SUPPRESSION</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-mod-sup-trans"></button>
                    </div>
                    <div class="modal-body">
                        <h5 class="alert alert-danger text-center" style="color: rgb(20, 8, 73);">
                            SUPPRIMMER CETTE HISTORIQUE ?<br>
                            (action irreversible)
                        </h5>
                    </div>
                    <div class="modal-footer">
                        <div class="form-floating">
                            <input class="form-control" type="password" id="pass-sup-trans" name="pass-sup-trans" placeholder="password">
                            <label for="pass-sup-trans">Mot de passe admin :</label>
                        </div>
                        <button type="button" class="btn btn-danger" id="confirmer-supprimer-transfert">Supprimer</button>
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-supprimer-transfert">Annuler</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="rounded-pill text-center p-3 bg-warning" id="notif" style="position: fixed;top: 8%;left: 47%;z-index: 5;display: none;color: rgb(20, 8, 73);">

        </div>

        <script src="./framework/jquery/jquery.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.min.js"></script>
        <script src="./framework/fontawesome/js/all.min.js"></script>
        <script src="./framework/fontawesome/js/fontawesome.min.js"></script>
        <script src="./js/index.js"></script>
        <script>
            $(document).ready(() => {
                $(document).on("change", "#tri-versement", () => {
                    var tri = $("#tri-versement").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            tri: tri,
                            action: "tri-versement"
                        },
                        success: function (data) {
                            $("#liste-versements").html(data);
                        }
                    });
                });

                $(document).on("change", "#tri-retrait", () => {
                    var tri = $("#tri-retrait").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            tri: tri,
                            action: "tri-retrait"
                        },
                        success: function (data) {
                            $("#liste-retraits").html(data);
                        }
                    });
                });

                $(document).on("change", "#tri-transfert", () => {
                    var tri = $("#tri-transfert").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            tri: tri,
                            action: "tri-transfert"
                        },
                        success: function (data) {
                            $("#liste-transferts").html(data);
                        }
                    });
                });

                $(document).on("change", "#filtre", () => {
                    var filtre = $("#filtre").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            filtre: filtre,
                            action: "filtre"
                        },
                        success: function (data) {
                            $("#contenu").html(data);
                        }
                    });
                });

                $(document).on("keypress", "#rechercher-versement", function (code) {
                    var codeTouche = code.which || code.keyCode;
                    if (codeTouche === 13) {
                        chercher_versement();
                        code.preventDefault();
                    }
                });

                $(document).on("keyup", "#rechercher-versement", function () {
                    chercher_versement();
                });

                $(document).on("click", "#btn-recherche-versement", () => {
                    chercher_versement();
                });

                function chercher_versement()
                {
                    var value = $("#rechercher-versement").val().toLowerCase();
                    $("#liste-versements tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                }

                $(document).on("keypress", "#rechercher-retrait", function (code) {
                    var codeTouche = code.which || code.keyCode;
                    if (codeTouche === 13) {
                        chercher_retrait();
                        code.preventDefault();
                    }
                });

                $(document).on("keyup", "#rechercher-retrait", function () {
                    chercher_retrait();
                });

                $(document).on("click", "#btn-recherche-retrait", () => {
                    chercher_retrait();
                });

                function chercher_retrait()
                {
                    var value = $("#rechercher-retrait").val().toLowerCase();
                    $("#liste-retraits tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                }

                $(document).on("keypress", "#rechercher-transfert", function (code) {
                    var codeTouche = code.which || code.keyCode;
                    if (codeTouche === 13) {
                        chercher_transfert();
                        code.preventDefault();
                    }
                });

                $(document).on("keyup", "#rechercher-transfert", function () {
                    chercher_transfert();
                });

                $(document).on("click", "#btn-recherche-transfert", () => {
                    chercher_transfert();
                });

                function chercher_transfert()
                {
                    var value = $("#rechercher-transfert").val().toLowerCase();
                    $("#liste-transferts tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                }

                $(document).on("click", "#confirmer-supprimer-versement", () => {
                    var num_versement = $("#confirmer-supprimer-versement").val();
                    var password = $("#pass-sup-vers").val();
                    var tri = $("#tri-versement").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            num_versement: num_versement,
                            password: password,
                            tri: tri,
                            action: "supprimer-versement"
                        },
                        success: function (data) {
                            if (data === "incorrect") {
                                $("#pass-sup-vers").addClass("border-danger");
                            } else {
                                $("#pass-sup-vers").removeClass("border-danger");
                                $("#close-mod-sup-vers").click();
                                $("#liste-versements").html(data);
                                $("#notif").html('<i class="fas fa-check-circle"></i> VERSEMENT SUPPRIMER !');
                                $("#notif").fadeIn(3000, function () {
                                    $("#notif").fadeOut(3000);
                                });
                                chercher_versement();
                            }
                        }
                    });
                });

                $(document).on("click", "#annuler-supprimer-versement", () => {
                    $("#pass-sup-vers").removeClass("border-danger");
                    $("#pass-sup-vers").val("");
                });

                $(document).on("click", "#close-mod-sup-vers", () => {
                    $("#pass-sup-vers").removeClass("border-danger");
                    $("#pass-sup-vers").val("");
                });

                $(document).on("mouseover", "#supprimer-versement", () => {
                    var table = document.getElementById("table-versements");
                    for (var i = 0; i < table.rows.length; i++) {
                        table.rows[i].onclick = function () {
                            $("#confirmer-supprimer-versement").val(this.cells[0].innerHTML);
                        };
                    }
                });

                $(document).on("click", "#confirmer-supprimer-transfert", () => {
                    var num_transfert = $("#confirmer-supprimer-transfert").val();
                    var password = $("#pass-sup-trans").val();
                    var tri = $("#tri-transfert").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            num_transfert: num_transfert,
                            password: password,
                            tri: tri,
                            action: "supprimer-transfert"
                        },
                        success: function (data) {
                            if (data === "incorrect") {
                                $("#pass-sup-trans").addClass("border-danger");
                            } else {
                                $("#pass-sup-trans").removeClass("border-danger");
                                $("#close-mod-sup-trans").click();
                                $("#liste-transferts").html(data);
                                $("#notif").html('<i class="fas fa-check-circle"></i> TRANSFERT SUPPRIMER !');
                                $("#notif").fadeIn(3000, function () {
                                    $("#notif").fadeOut(3000);
                                });
                                chercher_transfert();
                            }
                        }
                    });
                });

                $(document).on("click", "#annuler-supprimer-transfert", () => {
                    $("#pass-sup-trans").removeClass("border-danger");
                    $("#pass-sup-trans").val("");
                });

                $(document).on("click", "#close-mod-sup-trans", () => {
                    $("#pass-sup-trans").removeClass("border-danger");
                    $("#pass-sup-trans").val("");
                });

                $(document).on("mouseover", "#supprimer-transfert", () => {
                    var table = document.getElementById("table-transferts");
                    for (var i = 0; i < table.rows.length; i++) {
                        table.rows[i].onclick = function () {
                            $("#confirmer-supprimer-transfert").val(this.cells[0].innerHTML);
                        };
                    }
                });

                $(document).on("click", "#confirmer-supprimer-retrait", () => {
                    var num_retrait = $("#confirmer-supprimer-retrait").val();
                    var password = $("#pass-sup-ret").val();
                    var tri = $("#tri-retrait").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            num_retrait: num_retrait,
                            password: password,
                            tri: tri,
                            action: "supprimer-retrait"
                        },
                        success: function (data) {
                            if (data === "incorrect") {
                                $("#pass-sup-ret").addClass("border-danger");
                            } else {
                                $("#pass-sup-ret").removeClass("border-danger");
                                $("#close-mod-sup-ret").click();
                                $("#liste-retraits").html(data);
                                $("#notif").html('<i class="fas fa-check-circle"></i> RETRAIT SUPPRIMER !');
                                $("#notif").fadeIn(3000, function () {
                                    $("#notif").fadeOut(3000);
                                });
                                chercher_retrait();
                            }
                        }
                    });
                });

                $(document).on("click", "#annuler-supprimer-retrait", () => {
                    $("#pass-sup-ret").removeClass("border-danger");
                    $("#pass-sup-ret").val("");
                });

                $(document).on("click", "#close-mod-sup-ret", () => {
                    $("#pass-sup-ret").removeClass("border-danger");
                    $("#pass-sup-ret").val("");
                });

                $(document).on("mouseover", "#supprimer-retrait", () => {
                    var table = document.getElementById("table-retraits");
                    for (var i = 0; i < table.rows.length; i++) {
                        table.rows[i].onclick = function () {
                            $("#confirmer-supprimer-retrait").val(this.cells[0].innerHTML);
                        };
                    }
                });

                $(document).on("change", "#vers", () => {
                    var tri = $("#vers").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            tri: tri,
                            action: "vers"
                        },
                        success: function (data) {
                            $("#versVal").text(data);
                        }
                    });
                });
                
                $(document).on("change", "#ret", () => {
                    var tri = $("#ret").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            tri: tri,
                            action: "ret"
                        },
                        success: function (data) {
                            $("#retVal").text(data);
                        }
                    });
                });
                
                $(document).on("change", "#trans", () => {
                    var tri = $("#trans").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Operation',
                        data: {
                            tri: tri,
                            action: "trans"
                        },
                        success: function (data) {
                            $("#transVal").text(data);
                        }
                    });
                });
            });
        </script>
    </body>

</html>
