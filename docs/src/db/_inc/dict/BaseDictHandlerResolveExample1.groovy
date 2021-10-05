package db._inc.dict

import jandcode.core.dbm.dict.*
import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class BaseDictHandlerResolveExample1 extends BaseDictHandlerResolve {

    BaseDictHandlerResolveExample1() {
        // размер блока, который будет передан в метод resolveIdsBlock
        // по умолчанию размер блока равен 200
        setBlockSize(100)
    }

    // этот метод загружает блок ids, вызывается несколько раз в зависимости
    // от количества нужных ids
    protected void resolveIdsBlock(Mdb mdb, Dict dict, Store data, Collection<Object> ids) throws Exception {
        for (id in ids) {
            data.add(id: id, text: "${dict.name}-text-${id}")
        }
    }

}
