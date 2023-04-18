<%-- 
    Document   : retrait
    Created on : 9 mars 2023, 08:42:33
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
        <title>FAIRE UN RETRAIT</title>
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
                        <a href="Retrait" style="background-color: cyan; color: rgb(20, 8, 73); border-radius: 30px 0 0 30px;">
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
                        <a href="Operation">
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
                <div class="col-3">
                    <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i><span id="titre"> RETRAIT</span></div>
                </div>
                <div class="col-lg-3 offset-1">
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
            <div class="row pb-5 ps-3" id="contenu">
                <div class="row bg-white mt-4 pb-5">
                    <div class="card p-5 text-white w-75 mx-auto" style="background-color: rgb(20, 8, 73); margin-top: 5%;">
                        <div class="row g-0">
                            <div class="col-md-4 my-auto">
                                <img src="./img/retrait.jpg" class="img-fluid border border-light" alt="profile">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title text-center text-info mb-5">
                                        <i class="fas fa-dollar-sign"></i> RETRAIT D'ARGENT
                                    </h3>
                                    <form class="mx-auto">
                                        <div class="mb-3 row">
                                            <label for="numero-compte-depot" class="col-sm-4 col-form-label offset-1">Numéro de compte :</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control text-center" id="numero-compte-retrait">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label for="numero-cheque-depot" class="col-sm-4 col-form-label offset-1">Numéro du chèque :</label>
                                            <div class="col-sm-6">
                                                <input type="number" class="form-control text-center" id="numero-cheque-retrait">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label for="montant-versement" class="col-sm-4 col-form-label offset-1">Montant (Ariary) :</label>
                                            <div class="col-sm-6">
                                                <input type="number" class="form-control text-center" id="montant-retrait">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label for="motdepasse-retrait" class="col-sm-4 col-form-label offset-1">Mot de passe :</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control text-center" id="motdepasse-retrait">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-end">
                                    <button class="btn btn-sm btn-outline-light me-5" type="button" data-bs-toggle="modal" data-bs-target="#modal-retrait" id="retirer">RETRAIT</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-4 bg-white p-5 rounded table-responsive">
                    <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle caption-top mx-auto w-75" id="table-compte">
                        <caption class="h3 text-center text-info">
                            <b><i class="fas fa-list"></i> LISTE DES RETRAIT RECENTS</b>
                        </caption>
                        <thead class="text-center text-light border-light">
                            <tr>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Numéro</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Date et Heure</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Nom et Prénoms</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Numéro de compte</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Montant</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Numéro chèque</th>
                            </tr>
                        </thead>
                        <tbody id="liste-retrait-recent">
                            <c:forEach var="retrait" items="${ retraits }">
                                <tr>
                                    <td><c:out value="${ retrait.num_retrait }"></c:out></td>
                                    <td><c:out value="${ retrait.date_retrait }"></c:out></td>
                                    <td><c:out value="${ retrait.nom_et_prenoms }"></c:out></td>
                                    <td><c:out value="${ retrait.num_compte }"></c:out></td>
                                    <td><c:out value="${ retrait.montant_retrait }"></c:out></td>
                                    <td><c:out value="${ retrait.num_cheque }"></c:out></td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- MODAL CONFIRMATION RETRAIT -->
                <div class="modal fade" id="modal-retrait" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content" id="contenu-modal-retrait">

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="rounded-pill text-center p-3" id="notif" style="position: fixed;top: 8%;left: 47%;z-index: 5;background-color: greenyellow;display: none;color: rgb(20, 8, 73);">

        </div>

        <script src="./framework/jquery/jquery.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.min.js"></script>
        <script src="./framework/fontawesome/js/all.min.js"></script>
        <script src="./framework/fontawesome/js/fontawesome.min.js"></script>
        <script src="./js/index.js"></script>
        <script>
            $(document).ready(() => {
                $(document).on("click", "#retirer", () => {
                    var num_compte = $("#numero-compte-retrait").val();
                    var num_cheque = $("#numero-cheque-retrait").val();
                    var montant = $("#montant-retrait").val();
                    var password = $("#motdepasse-retrait").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Retrait',
                        data: {
                            num_compte: num_compte,
                            num_cheque: num_cheque,
                            montant: montant,
                            password: password,
                            action: "verification"
                        },
                        success: function (data) {
                            $("#contenu-modal-retrait").html(data);
                        }
                    });
                });
                
                $(document).on("click", "#valider-retrait", () => {
                    var num_compte = $("#num_compte").val();
                    var num_cheque = $("#num_cheque").val();
                    var montant = $("#montant").val();
                    var password = $("#password").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Retrait',
                        data: {
                            num_compte: num_compte,
                            num_cheque: num_cheque,
                            montant: montant,
                            password: password,
                            action: "validation"
                        },
                        success: function (data) {
                            if(data.indexOf("autre") === -1){
                                $("#liste-retrait-recent").html(data);
                                $("#notif").html('<i class="fas fa-check-circle"></i> RETRAIT REUSSI !');
                                $("#notif").fadeIn(3000, function(){
                                    $("#notif").fadeOut(3000);
                                });
                            }
                        }
                    });
                });
            });
        </script>
    </body>

</html>
