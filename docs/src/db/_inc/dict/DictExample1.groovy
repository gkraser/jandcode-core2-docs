package db._inc.dict

import jandcode.core.dbm.*
import jandcode.core.dbm.dict.*
import jandcode.core.dbm.mdb.*
import jandcode.core.store.*

class DictExample1 extends BaseModelMember {

    Mdb getMdb() {
        return getModel().createMdb()
    }

    void example1() {
        // получаем сервис словарей
        DictService dictSvc = getModel().bean(DictService.class)

        // получаем словарь
        Dict dict1 = dictSvc.getDict("mydict1")

        // загружаем данные словаря полностью, если он загружаемый
        // т.е. может сразу загрузить все свои данные
        if (dict1.isLoadable()) {
            DictData dictdata = dictSvc.loadDictData("mydict1")
        }

        // загружаем только данные для указанных id
        // работает для любых типов словарей
        DictData dictdata = dictSvc.loadDictData("mydict1", [1, 2, 6])

        // создаем какой-то store
        Store store = mdb.createStore()
        store.addField("id", "long")
        store.addField("data", "string")
        // для поля mydict1 устанавливаем связь со словарем
        store.addField("mydict1", "long").setDict("mydict1")

        // ... как то заполняем store

        // для словарных полей ставим соотвествии между id и текстом
        dictSvc.resolveDicts(store)

        // берем запись из store
        StoreRecord rec = store.get(0)

        // получаем текст из поля text для id, которое хранится в поле mydict1
        String text = rec.getDictText("mydict1")
        // получаем текст из поля text2 для id, которое хранится в поле mydict1
        String text2 = rec.getDictText("mydict1", "text2")

        // создаем пустой store со структурой словаря
        Store store1 = dict1.createStore()

        // создаем пустой dictdata для словаря
        DictData dictdata1 = dict1.createDictData()
    }

    void cache1() {
        DictService dictSvc = getModel().bean(DictService.class)
        Dict mydict1 = dictSvc.getDict("mydict1")

        // получить закешированные данные словаря
        DictData dictdata1 = dictSvc.getCache().getDictData(mydict1)

        // сбросить кеш для указанного словаря
        dictSvc.getCache().invalidate(mydict1)
    }
}
