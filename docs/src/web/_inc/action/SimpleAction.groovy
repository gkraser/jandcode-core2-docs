package web._inc.action

import jandcode.commons.variant.*
import jandcode.core.web.action.*

class SimpleAction extends BaseAction {
    protected void onExec() throws Exception {
        // это запрос, тут есть все, что известно о запросе + утилиты
        ActionRequestUtils req = getReq()
        // это параметры запроса
        IVariantMap params = getReq().getParams()
        // возвращаем результат клиенту как строку
        getReq().render("Hello! Params: " + getReq().getParams())
    }
}
