package sales

import com.google.gson.annotations.Expose

/**
 * Created by adias on 08/07/16.
 */
class Venda {

    @Expose
    Long id
    @Expose
    Double total
    @Expose
    Double desconto
    @Expose
    Cliente cliente
    @Expose
    Usuario usuario
    @Expose
    List produtos
    @Expose
    Date data


    static belongsTo = Cliente

    static hasMany = [produtos: ProdutoVenda]

    static mapping = {
        //cliente  lazy:false
    }

    static constraints = {
        total nullable: false, blank: false
        cliente nullable: false, blank: false
        produtos nullable:  false
        desconto nullable: true
        usuario nullable: true
    }

}
