
Ansi цвета в консоле
====================

@@code-info
    class=jandcode.commons.UtAnsifer
    lib=jandcode-commons-jansi

Поддержка ansi-цветов в консоли.

!!! note
    Биюлиотека `jandcode-commons` содержит только api,
    для полной поддержки в проект необходимо подключить библиотеку
    `jandcode-commons-jansi`.
    
Пример:

@@code file=AnsiferExamples.java part=example1


Доступные цвета определены в `jandcode.commons.ansifer.AnsiferColor`.

Регистрация стилией
-------------------

@@code file=AnsiferExamples.java part=reg1

По умолчанию зарегистрированы следующие стили:

@@code file=DefaultAnsiferStyles#m1

    



