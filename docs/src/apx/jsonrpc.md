JsonRPC
=======

Описание
--------

Для взаимодействия с сервером клиентских приложений в `apx` используется
протокол [JsonRPC](https://www.jsonrpc.org/).

Суть в следующем: выбирается некий [DaoHolder](../db/dao#dao-holder)
и предоставляется http-интерфейс для выполнения его методов через определенную
entry-point.

По умолчанию в `apx` настроена entry-point с именем `api`, которая транслирует
методы `DaoHolder` с именем `api`:

```xml
<root>
    <web>
        <action name="api"
                class="jandcode.core.apx.jsonrpc.JsonRpcAction"
                daoHolder="api"/>
    </web>
</root>
```

Web-action `jandcode.core.apx.jsonrpc.JsonRpcAction` является обработчиком JsonRPC.

Можно настраивать различные entry-point для нужных DaoHolder в приложении по смоему
усмотрению:

```xml
<root>
    <web>
        <action name="api"
                class="jandcode.core.apx.jsonrpc.JsonRpcAction"
                daoHolder="api"/>
        <action name="api-v2"
                class="jandcode.core.apx.jsonrpc.JsonRpcAction"
                daoHolder="api-new"/>
    </web>
</root>
```

Запросы и параметры
-------------------

Тип запроса должен быть POST.

Арибут `"jsonrpc": "2.0"` является не обязательным.

В качестве параметров можно указывать объект, который содержит поименнованные параметры
метода:

```
POST http://localhost:8080/jc/api
Content-Type: application/json

{
  "id": "1",
  "method": "my/dao1",
  "params": {
    "id": 1215
  }
}
```

Так же в качестве параметров можно указывать массив, которые содержит позиционные
параметры метода:

```
POST http://localhost:8080/jc/api
Content-Type: application/json

{
  "id": "1",
  "method": "my/dao1",
  "params": [1215]
}
```

