package sales

import com.google.gson.annotations.Expose

class Token {

    @Expose
    Long id
    @Expose
    String token
    @Expose
    Usuario usuario

    static belongsTo = Usuario

    static constraints = {
    }
}
