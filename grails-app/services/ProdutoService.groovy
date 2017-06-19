

import grails.transaction.Transactional
import grails.validation.ValidationException
import sales.Estoque
import sales.Produto

import javax.persistence.PersistenceException

@Transactional
class ProdutoService {

    def estoqueService

    public void save(Produto product)
            throws NullPointerException, PersistenceException {

        if (!product) {
            throw new NullPointerException("")
        }

        try {
            if (!product.save()) {
                throw new ValidationException("Erro de campos obrigatórios", product.errors)
            }

            estoqueService.inicializaEstoque(product);

        } catch (Exception cause) {
            log.error("Problemas durante a criação do produto!", cause)

            throw new PersistenceException("Problemas durante a criação do produto!", cause)
        }
    }

    public void update(Produto product)
            throws NullPointerException, PersistenceException {

        if (!product) {
            throw new NullPointerException("")
        }

        try {
            if (!product.save()) {
                throw new ValidationException("Erro de campos obrigatórios", product.errors)
            }


        } catch (Exception cause) {
            log.error("Problemas durante a criação do produto!", cause)

            throw new PersistenceException("Problemas durante a criação do produto!", cause)
        }
    }
}