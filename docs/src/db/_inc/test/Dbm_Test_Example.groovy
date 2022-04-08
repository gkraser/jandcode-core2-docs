package db._inc.test

import jandcode.core.dbm.*
import jandcode.core.dbm.mdb.*
import jandcode.core.dbm.test.*
import org.junit.jupiter.api.*

class Dbm_Test_Example extends Dbm_Test {

    @Test
    public void test1() throws Exception {
        // Модель, в контексте которой выполняются тесты
        Model model = this.getModel()

        // Экземпляр класса jandcode.core.dbm.mdb.Mdb
        // Соединение с базой данных будет установлено автоматически
        // при вервом обращении к базе данных
        Mdb mdb = this.getMdb()  // в groovy-коде можно использовать mdb, вместо getMdb()

        // Экземпляр класса jandcode.core.dbm.test.DbmTestSvc
        // Набор утилитных методов для модели и базы данных
        DbmTestSvc dbm = this.dbm
    }

}
