<%-- 
    Document   : transfert
    Created on : 9 mars 2023, 09:19:56
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
        <title>TRANSFERER DE L'ARGENT D'UN COMPTE A UN AUTRE</title>
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
                        <a href="Transfert" style="background-color: cyan; color: rgb(20, 8, 73); border-radius: 30px 0 0 30px;">
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
                    <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i><span id="titre"> TRANSFERT</span></div>
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
                                <img src="./img/transfert.jpg" class="img-fluid border border-light" alt="profile">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title text-center text-info mb-5">
                                        <i class="fas fa-exchange-alt"></i> TRANSFERT D'ARGENT
                                    </h3>
                                    <form class="mx-auto">
                                        <div class="row">
                                            <label for="numero-compte-transfert" class="col-4 col-lg-3 col-form-label offset-1">Numéro de compte envoyeur :</label>
                                            <div class="col-6 offset-lg-1">
                                                <input type="text" class="form-control text-center" id="numero-compte-envoyeur">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label for="numero-compte-transfert" class="col-4 col-lg-3 col-form-label offset-1">Numéro de compte destinataire :</label>
                                            <div class="col-6 offset-lg-1">
                                                <input type="text" class="form-control text-center" id="numero-compte-destinataire">
                                            </div>
                                        </div>
                                        <div class="mb-4 row">
                                            <label for="montant-transfert" class="col-4 col-form-label offset-1">Montant (Ariary) :</label>
                                            <div class="col-6">
                                                <input type="number" class="form-control text-center" id="montant-transfert">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label for="motif-transfert" class="col-4 col-form-label offset-1">Motif (Optionnel) :</label>
                                            <div class="col-6">
                                                <input type="text" class="form-control text-center" id="motif-transfert">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label for="password-transfert" class="col-4 col-form-label offset-1">Mot de passe :</label>
                                            <div class="col-6">
                                                <input type="password" class="form-control text-center" id="password-transfert">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-end">
                                    <button class="btn btn-sm btn-outline-light me-5" type="button" data-bs-toggle="modal" data-bs-target="#modal-transfert" id="transferer">TRANSFERER</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-4 bg-white p-5 rounded table-responsive">
                    <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle caption-top mx-auto" id="table-compte">
                        <caption class="h3 text-center text-info">
                            <b><i class="fas fa-list"></i> LISTE DES TRANSFERTS RECENTS</b>
                        </caption>
                        <thead class="text-center text-light border-light">
                            <tr>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Numéro</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Date et Heure</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);" colspan="2">Envoyeur</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);" colspan="2">Destinataire</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Montant</th>
                            </tr>
                        </thead>
                        <tbody id="liste-transfert-recent">
                            <c:forEach var="transfert" items="${ transferts }">
                                <tr>
                                    <td><c:out value="${ transfert.num_transfert }"></c:out></td>
                                    <td><c:out value="${ transfert.date_transfert }"></c:out></td>
                                    <td><c:out value="${ transfert.num_compte_env }"></c:out></td>
                                    <td><c:out value="${ transfert.nom_env }"></c:out></td>
                                    <td><c:out value="${ transfert.num_compte_rec }"></c:out></td>
                                    <td><c:out value="${ transfert.nom_rec }"></c:out></td>
                                    <td><c:out value="${ transfert.montant_transfert }"></c:out></td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- MODAL CONFIRMATION TRANSFERT -->
                <div class="modal fade" id="modal-transfert" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content" id="contenu-modal-transfert">

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
                $(document).on("click", "#transferer", function () {
                    var num_compte_env = $("#numero-compte-envoyeur").val();
                    var num_compte_rec = $("#numero-compte-destinataire").val();
                    var montant = $("#montant-transfert").val();
                    var motif = $("#motif-transfert").val();
                    var password = $("#password-transfert").val();
                    $.ajax({
                        type: 'POST',
                        url: 'Transfert',
                        data: {
                            num_compte_env: num_compte_env,
                            num_compte_rec: num_compte_rec,
                            montant: montant,
                            motif: motif,
                            password: password,
                            action: "verification"
                        },
                        success: function (data) {
                            $("#contenu-modal-transfert").html(data);
                        }
                    });
                });
                
                $(document).on("click", "#valider-transfert", ()=>{
                   var num_compte_env = $("#num_compte_env").val();
                   var num_compte_rec = $("#num_compte_rec").val();
                   var montant = $("#montant").val();
                   var motif = $("#motif").val();
                   var password = $("#password").val();
                   $.ajax({
                        type: 'POST',
                        url: 'Transfert',
                        data: {
                            num_compte_env: num_compte_env,
                            num_compte_rec: num_compte_rec,
                            montant: montant,
                            motif: motif,
                            password: password,
                            action: "validation"
                        },
                        success: function (data) {
                            $("#liste-transfert-recent").html(data);
                            $("#notif").html('<i class="fas fa-check-circle"></i> TRANSFERT REUSSI !');
                            $("#notif").fadeIn(3000, function(){
                                $("#notif").fadeOut(3000);
                            });
                        }
                   });
                });
            });
        </script>
    </body>

</html>
