package svs;

import sales.TipoDeUsuario;

/**
 * Created by adias on 04/12/16.
 */
public class PermissoesDoUsuario {

    public static boolean verificaPermissao(TipoDeUsuario tipo, String controller){

        if(tipo == TipoDeUsuario.GERENTE && ("produto".equalsIgnoreCase(controller) ||
                "estoque".equalsIgnoreCase(controller) || "usuario".equalsIgnoreCase(controller))){
            return true;

        }else if(tipo == TipoDeUsuario.VENDEDOR && ("cliente".equalsIgnoreCase(controller) ||
                "venda".equalsIgnoreCase(controller))){
            return true;

        }
        return false;
    }
}
