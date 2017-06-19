import grails.transaction.Transactional
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject
import sales.Cliente

import javax.persistence.PersistenceException

@Transactional
class ClienteService {


    public void save(Cliente client)
            throws NullPointerException, PersistenceException {

        if (!client) {
            throw new NullPointerException("")
        }

        try {
            if (!client.save()) {
                throw new ValidationException("Erro de campos obrigatórios", client.errors)
            }
            JSONObject json = new JSONObject();
            json.put("id", client.id)
        } catch (Exception cause) {
            log.error("Problemas durante a criação do cliente!", cause)

            throw new PersistenceException("Problemas durante a criação do cliente!", cause)
        }
    }
}