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

<div class="container container-table">
  <div class="row vertical-center-row">
    <div class="col-xs-4 col-xs-offset-4">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Erro - SVS</h3>
        </div>
        <div class="panel-body">
          <form accept-charset="UTF-8" name="myForm">
            <fieldset>
              <div class="form-group">
                <span>Acesso não autorizado!</span>
              </div>
              <div class="form-group">
                <a href="/svs/index" class="svs-a">Voltar página principal</a>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
