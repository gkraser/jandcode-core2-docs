package db._inc.dao

import jandcode.core.dbm.dao.*
import jandcode.core.store.*

class DaoModel1 extends BaseModelDao {

    public Store list() throws Exception {
        return getMdb().loadQuery("select * from tab1 order by id")
    }

    public StoreRecord record(long id) throws Exception {
        return getMdb().loadQueryRecord("select * from tab1 where id=:id", [id: id])
    }

}
