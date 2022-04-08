package jandcode.samples.dbm1.main

import jandcode.core.dbm.test.*
import jandcode.core.store.*
import org.junit.jupiter.api.*

class Mdb_Test extends Dbm_Test {

    /**
     * Тесты настроены на автоматическое создание базы данных и структуры базы.
     * см. test.cfx
     */
    @Test
    public void auto_create_db_struct() throws Exception {
        Store st = mdb.loadQuery("select * from tab1 order by id")
        utils.outTable(st)
        //
        st = mdb.loadQuery("select * from ${TestDbProps.TABLE_NAME} order by k")
        utils.outTable(st)
    }


}
