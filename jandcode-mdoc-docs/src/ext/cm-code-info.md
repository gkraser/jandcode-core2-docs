
code-info
=========

Описание
--------

Информация о коде, который описывается в статье

Формат:

```
@@code-info attr=value
```

Атрибуты:

* `lib` - имя библиотеки
* `module` - имя модуля jandcode
* `pak` - имя пакета
* `class` - имя класса
* `text` - текст html
* `ref` - ссылка. Формат `'ref|title|дополнительный текст'`

Атрибуты могут дублироватся.

Пример:

```
@@code-info
    class=jandcode.jc.std.GradleTools
    ref="https://gradle.org/|Gradle|должен быть установлен и доступен в PATH"
    lib=jandcode-jc
    module=jandcode.mdoc
    pak=jandcode.mdoc.ext
    pak=jandcode.mdoc
    text="Это просто текст"
    text="Это просто текст2"
```

Результат:

@@code-info
    class=jandcode.jc.std.GradleTools
    ref="https://gradle.org/|Gradle|должен быть установлен и доступен в PATH"
    lib=jandcode-jc
    module=jandcode.mdoc
    pak=jandcode.mdoc.ext
    pak=jandcode.mdoc
    text="Это просто текст"
    text="Это просто текст2"


