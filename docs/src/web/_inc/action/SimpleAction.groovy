package _inc.action

import jandcode.commons.variant.*
import jandcode.core.web.RequestUtils
import jandcode.core.web.action.BaseAction

class SimpleAction extends BaseAction {
    protected void onExec() throws Exception {
        // это запрос, тут есть все, что известно о запросе + утилиты
        RequestUtils req = getReq()
        // это параметры запроса
        IVariantMap params = getReq().getParams()
        // возвращаем результат клиенту как строку
        getReq().render("Hello! Params: " + getReq().getParams())
    }
}
