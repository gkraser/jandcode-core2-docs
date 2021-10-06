package db._inc.dao

import jandcode.core.dao.*
import jandcode.core.dbm.*
import jandcode.core.dbm.dao.*
import jandcode.core.store.*

class DaoExamples1 extends BaseModelMember {

    DaoService daoSvc = getApp().bean(DaoService.class)
    DaoInvoker daoInv = daoSvc.getDaoInvoker("default")

    void call1() {
        // берем сервис dao
        DaoService daoSvc = getApp().bean(DaoService.class)
        // берем исполнителя dao
        DaoInvoker daoInv = daoSvc.getDaoInvoker("default")
        // создаем экземпляр dao
        DaoSimple1 dao = daoInv.createDao(DaoSimple1.class)
        // выполняем dao метод
        String result = dao.meth1("p1")
    }

    void noDaoMethod1() {
        DaoSimple1 dao = daoInv.createDao(DaoSimple1.class)
        try {
            dao.noDaoMethod1()
        } catch (e) {
            // вызов не dao-метода
        }
    }

    void callModel1() {
        // берем сервис dao для модели
        ModelDaoService daoSvc = getModel().bean(ModelDaoService.class)
        // берем исполнителя dao, он единственный
        DaoInvoker daoInv = daoSvc.getDaoInvoker()
        // создаем экземпляр dao
        DaoModel1 dao = daoInv.createDao(DaoModel1.class)
        // выполняем dao методы
        Store lst = dao.list()
        StoreRecord rect = dao.record(10)
    }

}
