package jandcode.core.samples.docapx1.main.backend;

import jandcode.commons.datetime.*;
import jandcode.core.dao.*;
import jandcode.core.samples.docapx1.main.backend.dao.*;
import jandcode.core.test.*;
import org.junit.jupiter.api.*;

public class DummyDao_Test extends App_Test {

    @Test
    public void curTime_test() throws Exception {
        DaoService svc = app.bean(DaoService.class);
        DaoInvoker inv = svc.getDaoInvoker("default");
        DummyDao dao = inv.createDao(DummyDao.class);
        //
        XDateTime a = dao.curTime(50);
        //
        System.out.println(a);
    }


}
