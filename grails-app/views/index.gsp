<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <!-- <base href="/svs/"> -->
</head>

<body>

<ng-app ng-app="principalApp">
<div ng-controller="indexController as index">
            <nav class="navbar navbar-inverse navbar-fixed-top navbar-svs">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#navbar"
                                aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand svs-a" href="#">Sales-Manager</a>
                    </div>

                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="/productCrud" class="svs-a">Produto</a></li>
                            <li><a href="/clientCrud" class="svs-a">Cliente</a></li>
                            <li><a href="/userCrud" class="svs-a">Usuário</a></li>
                            <li><a href="/saleCrud" class="svs-a">Venda</a></li>
                            <li><a href="/stockCrud" class="svs-a">Estoque</a></li>
                            <li><a href ng-click="index.logout()" class="svs-a">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

        <div style="margin: 75px 50px 50px 50px" ng-view> </div>
        </div>
</ng-app>

</body>
</html>


