principalApp.controller('salesController', ['$scope', 'salesService', 'productService', 'clientService', '$routeParams', function ($scope, salesService, productService, clientService, $routeParams) {

    $scope.selected = undefined;
    $scope.selectedProduct = undefined;

    $scope.products = [];
    $scope.productsName = [];

    $scope.clients = [];
    $scope.clientsName = [];

    $scope.sale = {};
    $scope.sale.produtos = [];
    $scope.sales = [];

    $scope.initializePurchase = function () {
        $scope.sale = {};
        $scope.sale.produtos = [];
        $scope.sale.total = 0;
        $scope.sale.desconto = 0;
    }

    $scope.initializePurchase();

    $scope.sales = salesService.listSales();

    productService.listOpenProducts().then(function (data) {
        $scope.products = data;
        data.forEach(function (element) {
            $scope.productsName.push(element.nome);
        });
    });

    clientService.listOpenClients().then(function (data) {
        $scope.clients = data;
        data.forEach(function (element) {
            $scope.clientsName.push(element.nome);
        });

        if ($routeParams.client_id) {
            var selectedClient = $scope.clients.filter(function (element) {
                return element.id == $routeParams.client_id;
            });

            if (selectedClient) {
                $scope.selectedClient = selectedClient[0];
                $scope.sale.cliente = $routeParams.client_id;
                $scope.client = selectedClient[0].nome;
            }
        }
    });


    function checkName(product) {
        return product.nome === $scope.product;
    }

    function checkClientName(client) {
        return client.nome === $scope.client;
    }


    $scope.setProduct = function (product) {
        var filtered = $scope.products.filter(checkName);
        if (filtered) {
            $scope.selectedProduct = filtered[0];
        }
    };

    $scope.setClient = function (client) {
        var filtered = $scope.clients.filter(checkClientName);
        if (filtered && filtered.length > 0) {
            $scope.selectedClient = filtered[0];
            $scope.sale.client_id = filtered[0].id;
        }
    };


    $scope.removeFromPurchase = function (product, index) {
        $scope.sale.produtos.splice(index, 1);
        $scope.sale.total = $scope.sale.total - (product.preco * product.quantity);
    };

    $scope.addToPurchase = function () {
        $scope.selectedProduct.quantity = $scope.quantity;

        var existingQuantity = 0;

        for (var i = 0; i < $scope.sale.produtos.length; i++) {
            var element = $scope.sale.produtos[i];
            if (element.nome === $scope.selectedProduct.nome) {
                existingQuantity = element.quantity;
                $scope.sale.produtos.splice(i, 1);
                $scope.sale.total = $scope.sale.total - (element.preco * element.quantity);
            }
        }

        if (existingQuantity > 0) {
            $scope.selectedProduct.quantity = parseInt($scope.selectedProduct.quantity) + parseInt($scope.quantity);
        }

        $scope.sale.produtos.push($scope.selectedProduct);
        $scope.sale.total = $scope.sale.total + $scope.selectedProduct.preco * $scope.selectedProduct.quantity;
    };

    $scope.finalize = function () {
        var venda = {
            "cliente": {"id": $scope.sale.client_id},
            "total": $scope.sale.total,
            "desconto": $scope.sale.desconto
        };
        venda.produtos = [];
        $scope.sale.produtos.forEach(function (element) {
            venda.produtos.push({"produto": {"id": element.id}, "quantidade": element.quantity});
        });
        salesService.createSale(venda).then(function (data) {
                self.listSales();
                $scope.sale = {};
                $scope.sale.produtos = [];
                $scope.sale.total = 0;
                $scope.sale.desconto = 0;
                $scope.client = undefined;
                $scope.quantity = 0;
                $scope.product = undefined;

            },
            function (errResponse) {
                alert(errResponse)
            }
        );
    };


    self.listSales = function () {
        salesService.listSales()
            .then(
                function (d) {
                    $scope.sales = d;
                },
                function (errResponse) {
                    window.alert("Deu ruim");
                }
            );
    };

    self.listSales();

}]);
