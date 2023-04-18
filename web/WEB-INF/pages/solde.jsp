<%-- 
    Document   : solde
    Created on : 9 mars 2023, 09:11:06
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
    <title>CONSULTATION DE SOLDE</title>
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
                    <a href="Solde" style="background-color: cyan; color: rgb(20, 8, 73); border-radius: 30px 0 0 30px;">
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
                <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i><span id="titre"> SOLDE</span></div>
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
            <div class="row mx-auto w-75 bg-white p-5 rounded " style="margin-top: 5%;">
                <div class="row">
                    <div class="col-4 offset-2">
                        <div class="row">
                            <label for="mot-de-passe" class="col col-form-label">Mot de passe : </label>
                            <div class="col">
                                <input type="password" class="form-control" id="mot-de-passe">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="input-group mb-3">
                            <input type="search" class="form-control" placeholder="Nom complet ou Numéro bancaire ..." id="identifiant">
                            <button class="btn" type="button" id="verifier-solde"><i class="fas fa-search"></i></button>
                        </div>
                    </div>
                </div>
            
                <div class="card p-5 text-white" style="background-color: rgb(20, 8, 73);">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="./img/solde.jpg" class="img-fluid border border-light" alt="profile">
                        </div>
                        <div class="col-md-8 my-auto" id="info-solde">
                            <div class="card-body">
                                <h5 class="card-title h2 text-center text-info">
                                    <i class="fas fa-address-card"></i> CARD ID : <span>?</span>
                                </h5>
                                <p class="card-text text-center mt-5 h5">
                                    Le solde de votre compte est de : <span>?</span> Ariary.
                                </p>
                            </div>
                            <div class="card-footer mt-5 text-end">
                                <span class="h6 mark rounded p-2" style="color: rgb(20, 8, 73);">Nom : <span>?</span><span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="./framework/jquery/jquery.js"></script>
    <script src="./framework/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="./framework/bootstrap/js/bootstrap.min.js"></script>
    <script src="./framework/fontawesome/js/all.min.js"></script>
    <script src="./framework/fontawesome/js/fontawesome.min.js"></script>
    <script src="./js/index.js"></script>
    <script>
        $(document).ready(()=>{
            $(document).on("click", "#verifier-solde", function(){
                var identifiant = $("#identifiant").val();
                var password = $("#mot-de-passe").val();
                $.ajax({
                    type: 'POST',
                    url: 'Solde',
                    data: {
                        identifiant: identifiant,
                        password: password
                    },
                    success: function (data) {
                        $("#info-solde").html(data);
                    }
                });
            });
        });
    </script>
</body>

</html>
