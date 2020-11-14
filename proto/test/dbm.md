
dbm тесты
=========

@@code-info
    class=jandcode.xdbm.test.Dbm_Test
    class=jandcode.xdbm.test.DbmTestSvc
    ref=./app

Для тестирования моделей в dbm нужно создавать потомка класса
`jandcode.xdbm.test.Dbm_Test`.

Поле `dbm` (класс `jandcode.xdbm.test.DbmTestSvc`)
содержит различные утилиты для доступа к модели и данным.

Поле `app` (класс `jandcode.xcore.test.AppTestSvc`)
содержит приложение.


Автоматическое создание базы данных в тестах
--------------------------------------------

Имеется механизм для автоматического создания базы данных в тестах.
При изменении структуры (например добавлении новых полей или таблиц),
база данных будет автоматически пересоздана.

Для включения этого механизма в `test.cfx` для модели нужно установить
атрибут `test.db.autocreate` и указать другие параметры соединения
с базой данных, что бы не портить базу, с которой работает
разрабатываемое приложение при обычном его запуске.

Пример:

```xml
<root>

    <x-include path="#{pathprop:jandcode.project.root}/app.cfx"/>

    <!--
        переопределение параметров модели будет доступно только в приложении
        загруженном из этого test.cfx и не влияет на основное приложение в app.cfx
    -->

    <dbm>
        <model name="default" test.db.autocreate="true">
            <dbsource name="default" cfg="cfg/db/default.test"/>
        </model>
    </dbm>

</root>
```

В файле `app.cfx` (точнее в `_app.cfx`):

```xml
<root>
    <cfg>
        <!-- это база данных для запуска приложения -->
        <db name="default"
            database="jandcode_examples5_dbm1__DEV"
            username="root"
        />

        <!-- это база данных для использования в unit-тестах -->
        <db name="default.test"
            database="jandcode_examples5_dbm1__TEST"
            username="root"
        />
    </cfg>
</root>
```






