package web._inc.action

import jandcode.core.web.action.*

class FuncMethodsAction extends BaseAction {

    public void p1() throws Exception {
        getReq().render("data1")
    }

    public String p2() throws Exception {
        return "data1"
    }

}
