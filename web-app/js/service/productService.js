principalApp.factory('productService', ['$http', '$q', function($http, $q){

    return {

        listProducts: function() {
            return $http.get('http://localhost:8080/svs/api/produtos/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('DEU RUIM');
                        return $q.reject(errResponse);
                    }
                );
        },

        listOpenProducts: function() {
            return $http.get('http://localhost:8080/svs/api/products/list')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('DEU RUIM');
                        return $q.reject(errResponse);
                    }
                );
        },


        createProduct: function(product){
            return $http.post('http://localhost:8080/svs/api/produtos/', product)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating product');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateProduct: function(product, id){
            return $http.put('http://localhost:8080/svs/api/produtos/'+id, product)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating products');
                        return $q.reject(errResponse);
                    }
                );
        },



    };

}]);
