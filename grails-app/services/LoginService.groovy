import grails.converters.JSON
import grails.transaction.Transactional
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus
import sales.Token
import sales.Usuario

import javax.persistence.PersistenceException

@Transactional
class LoginService {


    public Token fazerLogin(data)
            throws NullPointerException, PersistenceException {


        Usuario usuario = Usuario.findByLoginAndSenha(data.login, data.senha)

        if (!usuario) {
            throw new NullPointerException("Usuário não encontrado")
        }
        Token token = new Token();
        token.usuario = usuario
        token.token = UUID.randomUUID().toString();

        try {
            if (!token.save()) {
                throw new ValidationException("Erro de campos obrigatórios", token.errors)
            }
            return token
        } catch (Exception cause) {
            log.error("Problemas durante a criação do usuário!", cause)
            throw new PersistenceException("")
        }
    }


    public void logout(data) throws NullPointerException, PersistenceException {
        Usuario usuario = Usuario.findByLogin(data?.login)
        if (usuario) {
            Token token = Token.findByUsuario(usuario)
            if (token) {
                token.delete()
            }
        }
    }
}