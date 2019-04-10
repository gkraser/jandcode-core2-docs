
Подсветка синтаксиса
====================

В сгенерированной документации поддерживается подсветка синтаксиса с помощью <http://prismjs.com/>.
Для этого необходимо указать язык для подсветки:

~~~
```groovy
def a = "str"
```
~~~

Далее представлены некоторые примеры поддерживаемых подсветок. Конечно этими языками
поддержка не ограничивается. Полный список поддерживаемых языков можно посмотреть на сайте
<http://prismjs.com/>.


## java

```java
public class MyClass extends Object {
    /**
     * Comment
     */
    public void method1(String p) {
        // comment
        String s = "Hello";
        int a = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println("i" + i);
        }
    }
}
```

## groovy

```groovy
public class MyClass extends Object {
    /**
     * Comment
     */
    public void method1(String p) {
        String s = 'Hello';
        // comment
        def s1 = """Hello ${p}"""
        def a = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println("i" + i);
        }
    }
}
```

## javascript

Можно использовать имена `js` или `javascript`.

```js
// comment
var a = "hello";
var b = 1;
/*
   comment
*/
function func1(p) {
    for (let i = 0; i < 10; i++) {
        System.out.println("i" + i);
    }
}
```

## xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<root>
    <!-- comment -->
    <node attr1="Value">
        Text
    </node>
</root>
```

## html

```html
<div class="class1" id="id1">
    <!-- comment -->
    <span>
        Text
    </span>
    <script>
        var a = "ss";
    </script>
    <style>
        body {
           color: #fff;
        }
    </style>
</root>
```

## css

```css
/* comment */
body {
   color: #fff;
}
```

## gsp

```gsp
<%@ page import="jandcode.utils.*; jandcode.mdoc.*" %>
%{-- comment --}%
<!-- comment -->
<div class="cls">text</div>
<%
    def a = "hello"
%>
<jc:tag attr1="value">text</jc:tag>
```

## console

Консольный вывод

```console
Опции:
  -csc      Очистить кеш скриптов
  -f:ARG    Имя файла проекта. По умолчанию project.jc в текущем каталоге
  -h        Помощь по команде
  -log:ARG  Включение логирования. ARG - имя файла в формате logback.
            Можно не указывать, тогда используются настройки по умолчанию
  -no-ansi  Отключить разукрашенный вывод
  -v        Включение режима с большим числом сообщений
```

