<%-- 
    Document   : login
    Created on : 9 mars 2023, 08:22:18
    Author     : Mamy Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./framework/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="./framework/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="./css/style.css">
        <title>PAGES DE CONNEXION</title>
    </head>

    <body>
        <div class="container mt-5">
            <div class="row m-5"></div>
            <div class="row m-5"></div>
            <div class="row m-5"></div>
            <div class="row m-5"></div>
            <div class="row">
                <div class="col-7 col-sm-6 col-lg-4 p-5" id="login-form">
                    <legend class="text-center h2 text-info mb-4"><i class="fas fa-sign-in-alt"></i> CONNEXION</legend>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control form-control-lg" id="username" placeholder="Pseudo">
                        <label for="username"><i class="far fa-user-circle"></i> Pseudo</label>

                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control form-control-lg" id="password" placeholder="your password">
                        <label for="password"><i class="fas fa-lock"></i> Mot de passe</label>
                    </div>
                    <div class="row m-3">
                        <button class="btn btn-sm btn-info" id="connect">SE CONNECTER</button>
                    </div>
                    <div class="row mt-3 mx-auto">
                        <div class="col-5 ms-4">
                            <a href="#" class="link-info" data-bs-toggle="modal" data-bs-target="#createAccount">Créer compte</a>
                        </div>
                        <div class="col">
                            <a href="#" class="link-danger" data-bs-toggle="modal" data-bs-target="#changePassword">Mot de passe oublié</a>
                        </div>
                    </div>
                </div>
                <div class="col-7 col-sm-6 col-lg-4 p-5 offset-2 my-auto bg-danger rounded-pill text-center text-light" id="error" style="position: fixed;top: 35%;left: 35%;display: none;z-index: 5;color: rgb(20, 8, 73);">
                    <b>MOT DE PASSE OU NOM D'UTILISATEUR INCORRECT</b>
                </div>

                <!-- Modal for create account-->
                <div class="modal fade" id="createAccount" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel"><i class="fas fa-user-plus"></i> CREER COMPTE</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="cls-1"></button>
                            </div>
                            <div class="modal-body">
                                <form action="" class="row">
                                    <div class="form-floating my-2">
                                        <input type="text" class="form-control" name="new_name" id="new_name" placeholder="Nom complet:">
                                        <label for="new_name"><i class="far fa-user-circle"></i> Nom complet : </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="text" class="form-control" name="new_username" id="new_username" placeholder="Nom d'utilisateur:">
                                        <label for="new_username"><i class="far fa-user-circle"></i> Pseudo : </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="email" class="form-control" name="new_mail" id="new_mail" placeholder="Adresse mail :">
                                        <label for="new_mail"><i class="far fa-envelope"></i> Adresse mail : </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="password" class="form-control" name="new_password" id="new_password" placeholder="Mot de passe:">
                                        <label for="new_password"><i class="fas fa-unlock-alt"></i> Mot de passe : </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="password" class="form-control" name="password_confirmation" id="password_confirmation" placeholder="Confirmer mot de passe:">
                                        <label for="password_confirmation"><i class="fas fa-unlock-alt"></i> Confirmer mot de passe : </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="password" class="form-control" name="approbation" id="approbation" placeholder="Confirmer mot de passe:">
                                        <label for="approbation"><i class="fas fa-unlock-alt"></i> Approbation : </label>
                                    </div>
                                    <div id="new_user_error" class="text-center p-3">

                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler">Annuler</button>
                                <button class="btn btn-info" id="confirm_new_user">Enregistrer</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal for change password -->
                <div class="modal fade" id="changePassword" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel"><i class="fas fa-lock"></i> MOT DE PASS OUBLIE</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="cls-2"></button>
                            </div>
                            <div class="modal-body">
                                <form action="" class="row">
                                    <div class="form-floating my-2">
                                        <input type="text" class="form-control" name="new-username" id="new-name" placeholder="Nom d'utilisateur:">
                                        <label for="new-username"><i class="far fa-user-circle"></i> Nom complet: </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="text" class="form-control" name="new-mail" id="new-mail" placeholder="Adresse e-mail:">
                                        <label for="new-mail"><i class="far fa-envelope"></i> Adresse e-mail: </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="password" class="form-control" name="new-password" id="new-password" placeholder="Mot de passe:">
                                        <label for="new-password"><i class="fas fa-unlock-alt"></i> Nouveau mot de passe: </label>
                                    </div>
                                    <div class="form-floating my-2">
                                        <input type="password" class="form-control" name="password-confirmation" id="password-confirmation" placeholder="Confirmer mot de passe:">
                                        <label for="password-confirmation"><i class="fas fa-unlock-alt"></i> Confirmer mot de passe: </label>
                                    </div>
                                    <div id="new-user-error" class="text-center p-3">

                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler">Annuler</button>
                                <button class="btn btn-info" id="change_pass">Enregistrer</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="./framework/jquery/jquery.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.min.js"></script>
        <script src="./framework/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./framework/fontawesome/js/all.min.js"></script>
        <script>
            $(document).ready(() => {
                setInterval(() => {
                    $("legend").fadeOut(1000, () => {
                        $("legend").fadeIn(1000);
                    });
                }, 2000);

                $(document).on("click", "#connect", () => {
                    var user = $("#username").val();
                    var password = $("#password").val();
                    console.log(user, password);
                    if (user === '' || password === '') {
                        $("#error").removeClass("bg-danger");
                        $("#error").addClass("bg-warning");
                        $("#error").html('<b>TOUS LES CHAMPS SONT OBLIGATOIRES !</b>');
                        $("#error").fadeIn(1000, function () {
                            $("#error").fadeOut(2500);
                        });
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: 'Login',
                            data: {
                                pseudo: user,
                                password: password,
                                action: "login"
                            },
                            success: function (data) {
                                if (data === 'not logged') {
                                    $("#error").removeClass("bg-success");
                                    $("#error").removeClass("bg-warning");
                                    $("#error").addClass("bg-danger");
                                    $("#error").html('<b>MOT DE PASSE INCORRECT !</b>');
                                    $("#error").fadeIn(1000, function () {
                                        $("#error").fadeOut(1500);
                                    });
                                } else if (data === 'pseudo error') {
                                    $("#error").removeClass("bg-success");
                                    $("#error").removeClass("bg-warning");
                                    $("#error").addClass("bg-danger");
                                    $("#error").html('<b>UTILISATEUR NON RECONNU !</b>');
                                    $("#error").fadeIn(1000, function () {
                                        $("#error").fadeOut(1500);
                                    });
                                } else {
                                    $("#error").removeClass("bg-danger");
                                    $("#error").removeClass("bg-warning");
                                    $("#error").addClass("bg-success");
                                    $("#error").html('<b>BIENEVENUE - VOUS ETES CONNECTE</b>');
                                    $("#error").fadeIn(1000, function () {
                                        $("#error").fadeOut(1500, function () {
                                            window.location.href = "Accueil";
                                        });
                                    });
                                }
                            }
                        });
                    }
                });

                $(document).on("click", "#confirm_new_user", () => {
                    var nom_et_prenoms = $("#new_name").val();
                    var pseudo = $("#new_username").val();
                    var mail = $("#new_mail").val();
                    var password = $("#new_password").val();
                    var confirm_pass = $("#password_confirmation").val();
                    var approbation = $("#approbation").val();

                    if (nom_et_prenoms === '' || pseudo === '' || mail === '' || password === '' || confirm_pass === '' || approbation === '') {
                        $("#new_user_error").html('<span class="alert alert-warning">* LES CHAMPS SONT OBLIGATOIRES *</span>');
                    } else if (password.length < 8) {
                        $("#new_user_error").html('<span class="alert alert-warning">* MOT DE PASSE TROP COURT (doit être >= 8) *</span>');
                    } else if (password !== confirm_pass) {
                        $("#new_user_error").html('<span class="alert alert-warning">* MOT DE PASSE NON IDENTIQUE *</span>');
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: 'Login',
                            data: {
                                nom_et_prenoms: nom_et_prenoms,
                                pseudo: pseudo,
                                mail: mail,
                                password: password,
                                approbation: approbation,
                                action: "create"
                            },
                            success: function (data) {
                                if (data !== "ok") {
                                    $("#new_user_error").html('<span class="alert alert-danger">* VERIFIER LE MOT DE PASSE D\'APPROBATION ADMIN *</span>');
                                } else {
                                    $("#cls-1").click();
                                    $("#error").removeClass("bg-danger");
                                    $("#error").removeClass("bg-warning");
                                    $("#error").addClass("bg-success");
                                    $("#error").html('<b>COMPTE CREER AVEC SUCCESS</b>');
                                    $("#error").fadeIn(1000, function () {
                                        $("#error").fadeOut(2000);
                                    });
                                }
                            }
                        });
                    }
                });

                $(document).on("click", "#change_pass", () => {
                    var nom_et_prenoms = $("#new-name").val();
                    var mail = $("#new-mail").val();
                    var password = $("#new-password").val();
                    var confirm_pass = $("#password-confirmation").val();
                    
                    if (nom_et_prenoms === '' || mail === '' || password === '' || confirm_pass === '') {
                        $("#new-user-error").html('<span class="alert alert-warning">* LES CHAMPS SONT OBLIGATOIRES *</span>');
                    } else if (password.length < 8) {
                        $("#new-user-error").html('<span class="alert alert-warning">* MOT DE PASSE TROP COURT (doit être >= 8) *</span>');
                    } else if (password !== confirm_pass) {
                        $("#new-user-error").html('<span class="alert alert-warning">* MOT DE PASSE NON IDENTIQUE *</span>');
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: 'Login',
                            data: {
                                nom_et_prenoms: nom_et_prenoms,
                                mail: mail,
                                password: password,
                                action: "change"
                            },
                            success: function (data) {
                                if (data !== "ok") {
                                    $("#new-user-error").html('<span class="alert alert-danger">* VERIFIER VOS IDENTIFIANTS *</span>');
                                } else {
                                    $("#cls-2").click();
                                    $("#error").removeClass("bg-danger");
                                    $("#error").removeClass("bg-warning");
                                    $("#error").addClass("bg-success");
                                    $("#error").html('<b>MOT DE PASSE MODIFIE CORRECTEMENT</b>');
                                    $("#error").fadeIn(1000, function () {
                                        $("#error").fadeOut(2000);
                                    });
                                }
                            }
                        });
                    }
                });
            });
        </script>
    </body>

</html>
