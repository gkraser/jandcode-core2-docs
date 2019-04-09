package _inc.action

import jandcode.web.action.*

class SimpleMethodsAction extends BaseAction {

    public void index() throws Exception {
        getReq().render("index")
    }

    public void p1() throws Exception {
        getReq().render("p1")
    }

}
