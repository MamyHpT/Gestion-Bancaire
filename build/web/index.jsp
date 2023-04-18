<%-- 
    Document   : index
    Created on : 9 mars 2023, 07:51:53
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
        <title>PAGES D'ACCUEIL</title>
    </head>

    <body>
        <%
            HttpSession s = request.getSession();
            String pseudo = (String) s.getAttribute("pseudo");
            if(pseudo == null){
                %>
                    <c:redirect url="Login"/>
                <%
            }
        %>
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
                        <a href="Acuueil" style="background-color: cyan; color: rgb(20, 8, 73); border-radius: 30px 0 0 30px;">
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
                    <div class="btn-lg h6" id="menu-btn"><i class="fas fa-bars"></i> ACCUEIL</div>
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
            <div class="row pb-5 ps-3">
                <div class="row mx-auto bg-white p-3 rounded row-cols-1 row-cols-md-3 g-4" id="card-accueil">
                    <div class="col">
                        <div class="card h-100 border border-info rounded border-5"
                             style="background-color: rgb(20, 8, 73); color: white;">
                            <img src="./img/mon-compte.jpg" class="card-img-top" alt="image">
                            <div class="card-body">
                                <h5 class="card-title text-center text-info">COMPTES</h5>
                                <p class="card-text">Voir les informations concernant tous les comptes !</p>
                            </div>
                            <div class="card-footer">
                                <a href="Compte" class="btn btn-sm btn-outline-light" type="button">
                                    <i class="far fa-user-circle"></i> COMPTES <span class="spinner-grow spinner-grow-sm text-info" role="status" aria-hidden="true"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100 border border-info rounded border-5"
                             style="background-color: rgb(20, 8, 73); color: white;">
                            <img src="./img/depot.jpg" class="card-img-top" alt="image">
                            <div class="card-body">
                                <h5 class="card-title text-center text-info">VERSEMENT</h5>
                                <p class="card-text">Faire un versement !</p>
                            </div>
                            <div class="card-footer">
                                <a href="Versement" class="btn btn-sm btn-outline-light" type="button" id="versement">
                                    <i class="fas fa-piggy-bank"></i> VERSEMENT <span class="spinner-grow spinner-grow-sm text-info" role="status" aria-hidden="true"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100 border border-info rounded border-5"
                             style="background-color: rgb(20, 8, 73); color: white;">
                            <img src="./img/retrait.jpg" class="card-img-top" alt="image">
                            <div class="card-body">
                                <h5 class="card-title text-center text-info">RETRAIT</h5>
                                <p class="card-text">Faire un retrait simple, rapide et sécurisé en un clin d'oeil !</p>
                            </div>
                            <div class="card-footer">
                                <a href="Retrait" class="btn btn-sm btn-outline-light" type="button" id="retrait">
                                    <i class="fas fa-dollar-sign"></i> RETRAIT <span class="spinner-grow spinner-grow-sm text-info" role="status" aria-hidden="true"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100 border border-info rounded border-5"
                             style="background-color: rgb(20, 8, 73); color: white;">
                            <img src="./img/transfert.jpg" class="card-img-top" alt="image">
                            <div class="card-body">
                                <h5 class="card-title text-center text-info">TRANSFERT</h5>
                                <p class="card-text">Transéfer de l'argent à vous correspondant sans se déplacer.</p>
                            </div>
                            <div class="card-footer">
                                <a href="Transfert" class="btn btn-sm btn-outline-light" type="button" id="transfert">
                                    <i class="fas fa-exchange-alt"></i> TRANSFERT <span class="spinner-grow spinner-grow-sm text-info" role="status" aria-hidden="true"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100 border border-info rounded border-5"
                             style="background-color: rgb(20, 8, 73); color: white;">
                            <img src="./img/solde.jpg" class="card-img-top" alt="image">
                            <div class="card-body">
                                <h5 class="card-title text-center text-info">SOLDE</h5>
                                <p class="card-text">Vérifier l'état de votre solde instantanément</p>
                            </div>
                            <div class="card-footer">
                                <a href="Solde" class="btn btn-sm btn-outline-light" type="button" id="solde">
                                    <i class="fas fa-money-bill-alt"></i> SOLDE <span class="spinner-grow spinner-grow-sm text-info" role="status" aria-hidden="true"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100 border border-info rounded border-5"
                             style="background-color: rgb(20, 8, 73); color: white;">
                            <img src="./img/operation.jpg" class="card-img-top" alt="image">
                            <div class="card-body">
                                <h5 class="card-title text-center text-info">OPERATION</h5>
                                <p class="card-text">Vous pouvez revisionnez le tableau de bord de votre activité ici !</p>
                            </div>
                            <div class="card-footer">
                                <a href="Operation" class="btn btn-sm btn-outline-light" type="button" id="operation">
                                    <i class="fas fa-tasks"></i> OPERATION <span class="spinner-grow spinner-grow-sm text-info" role="status" aria-hidden="true"></span>
                                </a>
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
    </body>

</html>
