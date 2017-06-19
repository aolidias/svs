import grails.transaction.Transactional
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject
import sales.Token
import sales.Venda

import javax.persistence.PersistenceException
import javax.validation.constraints.Null

@Transactional
class VendaService {

    def estoqueService

    public void save(Venda sale, String tokenString)
            throws NullPointerException, PersistenceException {

        if (!sale) {
            throw new NullPointerException("Venda inválida")
        }

        try {

            Token token = Token.findByToken(tokenString);
            sale.usuario = token.usuario;
            def produtoVenda = sale.produtos;
            sale.produtos = [];
            produtoVenda.each { p ->
                sale.addToProdutos(p)
            }
            if (!sale.save(flush:true)) {
                throw new ValidationException("Erro de campos obrigatórios!", sale.errors)
            }
            estoqueService.darBaixaEstoque(sale.produtos)
            JSONObject json = new JSONObject();
            json.put("id", sale.id)
        } catch (PersistenceException cause) {
            log.error("Problema na criação da venda.!", cause)
            throw new PersistenceException("Problemas durante a criação do venda!", cause)
        } catch (NullPointerException cause){
            log.error("Problemas durante a criação do venda!", cause)
            throw cause;
        }
    }
}
