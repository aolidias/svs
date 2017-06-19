package sales

import com.google.gson.annotations.Expose

/**
 * Created by adias on 08/07/16.
 */
class Estoque {

    @Expose
    Long id
    @Expose
    Integer quantidade
    @Expose
    Produto produto

    static belongsTo = Produto


    static mapping = {
    }

    static constraints = {
        quantidade nullable: false, blank: false
        produto nullable: false, blank: false
    }

}
