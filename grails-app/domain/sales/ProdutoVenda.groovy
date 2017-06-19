package sales

import com.google.gson.annotations.Expose

/**
 * Created by adias on 08/07/16.
 */
class ProdutoVenda {

    @Expose
    Long id
    @Expose
    Integer quantidade
    @Expose
    Produto produto

    Venda venda

    static belongsTo = Venda
    static mapping = {
    }

    static constraints = {
        quantidade nullable: false, blank: false
        produto nullable: false, blank: false
    }


}
