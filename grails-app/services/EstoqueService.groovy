import grails.transaction.Transactional
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject
import sales.Estoque
import sales.Produto
import sales.ProdutoVenda

import javax.persistence.PersistenceException

@Transactional
class EstoqueService {


    public void save(id, quantidade)
            throws NullPointerException, PersistenceException {


        Estoque estoqueBanco = Estoque.findById(id);
        estoqueBanco.quantidade = quantidade;

        try {
            if (!estoqueBanco.save()) {
                throw new ValidationException("Erro de campos obrigatórios!", sale.errors);
            }
            JSONObject json = new JSONObject();
            json.put("id", id);
        } catch (Exception cause) {
            log.error("Problems during the sale creation!", cause)
            throw new PersistenceException("Problemas durante a criação do venda!", cause);
        }
    }

    public void darBaixaEstoque(List<ProdutoVenda> listaProdutos) {

        listaProdutos.each { produtoVenda ->
            Estoque estoque = Estoque.findByProduto(produtoVenda.produto);

            if (!estoque) {
                throw new NullPointerException("Produto sem estoque");
            }
            if (estoque.quantidade < produtoVenda.quantidade) {
                throw new NullPointerException("Esse produto possui ${estoque.quantidade} unidades.");
            }

            estoque.quantidade = estoque.quantidade - produtoVenda.quantidade;

            estoque.save();
        }

    }

    public void inicializaEstoque(Produto produto){
        Estoque estoque = new Estoque();
        estoque.produto = produto;
        estoque.quantidade = 0;
        estoque.save()
    }
}
