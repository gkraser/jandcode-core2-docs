package db._inc.mdb

import jandcode.core.dbm.*
import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class MdbExamples1 extends BaseModelMember {

    void example1() {
        // создаем экземпляр Mdb
        Mdb mdb = getModel().createMdb()

        // устанавливаем соединение
        mdb.connect()
        try {
            // выполняем запросы
            Store store = mdb.loadQuery("select * from tab1 where a>:param1", [param1: 100])
            mdb.execQuery("update tab1 set a=1 where id=:id", [id: 100])

        } finally {
            // разрываем соединение
            mdb.disconnect()
        }
    }

}
