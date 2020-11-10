
Action
======

Что такое action
----------------

Action - это объекты, реализующие интерфейс `jandcode.core.web.action.IAction`, которые
обратывают http-запросы пользователя в контексте web-приложения и возвращают
ответ клиенту.

На практике для создания `action` необходимо создать наследника от класса
`jandcode.core.web.action.BaseAction` и реализовать ему метод `onExec()`, в котором
и будет логика обработки запроса.

Каждая `action` регистрируется в приложении под определенным именем, которое может
включать в себя `/`:

@@code file=_inc/action/register1.xml

Упрощенная схема преобразования url в `action` такова:
среди всех зарегистрированных `action` ищется такая, имя которой совпадает с
началом `pathInfo` http-запроса. Остаток `pathInfo`, из которого удалено имя `action`
будет передано в обработчик запроса в качестве одного из атрибутов.

**Что такое pathInfo?** Допустим, что приложение работает
по адресу `http://localhost/myapp/`. Тогда все, что будет в url
после `http://localhost/myapp/` и до начала параметров (символа `?`)
является `pathInfo`. Например в запросе
`http://localhost/myapp/a1/a2/a3?param1=1&param2=2` имеем `pathInfo` равным `a1/a2/a3`.
`pathInfo` доступно через метод `jandcode.core.web.Request#getPathInfo`.

Для вышеприведенного примера регистрации `action` будут верны следующие преобразования
`pathInfo` в `action`:

| pathInfo | action | Остаток pathInfo | Коментарий |
| --- | --- | --- | --- |
| `action1` | `action1` |  |  |
| `action1/m1` | `action1` | `m1` | |
| `blog/m1/m2` | `blog` | `m1/m2` | |
| `blog/news/m1` | `blog/news` | `m1` | `blog/news` длиннее по фасетам, чем `blog`


Реализация action
-----------------

Простейшая реализация `action` выглядит так:

@@code file=_inc/action/SimpleAction.groovy part=content-all

Интерпретация pathInfo для action
---------------------------------

Доупустим, что имеется `action`, зарегистрированая так:

@@code file=_inc/action/SimpleAction-register1.xml

и ее экземпляр создан для обработки запроса с таким `pathInfo`:

```
my/simple/action/p1/p2/p3
```

Тогда в атрибуты `getRequest().getAttrs()` будут дополнительно добавлены следующие
атрибуты:

| Имя атрибута | Константа имени | Значение | Коментарий |
| --- | --- | --- | --- |
|`actionPathInfo`|`WebConsts.a_actionPathInfo`|`p1/p2/p3`|`pathInfo`, из которого убрано имя action|
|`actionMethod`|`WebConsts.a_actionMethod`|`p1`|Первый фасет из `actionPathInfo`, имя "метода" для action|
|`actionMethodPathInfo`|`WebConsts.a_actionMethodPathInfo`|`p2/p3`|`actionPathInfo`, из которого убран первый фасет|

Если соответсвующей информации нет в `pathInfo`, то атрибуты принимают пустые значения.

Методы в классе action
----------------------

Реализация метода `onExec()` по умолчанию вызывает публичный метод 
с именем, который указан в атрибуте `actionMethod`. Если в этом атрибуте нет
значения, то значение по умолчанию для него - `index`. Если метода с таком именем
нет, то генерируется ошибка.

Пример:

@@code file=_inc/action/SimpleMethodsAction.groovy

В таблице показаны варианты обработки различных `pathInfo`, предполагая, что
`action` зарегистрирована с именем `my/act`:

| pathInfo | Действие |
| --- | --- |
| `my/act` | Вызов метода `index` |
| `my/act/index` | Вызов метода `index` |
| `my/act/p1` | Вызов метода `p1` |
| `my/act/p1/p2/p3` | Вызов метода `p1`, атрибут `actionMethodPathInfo=p2/p3` |
| `my/act/ppp` | Ошибка, метода `ppp` нет |

Если метод возвращает значение, то это значение будет использовано в качестве
данных для рендеринга:

@@code file=FuncMethodsAction.groovy
 
В этом примере методы `p1` и `p2` эквивалентны. 

Когда метод `onExec()` явно перекрыт, то, естественно, эти правила не действуют и
процесс обработки будет вестись по вашим правилам.


ActionMethodExecutor
--------------------

Если метод action имеет один параметр типа `jandcode.core.web.action.ActionMethodExecutor`,
то выполнение метода action делегируется экземпляру этого класса.

Пример:

@@code file=ActionExecutor1.groovy
  


index.gsp / index.html
----------------------

Когда при обработке `pathInfo` не найдена `action`, которая соответствует
этому `pathInfo`, делается попытка интерпретировать `pathInfo` как виртуальную
папку, в которой ищутся файлы `index.gsp` или `index.html`.

Если найден `index.gsp`, то клиенту возвращается результат рендеринга этого файла.
url для клиента выглядит как папка.

Если найден `index.html`, то делается redirect на на него, соответственно
url для клиента выглядит как файл.

При наличии обоих файлов приоритет имеет `index.gsp`.


Action 'root' {#root}
-------------

Специальная action с именем `root` обрабатывает запрос в корень url
(http://host или http://host/). По умолчанию настроена на рендеринг 
заглушки gsp. Ее нужно настроить в приложении.

Можно указать шаблон `gsp`:

@@code file=root-register1.xml

или класс action:

@@code file=root-register2.xml
 

Конфигурация module.cfx
----------------------

### web/action

Регистрация `action`.

Формат:

@@code file=_inc/action/cfx-web-action.xml

* `name` - уникальное имя `action`. Может включать `/`.
* `class` - класс `action`
* `template` - шаблон `gsp`. Если указан шаблон и не указан атрибут `class`,
  то в качестве класса принимается `jandcode.core.web.std.action.GspAction`,
  которая рендерит указанный шаблон.
  
  





