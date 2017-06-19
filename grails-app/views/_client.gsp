<div ng-controller="clientController as clie">
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Registo do Cliente</span></div>
    <div class="formcontainer">
      <form ng-submit="clie.submit()" name="myForm" class="form-horizontal">
        <input type="hidden" ng-model="clie.client.id" />
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="name">Nome</label>
            <div class="col-md-7">
              <input type="text" ng-model="clie.client.nome" name="name" class="form-control input-sm" placeholder="Entre com o nome do cliente" required ng-minlength="3" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$error.minlength">Tamanho mínimo de 3 caracteres</span>
                <span ng-show="myForm.name.$invalid">O campo é inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="address">Endereço</label>
            <div class="col-md-7">
              <input type="text" ng-model="clie.client.endereco" name="address" class="form-control input-sm" placeholder="Entre com o endereço do cliente" required ng-minlength="3" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$error.minlength">Tamanho mínimo de 3 caracteres</span>
                <span ng-show="myForm.name.$invalid">O campo é inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="phone">Telefone</label>
            <div class="col-md-7">
              <input type="text" ng-model="clie.client.telefone" name="telefone" class="form-control bfh-phone">
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$error.minlength">Tamanho mínimo de 3 caracteres</span>
                <span ng-show="myForm.name.$invalid">O campo é inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="birthday">Data de Nascimento</label>
            <div class="col-md-7">
              <input ng-model="clie.client.dataDeNascimento" name="birthday" id="birthday" class="form-control" type="text" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">This is a required field</span>
                <span ng-show="myForm.name.$invalid">This field is invalid</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="email">E-mail</label>
            <div class="col-md-7">
              <input type="email" ng-model="clie.client.email" name="email" class="form-control input-sm" placeholder="Entre com o email do cliente" required ng-minlength="3" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">This is a required field</span>
                <span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                <span ng-show="myForm.name.$invalid">This field is invalid</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="cpf">Cpf</label>
            <div class="col-md-7">
              <input type="text" ng-model="clie.client.cpf" name="cpf" id="cpf" class="form-control input-sm" placeholder="Entre com o cpf do cliente"/>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">This is a required field</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="peso">Peso</label>
            <div class="col-md-7">
              <input type="number" ng-model="clie.client.peso" name="peso" class="form-control input-sm" placeholder="Entre com o peso do cliente" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$invalid">This field is invalid</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="altura">Altura</label>
            <div class="col-md-7">
              <input type="number" ng-model="clie.client.altura" name="altura" class="form-control input-sm" placeholder="Entre com a altura do cliente" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$invalid">This field is invalid</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-actions floatRight">
            <input type="submit" value="{{!clie.client.id ? 'Salvar' : 'Alterar'}}" class="btn btn-success btn-sm" ng-disabled="myForm.$invalid">
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Lista de clientes</span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Nascimento</th>
            <th>Telefone</th>
            <th>E-Mail</th>
            <th>Peso</th>
            <th>Altura</th>
            <th>CPF</th>
            <th>Ação</th>
            <th>Venda</th>
            
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat="c in clie.clients">
            <td><span ng-bind="c.id"></span></td>
            <td><span ng-bind="c.nome"></span></td>
            <td><span ng-bind="c.endereco"></span></td>
            <td><span readonly="true" ng-bind="c.dataDeNascimento | amDateFormat:'DD/MM/YYYY'"></span></td>
            <td><span ng-bind="c.telefone"></span></td>
            <td><span ng-bind="c.email"></span></td>
            <td><span ng-bind="c.peso"></span></td>
            <td><span ng-bind="c.altura"></span></td>
            <td><span ng-bind="c.cpf"></span></td>
            <td>
              <button type="button" ng-click="clie.edit(c.id)" class="btn btn-success custom-width">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
