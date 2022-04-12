package db._inc.genid

import jandcode.core.dbm.genid.*
import jandcode.core.dbm.test.*

class Example1 extends Dbm_Test {

    public void genid() throws Exception {
        // получаем сервис GenIdService
        GenIdService svc = getModel().bean(GenIdService.class)

        // получаем генератор
        GenId genId = svc.getGenId("my_gen")

        // получаем следующее уникальное значение
        long val = genId.getNextId()
    }

    public void mdb1() throws Exception {
        // ... где-то в методе dao ...

        // получаем генератор по имени
        GenId genId = getMdb().getGenId("my_gen")

        // получаем следующее уникальное значение
        long val = getMdb().getNextId("my_gen")
    }

    public void with_mdb() throws Exception {
        // получаем сервис GenIdService
        GenIdService svc = getModel().bean(GenIdService.class)

        // получаем генератор с привязкой к mdb
        GenId genId = svc.getGenId("my_gen").withMdb(getMdb())
    }

    public void cached() throws Exception {
        // получаем кешированный генератор по имени
        // с указанием сколько значений нам потребуется
        GenId genId = getMdb().getGenId("my_gen", 20)

        // получаем следующее уникальное значение
        long val = genId.getNextId()
    }

}
