<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <style>
        html, body, .container-table {
            height: 100% !important;
        }
        .container-table {
          display: table;
        }
        .vertical-center-row {
          display: table-cell;
          vertical-align: middle;
        }
    </style>
    <r:require modules="bootstrap"/>
    <r:require modules="angularComplete"/>
    <r:require modules="principal"/>
</head>
<body>
<ng-app ng-app="principalApp">
<div class="container container-table" ng-controller="loginController as log">
  <div class="row vertical-center-row">
    <div class="col-xs-4 col-xs-offset-4">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Login - SVS</h3>
        </div>
        <div class="panel-body">
          <form accept-charset="UTF-8" name="myForm" ng-submit="log.submit()">
            <fieldset>
              <div class="form-group">
                <input class="form-control" placeholder="Login" ng-model="log.login.login" name="login" type="text">
              </div>

              <div class="form-group">
                <input class="form-control" placeholder="Password" name="password" type="password" ng-model="log.login.senha">
              </div>

              <div class="form-group">
                <span ng-show="log.loginError">Usuário ou senha inválidos!</span>
              </div>

              <input type="submit" class="btn btn-lg btn-success btn-block" value="Login">
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</ng-app>
</body>
</html>
