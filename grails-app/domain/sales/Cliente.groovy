package sales

import com.google.gson.annotations.Expose

/**
 * Created by adias on 08/07/16.
 */
class Cliente {

    @Expose
    Long id
    @Expose
    String nome
    @Expose
    Date dataDeNascimento
    @Expose
    String telefone
    @Expose
    String endereco
    @Expose
    String cpf
    @Expose
    String email
    @Expose
    Integer peso
    @Expose
    Integer altura

    static hasMany = [vendas: Venda]

    static mapping = {
    }

    static constraints = {
        nome nullable: false, blank: false
        dataDeNascimento nullable: false, blank: false
        telefone nullable: false, blank: false
        endereco nullable: false, blank: false
        cpf nullable: true
        email nullable: true
        peso nullable: true
        altura nullable: true
        vendas nullable:  true
    }
}
