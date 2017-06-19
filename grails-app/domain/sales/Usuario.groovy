package sales

import com.google.gson.annotations.Expose

import javax.persistence.Enumerated

class Usuario {

    @Expose
    Long id
    @Expose
    String login
    @Expose
    String senha
    @Expose
    TipoDeUsuario tipoDoUsuario

    static mapping = {
    }

    static constraints = {
        login nullable: false, blank: false, unique: true
        senha nullable: false, blank: false
        tipoDoUsuario nullable: false, blank: false
    }


}
