package jc._inc.base


import jandcode.jc.*

class CmInScript extends ProjectScript {

    void onInclude() {

        /* объявление команды 'cm1', без описания.
           код команды - closure
         */
        cm.add("cm1") {
            log("Команда выполнена")
        }

        /* объявление команды 'cm2', с описанием.
           код команды - closure
         */
        cm.add("cm2", "Это команда 2\nОписание может быть\nмногострочным") {
            log("Команда выполнена")
        }

        /* объявление команды 'cm3', с описанием.
           код команды - метод cmMethod
         */
        cm.add("cm3", this.&cmMethod, "Это команда 3")

        /* объявление команды 'cm4', с описанием и опциями.
           код команды - метод cmMethod
         */
        cm.add("cm3", this.&cmMethod, "Это команда 3",
                cm.opt("opt1", false, "boolean опция"),
                cm.opt("opt2", "Также boolean опция"),
                cm.opt("opt3", "", "Опция с параметром"),
        )

    }

    /**
     * Для методов, котрые используются как команды,
     * можно объявить аргумент типа CmArgs, который будет
     * заполнен параметрами командной строки при вызове команды.
     */
    void cmMethod(CmArgs args) {
        log("Команда выполнена")
    }

}