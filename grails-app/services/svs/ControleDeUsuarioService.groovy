package svs

import grails.transaction.Transactional
import sales.Token

@Transactional
class ControleDeUsuarioService {

    def verificaPermissao(String tokenString, String controller) {

        def token = Token.findByToken(tokenString);
        if (token) {
            def tipoDoUsuario = token.getUsuario().tipoDoUsuario
            boolean temPermissao = PermissoesDoUsuario.verificaPermissao(tipoDoUsuario, controller);
            if (!temPermissao) {
                throw new Exception("Usuário não tem acesso á funcionalidade ${controller}!")
            }
        } else {
            throw new Exception("Token inválido!");
        }


    }
}
