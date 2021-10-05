package db._inc.dict


import jandcode.core.dbm.dict.*
import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class MyDict1Handler implements DictHandler {

    void resolveIds(Mdb mdb, Dict dict, Store data, Collection ids) throws Exception {
        for (id in ids) {
            data.add(id: id, text: "${dict.name}-text-${id}")
        }
    }

}
