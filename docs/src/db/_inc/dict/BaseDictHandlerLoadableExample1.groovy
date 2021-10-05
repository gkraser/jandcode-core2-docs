package db._inc.dict

import jandcode.core.dbm.dict.*
import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class BaseDictHandlerLoadableExample1 extends BaseDictHandlerLoadable {

    void loadDict(Mdb mdb, Dict dict, Store data) throws Exception {
        for (id in 1..10) {
            data.add(id: id, text: "${dict.name}-text-${id}")
        }
    }

}
