import grails.transaction.Transactional
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject
import sales.Cliente
import sales.Usuario

import javax.persistence.PersistenceException

@Transactional
class UsuarioService {


    public void save(Usuario usuario)
            throws NullPointerException, PersistenceException {

        if (!usuario) {
            throw new NullPointerException("")
        }

        try {
            if (!usuario.save()) {
                throw new ValidationException("Erro de campos obrigatórios", usuario.errors)
            }
            JSONObject json = new JSONObject();
            json.put("id", usuario.id)
        } catch (Exception cause) {
            log.error("Problemas durante a criação do usuário!", cause)
            throw new PersistenceException("")
        }
    }
}