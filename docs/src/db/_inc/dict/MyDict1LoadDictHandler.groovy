package db._inc.dict


import jandcode.core.dbm.dict.*
import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class MyDict1LoadDictHandler implements DictHandler, IDictHandlerLoadDict {

    void resolveIds(Mdb mdb, Dict dict, Store data, Collection ids) throws Exception {
        for (id in ids) {
            data.add(id: id, text: "${dict.name}-text-${id}")
        }
    }

    void loadDict(Mdb mdb, Dict dict, Store data) throws Exception {
        for (id in 1..10) {
            data.add(id: id, text: "${dict.name}-text-${id}")
        }
    }
}
