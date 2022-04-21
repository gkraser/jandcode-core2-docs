package jandcode.samples.dbm1.main.fixture

import jandcode.commons.rnd.*
import jandcode.core.dbm.fixture.*

/**
 * Построить тестовые данные для таблицы tab1
 */
class Tab1_fixture extends BaseFixtureBuilder {

    Rnd rnd = Rnd.create(123)

    int count = 5

    protected void onBuild() {
        def tab = fx.table("tab1")

        for (id in 1..count) {
            tab.add(id: id, f_string: "str-${id}", f_int: id * 10)
        }
    }

}
