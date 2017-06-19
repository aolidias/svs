package sales

import grails.converters.JSON
import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException

class ProdutoController {

    static allowedMethods = [save: "POST", show: "GET", "update": "PUT", "index": "GET"]

    def produtoService;

    def show() {
        Produto produto = Produto.get(params.long("id"))

        if(produto == null){
            render(status: 404, text: 'Produto não encontrado.')
        }else {
            render(produto as JSON)
        }
    }

    def index() {

        def list = Produto.list()
        render(list as JSON)
    }
    
    def showProductsTemplate() {
        render("template": "/product")
    }
    
    def save() {
        JSONObject data = request.JSON
        int status = HttpStatus.CREATED.value()
        String outputMessage = null

        Produto novoProduto = null

        try {
            novoProduto = new Produto(data)
            produtoService.save(novoProduto)
            outputMessage = message(code: "product.form.message.success.creation.id", args: [novoProduto.id])
        } catch (NullPointerException) {
            status = HttpStatus.BAD_REQUEST.value()
            outputMessage = message(code: "default.form.message.error.empty.data")
        } catch (PersistenceException cause) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            outputMessage = message(code: "default.form.message.error.server")

            if (novoProduto?.hasErrors()) {
                status = HttpStatus.BAD_REQUEST.value()
                outputMessage = message(code: "default.form.message.error.validation")
            }
        }

        response.status = status
        render(["message": message(code: outputMessage)] as JSON)
    }

    def update() {
        Produto produto = Produto.findById(params.long("id"))
        JSONObject data = request.JSON
        String outputMessage = null
        int status = HttpStatus.OK.value()

        try {
            produto.nome = data.optString("nome", produto.nome)
            produto.codigo = data.optString("codigo", produto.codigo)
            produto.preco = data.optDouble("preco", produto.preco)
            produto.tipoDoProduto = data?.tipoDoProduto
            produtoService.update(produto)
            outputMessage = message(code: "product.message.success.update", args: [produto.id])
        } catch (NullPointerException cause) {
            outputMessage = message(code: "default.form.message.error.empty.data")
        } catch (Exception cause) {
            outputMessage = message(code: "default.form.message.error.validation")

            if (!produto?.hasErrors()) {
                status = HttpStatus.INTERNAL_SERVER_ERROR.value()
                outputMessage = message(code: "default.form.message.error.server")
            }
        }

        response.status = status
        render(["message": outputMessage] as JSON)
    }

}
