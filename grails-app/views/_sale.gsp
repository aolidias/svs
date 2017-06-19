<div ng-controller="salesController">
  <div class="panel panel-default">
    <div class="panel-heading-per"><span class="lead">Registo de Venda</span></div>
    <div class="formcontainer">
      <form name="myForm" class="form-horizontal">
        <input type="hidden" ng-model="sales.client.id" />
        <div class="row">
          <div class="form-group col-md-7">
            <label class="col-md-2 control-lable" for="name">Cliente</label>
            <div class="col-md-4">
              <input class="form-control" type="text" data-provide="typeahead" data-items="15" placeholder="Nome do cliente" autocomplete="off" data-source='{{ clientsName }}' ng-model="client" ng-change='setClient(client)'/>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-7">
            <label class="col-md-2 control-lable" for="name">Produto</label>
            <div class="col-md-4">
              <input class="form-control" type="text" data-provide="typeahead" data-items="15" placeholder="Nome do produto" autocomplete="off" data-source='{{ productsName }}' ng-model="product" ng-change='setProduct(product)'/>
            </div>
            <div class="col-md-2">
              <input type="text" class="form-control" ng-model="quantity" />
            </div>
            <div class="col-md-2">
              <button class="btn btn-success" ng-click="addToPurchase()">Adicionar</button>
            </div>
            <div class="col-md-2" ng-show="sale.produtos.length > 0">
              <button class="btn btn-succes" ng-click="finalize()">Finalizar</button>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-7">
            <label class="col-md-2 control-lable" for="desconto">Desconto</label>
            <div class="col-md-4">
              <input type="number" ng-model="sale.desconto" name="desconto" id="desconto" class="form-control input-sm"   />
            </div>
          </div>
        </div>
        <!-- <div class="row">
          <div class="form-actions floatRight">
            <input type="submit" value="{{!sales.sale.id ? 'Salvar' : 'Alterar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
          </div>
        </div> -->
      </form>
    </div>

  </div>
  <div class="panel panel-default" ng-show="sale.produtos.length > 0">
    <div class="panel-heading-per"><span class="lead">Items da Venda</span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Produto</th>
            <th>Preço</th>
            <th>Quantidade</th>
            <th width="20%"></th>
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat="p in sale.produtos track by $index">
            <td><span ng-bind="p.id"></span></td>
            <td><span ng-bind="p.nome"></span></td>
            <td><span ng-bind="p.preco"></span></td>
            <td><span ng-bind="p.quantity"></span></td>
            <td><span ng-click="removeFromPurchase(p,$index)">Remover</span></td>
          </tr>
          <tr>
            <td>Total: R$ {{ sale.total }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

  <div class="panel panel-default" ng-show="sales.length > 0">
    <div class="panel-heading-per"><span class="lead">Lista de Vendas</span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>Cliente</th>
            <th>Total de Produtos</th>
            <th>Desconto</th>
            <th>Data da venda</th>
            <th>Vendedor</th>
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat="s in sales">
            <td><span ng-bind="s.cliente.nome"></span></td>
            <td>R$ <span ng-bind="s.total"></span></td>
            <td>R$ <span ng-bind="s.desconto"></span></td>
            <td><span ng-bind="s.data"></span></td>
            <td><span ng-bind="s.usuario.login"></span></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>


</div>
