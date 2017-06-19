<div ng-controller="stockController as stock">
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Estoque de produtos </span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Código</th>
            <th>Quantidade</th>
            <th width="20%"></th>
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat="p in stock.products">
            <td><span ng-bind="p.id"></span></td>
            <td><span ng-bind="p.produto.nome"></span></td>
            <td><span ng-bind="p.produto.codigo"></span></td>
            <td ng-hide="stock.editMode"><span ng-bind="p.quantidade"></span></td>
            <td ng-show="stock.editMode"><input type="number" ng-model="p.quantidade" class="form-control"></input></td>
            <td>
              <button type="button" ng-hide="stock.editMode" ng-click="stock.editMode=true" class="btn btn-success custom-width">Editar</button>
              <button type="button" ng-show="stock.editMode" ng-click="stock.edit(p.id, p.quantidade)" class="btn btn-success custom-width">Confirmar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
