<%-- 
    Document   : info-compte.jsp
    Created on : 9 mars 2023, 08:18:01
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
        <title>INFORMATION A PROPOS DU COMPTE</title>
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
                    <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i><span id="titre"> INFO COMPTE</span></div>
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
                <div class="row">
                    <div class="card p-5 text-white w-75 mx-auto" style="background-color: rgb(20, 8, 73); margin-top: 3%;">
                        <div class="row g-0">
                            <div class="col-md-4 my-auto">
                                <img src="./img/${ compte.sexe }.png" alt="profile" class="img-fluid" style="width: 100%"/>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title text-center text-info mb-5">
                                        <i class="fas fa-info-circle"></i> INFORMATION A PROPOS DU COMPTE
                                    </h3>
                                    <form class="mx-auto">
                                        <div class="mb-3 row">
                                            <label for="numero-compte" class="col-sm-4 col-form-label offset-1">Numéro de compte :</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="numero-compte" value="<c:out value="${ compte.num_compte }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="password" class="col-sm-4 col-form-label offset-1">Mot de passe :</label>
                                                <div class="col-sm-6">
                                                    <input type="password" class="form-control" id="password" value="<c:out value="${ compte.password }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="solde" class="col-sm-4 col-form-label offset-1">Solde (Ariary) :</label>
                                                <div class="col-sm-6">
                                                    <input type="password" class="form-control" id="solde" value="<c:out value="${ compte.solde }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="nom-et-prenoms" class="col-sm-4 col-form-label offset-1">Nom et Prénoms :</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="nom-et-prenoms" value="<c:out value="${ compte.nom_et_prenoms }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="numero-cin" class="col-sm-4 col-form-label offset-1">Numéro CIN :</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="numero-cin" value="<c:out value="${ compte.num_cin }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="numero-telephone" class="col-sm-4 col-form-label offset-1">Numéro téléphone :</label>
                                                <div class="col-sm-6">
                                                    <input type="tel" class="form-control" id="numero-telephone" value="<c:out value="${ compte.num_phone }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="sexe" class="col-sm-4 col-form-label offset-1">Sexe :</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="sexe" value="<c:out value="${ compte.sexe }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="adresse" class="col-sm-4 col-form-label offset-1">Adresse :</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="adresse" value="<c:out value="${ compte.adresse }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="email" class="col-sm-4 col-form-label offset-1">Email :</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="email" value="<c:out value="${ compte.email }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label for="date-creation" class="col-sm-4 col-form-label offset-1">Date de création :</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="date-creation" value="<c:out value="${ compte.date_creation }"></c:out>" style="color: rgb(20, 8, 73);font-weight: bold;" readonly>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-end W-100">
                                    <a href="Compte" class="btn btn-sm btn-light" id="retour"><i class="fas fa-angle-double-left"></i> RETOUR</a>
                                    <button role="button" class="btn btn-sm btn-danger" title="Supprimer" data-bs-toggle="modal" data-bs-target="#modal-supprimer-compte" id="supprimer-compte"><i class="fas fa-trash-alt"></i> SUPPRIMER</button>
                                    <button role="button" class="btn btn-sm btn-warning" title="Afficher solde" data-bs-toggle="modal" data-bs-target="#modal-afficher-solde" id="afficher-solde"><i class="fas fa-eye"></i> AFFICHER SOLDE</button>
                                    <button role="button" class="btn btn-sm btn-info" title="Modifier information du compte" data-bs-toggle="modal" data-bs-target="#modal-modifier-info-compte" id="modifier-compte"><i class="fas fa-edit"></i> MODIFIER</button>
                                    <button role="button" class="btn btn-sm btn-success" title="Changer mot de passe" data-bs-toggle="modal" data-bs-target="#modal-password" id="modifier-password"><i class="fas fa-sync-alt"></i> CHANGER DE MOT DE PASSE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- MODAL SUPPRESION COMPTE -->
        <div class="modal fade" id="modal-supprimer-compte" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger" id="staticBackdropLabel">
                            <i class="fas fa-trash-alt"></i> SUPPRESSION COMPTE
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-mod-sup-compte"></button>
                    </div>
                    <div class="modal-body">
                        <h5 class="alert alert-danger text-center" style="color: rgb(20, 8, 73);">
                            POUR CONFIRMER LA SUPPRESSION DE CE COMPTE, VEUILLEZ ENTRER VOTRE MOT DE PASSE !
                        </h5>
                    </div>
                    <div class="modal-footer">
                        <div class="form-floating">
                            <input class="form-control" type="password" id="pass-sup-compte" name="pass-sup-compte" placeholder="password">
                            <label for="pass-sup-compte">Mot de passe :</label>
                        </div>
                        <button type="button" class="btn btn-danger" id="confirmer-supprimer-compte">Supprimer</button>
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-supprimer-compte">Annuler</button>
                    </div>
                </div>
            </div>
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
                        <div class="form-floating mb-3">
                            <input type="text" name="modifier-nom-complet" id="modifier-nom-complet"
                                   placeholder="Nom et Prénoms :" class="form-control" required>
                            <label class="form-label" for="modifier-nom-complet">Nom et Prénoms</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="tel" name="modifier-cin" id="modifier-cin" placeholder="CIN :"
                                   class="form-control" required>
                            <label class="form-label" for="modifier-cin">N° CIN</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="tel" name="modifier-telephone" id="modifier-telephone" placeholder="Téléphone :"
                                   class="form-control" required>
                            <label class="form-label" for="modifier-telephone">Téléphone</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" name="modifier-sexe" id="modifier-sexe" aria-label="Sexe :">
                                <option value="homme" selected>Homme</option>
                                <option value="femme">Femme</option>
                            </select>
                            <label for="modifier-sexe">Sexe :</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" name="modifier-adresse" id="modifier-adresse" placeholder="Adresse :"
                                   class="form-control" required>
                            <label class="form-label" for="modifier-adresse">Adresse</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="email" name="modifier-mail" id="modifier-mail" placeholder="E-mail:" class="form-control" required>
                            <label class="form-label" for="modifier-mail">E-mail</label>
                        </div>
                        <div class="m-3 text-center mt-4" id="erreur-modif">

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Annuler</button>
                        <button type="button" class="btn btn-info" id="confirmer-modification-compte">Confirmer</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- MODAL AFFICHER SOLDE -->
        <div class="modal fade" id="modal-afficher-solde" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-warning" id="staticBackdropLabel">
                            <i class="fas fa-eye"></i> AFFICHER SOLDE
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-mod-aff-solde"></button>
                    </div>
                    <div class="modal-body">
                        <div class="form-floating">
                            <input class="form-control" type="password" id="pass-aff-solde" name="pass-aff-solde" placeholder="password">
                            <label for="pass-aff-solde">Mot de passe :</label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-afficher-solde">Annuler</button>
                        <button type="button" class="btn btn-warning" id="confirmer-afficher-solde">Afficher</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- MODAL MODIFIER PASSWORD -->
        <div class="modal fade" id="modal-password" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-success" id="staticBackdropLabel">
                            <i class="fas fa-unlock-alt"></i> MODIFIER MOT DE PASSE
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close-mod-pass"></button>
                    </div>
                    <div class="modal-body">
                        <div class="form-floating mb-3">
                            <input class="form-control" type="password" id="ancien-pass" name="ancien-pass" placeholder="password">
                            <label for="ancien-pass">Ancien mot de passe :</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input class="form-control" type="password" id="new-pass" name="new-pass" placeholder="password">
                            <label for="new-pass">Nouveau mot de passe :</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input class="form-control" type="password" id="confirm-new-pass" name="confirm-new-pass" placeholder="password">
                            <label for="confirm-new-pass">Confirmer mot de passe :</label>
                        </div>
                        <div class="m-3 text-center mt-4" id="erreur-pass">

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-modif-pass">Annuler</button>
                        <button type="button" class="btn btn-success" id="confirmer-modif-pass">Changer</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="rounded-pill text-center p-3 bg-success" id="notif" style="position: fixed;top: 8%;left: 47%;z-index: 5;display: none;color: rgb(20, 8, 73);">

        </div>

        <script src="./framework/jquery/jquery.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.min.js"></script>
        <script src="./framework/fontawesome/js/all.min.js"></script>
        <script src="./framework/fontawesome/js/fontawesome.min.js"></script>
        <script src="./js/index.js"></script>
        <script>
            $(document).ready(() => {
                $(document).on("click", "#confirmer-supprimer-compte", () => {
                    var num_compte = $("#numero-compte").val();
                    var password = $("#pass-sup-compte").val();
                    if (password === "") {
                        $("#pass-sup-compte").addClass("border border-danger");
                    } else {
                        $("#pass-sup-compte").removeClass("border border-danger");
                        $.ajax({
                            type: 'POST',
                            url: 'InfoCompte',
                            data: {
                                num_compte: num_compte,
                                password: password,
                                action: "suppression"
                            },
                            success: function (data) {
                                if (data === "incorrect") {
                                    $("#pass-sup-compte").addClass("border border-danger");
                                } else {
                                    $("#close-mod-sup-compte").click();
                                    $("#notif").html('<i class="fas fa-check-circle"></i> COMPTE SUPPRIMER !');
                                    $("#notif").fadeIn(3000, function () {
                                        $("#notif").fadeOut(3000, function () {
                                            window.location.href = "Compte";
                                        });
                                    });
                                }
                            }
                        });
                    }
                });

                $(document).on("click", "#confirmer-afficher-solde", () => {
                    var num_compte = $("#numero-compte").val();
                    var password = $("#pass-aff-solde").val();
                    if (password === "") {
                        $("#pass-aff-solde").addClass("border border-danger");
                    } else {
                        $("#pass-aff-solde").removeClass("border border-danger");
                        $.ajax({
                            type: 'POST',
                            url: 'InfoCompte',
                            data: {
                                num_compte: num_compte,
                                password: password,
                                action: "affichage"
                            },
                            success: function (data) {
                                console.log(data);
                                if (data === "incorrect") {
                                    $("#pass-aff-solde").addClass("border border-danger");
                                } else {
                                    $("#pass-aff-solde").val('');
                                    $("#solde").attr("type", "text");
                                    $("#close-mod-aff-solde").click();
                                    $("#notif").html('<i class="fas fa-check-circle"></i> SOLDE AFFICHER !');
                                    $("#notif").fadeIn(3000, function () {
                                        $("#notif").fadeOut(3000);
                                    });
                                    $("#afficher-solde").html("<i class=\"fas fa-eye-slash\"></i> MASQUER SOLDE");
                                    $("#afficher-solde").attr("data-bs-target", "#");
                                    $("#afficher-solde").attr("id", "hide-solde");
                                }
                            }
                        });
                    }
                });

                $(document).on("click", "#confirmer-modification-compte", () => {
                    var num_compte = $("#numero-compte").val();
                    var nom_et_prenoms = $("#modifier-nom-complet").val();
                    var num_cin = $("#modifier-cin").val();
                    var num_phone = $("#modifier-telephone").val();
                    console.log(num_phone);
                    var sexe = $("#modifier-sexe").val();
                    var adresse = $("#modifier-adresse").val();
                    var email = $("#modifier-mail").val();
                    if (num_cin.length !== 12) {
                        $("#erreur-modif").html('<span class="alert alert-warning">* VEUILLEZ VERIFIER LE NUMERO CIN *</span>');
                    } else if (num_phone.length !== 10) {
                        $("#erreur-modif").html('<span class="alert alert-warning">* VEUILLEZ VERIFIER LE NUMERO DE TELEPHONE *</span>');
                    } else {
                        $("#erreur-modif").html('');
                        $.ajax({
                            type: 'POST',
                            url: 'InfoCompte',
                            data: {
                                num_compte: num_compte,
                                nom_et_prenoms: nom_et_prenoms,
                                num_cin: num_cin,
                                num_phone: num_phone,
                                sexe: sexe,
                                adresse: adresse,
                                email: email,
                                action: "modification"
                            },
                            success: function (data) {
                                $("#nom-et-prenoms").val(data.split("=>")[0]);
                                $("#numero-cin").val(data.split("=>")[1]);
                                $("#numero-telephone").val(data.split("=>")[2]);
                                $("#sexe").val(data.split("=>")[3]);
                                $("#adresse").val(data.split("=>")[4]);
                                $("#email").val(data.split("=>")[5]);
                                $("#close-modal-modif").click();
                                $("#notif").html('<i class="fas fa-check-circle"></i> MODIFICATION REUSSI !');
                                $("#notif").fadeIn(3000, function () {
                                    $("#notif").fadeOut(3000);
                                });
                            }
                        });
                    }
                });

                $(document).on("click", "#confirmer-modif-pass", () => {
                    var num_compte = $("#numero-compte").val();
                    var ancien_pass = $("#ancien-pass").val();
                    var new_pass = $("#new-pass").val();
                    var confirm_pass = $("#confirm-new-pass").val();

                    if (ancien_pass === '' || new_pass === '' || confirm_pass === '') {
                        $("#erreur-pass").html('<span class="alert alert-warning">* TOUS LES CHAMPS SONT OBLIGATOIRES *</span>');
                    } else if (new_pass !== confirm_pass) {
                        $("#erreur-pass").html('<span class="alert alert-warning">* MOT DE PASSE DIFFERENTS *</span>');
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: 'InfoCompte',
                            data: {
                                num_compte: num_compte,
                                ancien_pass: ancien_pass,
                                new_pass: new_pass,
                                action: "password"
                            },
                            success: function (data) {
                                console.log(data);
                                if (data === 'Incorrect') {
                                    $("#erreur-pass").html('<span class="alert alert-warning">* MOT DE PASSE INCORRECT *</span>');
                                } else {
                                    $("#erreur-pass").html('');
                                    $("#password").val(data);
                                    $("#close-mod-pass").click();
                                    $("#notif").html('<i class="fas fa-check-circle"></i> MOT DE PASSE MODIFIER !');
                                    $("#notif").fadeIn(3000, function () {
                                        $("#notif").fadeOut(3000);
                                    });
                                }
                            }
                        });
                    }
                });

                $(document).on("click", "#modifier-compte", () => {
                    $("#modifier-nom-complet").val($("#nom-et-prenoms").val());
                    $("#modifier-cin").val($("#numero-cin").val());
                    $("#modifier-telephone").val($("#numero-telephone").val());
                    $("#modifier-sexe").val($("#sexe").val());
                    $("#modifier-adresse").val($("#adresse").val());
                    $("#modifier-mail").val($("#email").val());
                });

                $(document).on("click", "#hide-solde", () => {
                    $("#solde").attr("type", "password");
                    $("#hide-solde").attr("id", "afficher-solde");
                    $("#afficher-solde").attr("data-bs-target", "#modal-afficher-solde");
                    $("#afficher-solde").html("<i class=\"fas fa-eye\"></i> AFFICHER SOLDE");
                });
            });
        </script>
    </body>

</html>
