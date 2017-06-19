package svs

import grails.converters.JSON
import org.springframework.http.HttpStatus

class SecurityFilters {

    def controleDeUsuarioService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if(controllerName.equalsIgnoreCase("login") || controllerName.equalsIgnoreCase("openApi")){
                    return true;
                }
                def token = request.getHeader("Auth-Token");
                if(!token){
                    response.status = HttpStatus.UNAUTHORIZED.value()
                    //redirect(uri: "/login")
                    render(["message": "Token inválido!"] as JSON)
                    return false;
                }else{
                    try{
                        controleDeUsuarioService.verificaPermissao(token, controllerName)
                        return true;
                    }catch (Exception e){
                        response.status = HttpStatus.UNAUTHORIZED.value()
                        render(["message": e.getMessage()] as JSON)
                        return false
                    }
                }


            }
        }
    }
}
