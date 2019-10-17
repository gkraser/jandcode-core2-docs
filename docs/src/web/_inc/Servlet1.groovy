package _inc;

import jandcode.core.*
import jandcode.core.web.AppServlet

import javax.servlet.http.*

public class Servlet1 extends HttpServlet {

    public void test1() throws Exception {
        AppServlet mainServlet = (AppServlet) getServletContext().getAttribute("main.servlet");
        App mainApp = mainServlet.getApp();
    }

}
