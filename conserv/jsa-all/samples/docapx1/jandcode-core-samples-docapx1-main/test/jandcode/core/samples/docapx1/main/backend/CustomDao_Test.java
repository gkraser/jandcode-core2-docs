package jandcode.core.samples.docapx1.main.backend;

import jandcode.core.dao.*;
import jandcode.core.test.*;

/**
 * Предок для тестов dao
 */
public abstract class CustomDao_Test extends App_Test {

    protected DaoService daoSvc;
    protected DaoInvoker inv;

    public void setUp() throws Exception {
        super.setUp();
        //
        this.daoSvc = app.bean(DaoService.class);
        this.inv = daoSvc.getDaoInvoker("default");
    }

    /**
     * Создать dao
     */
    protected <A> A createDao(Class<A> cls) {
        return inv.createDao(cls);
    }

}
