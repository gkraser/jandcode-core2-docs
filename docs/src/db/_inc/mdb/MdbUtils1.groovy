package db._inc.mdb

import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class MdbUtils1 extends BaseMdbUtils {

    MdbUtils1(Mdb mdb) {
        this.setMdb(mdb)
    }

    Store load1(int param1) {
        return mdb.loadQuery("select * from tab1 where a>:param1", [param1: param1])
    }

}
