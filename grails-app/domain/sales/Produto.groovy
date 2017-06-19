package sales

import com.google.gson.annotations.Expose

/**
 * Created by adias on 08/07/16.
 */
class Produto {

    @Expose
    Long id
    @Expose
    String nome
    @Expose
    String codigo
    @Expose
    Double preco
    @Expose
    TipoDoProduto tipoDoProduto

    static mapping = {
    }

    static constraints = {
        nome nullable: false, blank: false, unique: true
        tipoDoProduto nullable: false, blank: false
        codigo nullable: false, blank: false, unique: true
        preco nullable: false
    }


}
