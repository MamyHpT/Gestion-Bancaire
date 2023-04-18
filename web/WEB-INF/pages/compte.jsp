<%-- 
    Document   : compte
    Created on : 9 mars 2023, 08:03:43
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
        <title>LISTE DES COMPTES</title>
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
                        <a href="Operation">
                            <span class="icon"><i class="fas fa-tasks fa-2x"></i></span>
                            <span class="title"> OPERATION</span>
                        </a>
                    </li>
                    <hr class="hr">
                    <li>
                        <a href="Compte" style="background-color: cyan; color: rgb(20, 8, 73); border-radius: 30px 0 0 30px;">
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
                    <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i><span id="titre"> COMPTES</span></div>
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
                <div class="row mx-auto mt-3 bg-white p-5 rounded table-responsive">
                    <div class="row mx-auto" style="width: 80%;">
                        <div class="col-6 h3 text-center text-info"><b><i class="fas fa-list"></i> LISTE DES COMPTES</b></div>
                        <div class="col-4">
                            <form>
                                <div class="input-group mb-3">
                                    <input type="text" id="rechercher-compte" class="form-control" placeholder="Rechercher ..." aria-label="Recipient's username" aria-describedby="recherche-compte">
                                    <button class="btn" type="button" id="recherche-compte"><i class="fas fa-search"></i></button>
                                </div>
                            </form>
                        </div>
                        <div class="col-1 offset-1 mt-2">
                            <button class="btn btn-sm text-light" type="button" data-bs-toggle="modal" data-bs-target="#modal-ajouter-compte" id="ajouter-compte" style="background-color: rgb(20, 8, 73)"><i class="fas fa-plus"></i> Add</button>
                        </div>
                    </div>
                    <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle mx-auto" id="table-compte" style="width: 80%;">
                        <thead class="text-center text-light">
                            <tr>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">N°</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Nom et Prénoms</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">N° compte</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Téléphone</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Adresse</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">E-mail</th>
                                <th scope="col" style="background-color: rgb(20, 8, 73);">Action</th>
                            </tr>
                        </thead>
                        <tbody id="liste-comptes">
                            <% int i = 1; %>
                            <c:forEach var="compte" items="${ comptes }">
                                <tr>
                                    <td><%= i %></td>
                                    <td><c:out value="${ compte.nom_et_prenoms }"></c:out></td>
                                    <td><c:out value="${ compte.num_compte }"></c:out></td>
                                    <td><c:out value="${ compte.num_phone }"></c:out></td>
                                    <td><c:out value="${ compte.adresse }"></c:out></td>
                                    <td><c:out value="${ compte.email }"></c:out></td>
                                        <td>
                                            <a href="InfoCompte?num_compte=<c:out value="${ compte.num_compte }"></c:out>" class="btn btn-sm btn-outline-dark" role="button" title="info" id="info-compte"><i class="fas fa-info-circle"></i></a>
                                            <button class="btn btn-sm btn-outline-info ms-2" role="button" title="modifier" id="modifier-info-compte" data-bs-toggle="modal" data-bs-target="#modal-modifier-info-compte">
                                                <i class="fas fa-user-edit"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <% i++; %>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- MODAL MODIFICATION INFORMATION DU COMPTE -->
                <div class="modal fade" id="modal-modifier-info-compte" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title mx-auto text-info" id="staticBackdropLabel"><i class="far fa-edit"></i> MODIFIER
                                    LES INFORMATIONS DU COMPTE</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-modal-modif"></button>
                            </div>
                            <div class="modal-body" style="color: rgb(20, 8, 73); font-weight: bold;">
                                <form>
                                    <div class="mb-3">
                                        <label for="modifier-photo-profile" class="form-label">Photo de profile du compte</label>
                                        <input class="form-control" type="image" id="modifier-photo-profile">
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" name="modifier-nom-complet" id="modifier-nom-complet"
                                               placeholder="Nom et Prénoms :" class="form-control">
                                        <label class="form-label" for="modifier-nom-complet">Nom et Prénoms</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" name="modifier-telephone" id="modifier-telephone" placeholder="Téléphone :"
                                               class="form-control" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}">
                                        <label class="form-label" for="modifier-telephone">Téléphone</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" name="modifier-adresse" id="modifier-adresse" placeholder="Adresse :"
                                               class="form-control">
                                        <label class="form-label" for="modifier-adresse">Adresse</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="email" name="modifier-mail" id="modifier-mail" placeholder="E-mail:" class="form-control">
                                        <label class="form-label" for="modifier-mail">E-mail</label>
                                    </div>
                                    <div class="m-3 text-center mt-4" id="erreur-modif">

                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Annuler</button>
                                <button type="button" class="btn btn-info" id="confirmer-modification-compte">Confirmer</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- MODAL D'AJOUT COMPTE -->
                <div class="modal fade" id="modal-ajouter-compte" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h5 class="modal-title text-info" id="staticBackdropLabel"><i class="fas fa-user-plus"></i> CREER UN COMPTE</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-modal-ajout"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-floating mb-2">
                                        <input type="text" class="form-control" name="nom-et-prenoms" id="nom-et-prenoms" placeholder="Nom et Prénoms:">
                                        <label for="nom-et-prenoms">Nom et Prenoms :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <input type="number" class="form-control" id="num-cin" placeholder="N° CIN:">
                                        <label for="num-cin">N° CIN :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <input type="text" class="form-control" id="num-phone" placeholder="Téléphone :">
                                        <label for="num-phone">Téléphone :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <select class="form-select" name="sexe" id="sexe" aria-label="Sexe :">
                                            <option value="homme" selected>Homme</option>
                                            <option value="femme">Femme</option>
                                        </select>
                                        <label for="sexe">Sexe :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <input type="text" class="form-control" id="adresse" placeholder="Adresse :">
                                        <label for="adresse">Adresse :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <input type="mail" class="form-control" id="email" placeholder="E-mail :">
                                        <label for="email">E-mail :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <input type="password" class="form-control" id="mot-de-passe" placeholder="Mot de passe :">
                                        <label for="mot-de-passe">Mot de passe :</label>
                                    </div>
                                    <div class="form-floating mb-2">
                                        <input type="password" class="form-control" id="confirmer-mot-de-passe" placeholder="Confirmer le mot de passe :">
                                        <label for="confirmer-mot-de-passe">Confirmer le mot de passe :</label>
                                    </div>
                                    <div class="m-3 text-center mt-4" id="erreur-saisie">

                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-sm btn-outline-dark" data-bs-dismiss="modal" id="annuler-ajout-compte">Annuler</button>
                                    <input type="reset" class="btn btn-sm btn-outline-info text-start" id="reset-ajout">
                                    <button type="button" class="btn btn-sm text-light" id="confirmer-ajouter-compte" style="background-color: rgb(20, 8, 73);">Créer</button>
                                </div>
                            </form>
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
                $(document).on("click", "#confirmer-ajouter-compte", () => {
                    var nom_et_prenoms = $("#nom-et-prenoms").val();
                    var num_cin = $("#num-cin").val();
                    var num_phone = $("#num-phone").val();
                    var sexe = $("#sexe").val();
                    var adresse = $("#adresse").val();
                    var email = $("#email").val();
                    var password = $("#mot-de-passe").val();
                    var confirm_password = $("#confirmer-mot-de-passe").val();

                    if (nom_et_prenoms.length === 0 || num_cin.length === 0 || num_phone.length === 0 || sexe.length === 0 || adresse.length === 0 || email.length === 0 || password.length === 0 || confirm_password.length === 0) {
                        $("#erreur-saisie").html('<span class="alert alert-warning">* TOUS LES CHAMPS SONT OBLIGATOIRES *</span>');
                    } else {
                        if (password !== confirm_password) {
                            $("#erreur-saisie").html('<span class="alert alert-warning">* LES MOTS DE PASSES NE SONT PAS IDENTIQUES *</span>');
                        } else if (num_cin.length !== 12) {
                            $("#erreur-saisie").html('<span class="alert alert-warning">* VEUILLEZ VERIFIER VOTRE NUMERO CIN *</span>');
                        } else if (num_phone.length !== 10) {
                            $("#erreur-saisie").html('<span class="alert alert-warning">* VEUILLEZ VERIFIER VOTRE NUMERO TELEPHONE *</span>');
                        } else {
                            $("#erreur-saisie").html('');
                            $.ajax({
                                type: 'POST',
                                url: 'Compte',
                                data: {
                                    nom_et_prenoms: nom_et_prenoms,
                                    num_cin: num_cin,
                                    num_phone: num_phone,
                                    sexe: sexe,
                                    adresse: adresse,
                                    email: email,
                                    password: password,
                                    action: 'ajout'
                                },
                                success: function (data) {
                                    if (data.indexOf("compte_existant") !== -1) {
                                        $("#erreur-saisie").html(data);
                                    } else {
                                        $("#close-modal-ajout").click();
                                        $("#reset-ajout").click();
                                        $("#liste-comptes").html(data);
                                        $("#notif").html('<i class="fas fa-check-circle"></i> CREATION DE COMPTE REUSSI !');
                                        $("#notif").fadeIn(3000, function(){
                                            $("#notif").fadeOut(3000);
                                        });
                                    }
                                }
                            });
                        }
                    }
                });

                $(document).on("mouseover", "#modifier-info-compte", () => {
                    var table = document.getElementById("table-compte");
                    for (var i = 0; i < table.rows.length; i++) {
                        table.rows[i].onclick = function () {
                            $("#confirmer-modification-compte").val(this.cells[2].innerHTML);
                            $("#modifier-nom-complet").val(this.cells[1].innerHTML);
                            $("#modifier-telephone").val(this.cells[3].innerHTML);
                            $("#modifier-adresse").val(this.cells[4].innerHTML);
                            $("#modifier-mail").val(this.cells[5].innerHTML);
                        };
                    }
                });

                $(document).on("click", "#confirmer-modification-compte", function () {
                    var num_compte = $(this).val();
                    console.log(num_compte);
                    var nom_et_prenoms = $("#modifier-nom-complet").val();
                    var num_phone = $("#modifier-telephone").val();
                    var adresse = $("#modifier-adresse").val();
                    var email = $("#modifier-mail").val();
                    if (nom_et_prenoms.length === 0 || num_phone.length === 0 || adresse.length === 0 || email.length === 0) {
                        $("#erreur-modif").html('<span class="alert alert-danger">* LES CHAMPS NE DOIVENTS PAS ETRE VIDES *</span>');
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: 'Compte',
                            data: {
                                num_compte: num_compte,
                                nom_et_prenoms: nom_et_prenoms,
                                num_phone: num_phone,
                                adresse: adresse,
                                email: email,
                                action: 'modif'
                            },
                            success: function (data) {
                                $("#close-modal-modif").click();
                                $("#liste-comptes").html(data);
                                $("#notif").html('<i class="fas fa-check-circle"></i> MODIFICATION REUSSI !');
                                $("#notif").fadeIn(3000, function(){
                                    $("#notif").fadeOut(3000);
                                });
                            }
                        });
                    }
                });

                $(document).on("click", "#annuler-ajout-compte", () => {
                    $("#erreur-saisie").html('');
                });

                $(document).on("click", "#close-modal-ajout", () => {
                    $("#erreur-saisie").html('');
                });

                $(document).on("click", "#reset-ajout", () => {
                    $("#erreur-saisie").html('');
                });
            });
        </script>
    </body>

</html>
