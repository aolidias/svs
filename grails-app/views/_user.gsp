<div ng-controller="userController as us">
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Registro de Usuário </span></div>
    <div class="formcontainer">
      <form ng-submit="us.submit()" name="myForm" class="form-horizontal">
        <input type="hidden" ng-model="us.user.id" />
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="login">Login</label>
            <div class="col-md-7">
              <input type="text" ng-model="us.user.login" id="login" name="login" class="form-control input-sm" placeholder="Entre com o login do usuário" required ng-minlength="3" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">This is a required field</span>
                <span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                <span ng-show="myForm.name.$invalid">This field is invalid </span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="senha">Senha</label>
            <div class="col-md-7">
              <input type="password" ng-model="us.user.senha" id="senha" name="senha" class="form-control input-sm" placeholder="Entre com a senha" required ng-minlength="3" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">This is a required field</span>
                <span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                <span ng-show="myForm.name.$invalid">This field is invalid </span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="tipo">Tipo</label>
            <div class="col-md-7">
              <select ng-model="us.user.tipoDoUsuario" id="tipo" class="form-control" ng-init="us.user.tipoDoUsuario='VENDEDOR'" ng-options="type for type in us.types"></select>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$error.minlength">Tamanho mínimo - 3 caracteres</span>
                <span ng-show="myForm.name.$invalid">Campo inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-actions floatRight">
            <input type="submit" value="{{!us.user.id ? 'Salvar' : 'Alterar'}}" class="btn btn-success btn-sm" ng-disabled="myForm.$invalid">
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="panel panel-default" ng-show="us.users.length > 0">
    <div class="panel-heading-per"><span class="lead">Lista de Usuários</span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Tipo do Usuário</th>
            <th width="20%"></th>
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat="u in us.users">
            <td><span ng-bind="u.id"></span></td>
            <td><span ng-bind="u.login"></span></td>
            <td><span ng-bind="u.tipoDoUsuario.name"></span></td>
            <td>
              <button type="button" ng-click="us.edit(u.id)" class="btn btn-success custom-width">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
