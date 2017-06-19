<div ng-controller="productController as prod">
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Registro de Produto </span></div>
    <div class="formcontainer">
      <form ng-submit="prod.submit()" name="myForm" class="form-horizontal">
        <input type="hidden" ng-model="prod.product.id" />
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="name">Nome</label>
            <div class="col-md-7">
              <input type="text" ng-model="prod.product.nome" name="name" class="form-control input-sm" placeholder="Entre com o nome do produto" required ng-minlength="3" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$error.minlength">Tamanho mínimo - 3 caracteres</span>
                <span ng-show="myForm.name.$invalid">Campo inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="codigo">Código</label>
            <div class="col-md-7">
              <input type="text" ng-model="prod.product.codigo" id="codigo" name="codigo" class="form-control input-sm" placeholder="Entre com o código do produto"  />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$invalid">Campo inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="tipo">Tipo</label>
            <div class="col-md-7">
              <select ng-model="prod.product.tipoDoProduto" id="tipo" class="form-control" ng-init="prod.product.tipo='ACESSO'" ng-options="type for type in prod.types"></select>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$error.minlength">Tamanho mínimo - 3 caracteres</span>
                <span ng-show="myForm.name.$invalid">Campo inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="codigo">Preço</label>
            <div class="col-md-7">
              <input type="number" ng-model="prod.product.preco" name="preco" class="form-control input-sm" placeholder="Entre com o preço do produto" />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.name.$error.required">Campo obrigatório</span>
                <span ng-show="myForm.name.$invalid">Campo inválido</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-actions floatRight">
            <input type="submit" value="{{!prod.product.id ? 'Salvar' : 'Alterar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Lista de Produtos </span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Código</th>
            <th>Tipo</th>
            <th>Preço</th>
            <th width="20%"></th>
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat="p in prod.products">
            <td><span ng-bind="p.id"></span></td>
            <td><span ng-bind="p.nome"></span></td>
            <td><span ng-bind="p.codigo"></span></td>
            <td><span ng-bind="p.tipo.name"></span></td>
            <td><span ng-bind="p.preco"></span></td>
            <td>
              <button type="button" ng-click="prod.edit(p.id)" class="btn btn-success custom-width">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
