
Action для рендеринга gsp
=========================

@@code-info
    ref="/web/action|Подробнее об action"

Можно создать произвольный gsp-файл и дать возможность получать 
результат его рендеринга на клиенте через определенный url.

К примеру, сделаем страницу `/about`.

Создадим файл `about.gsp`:

@@code file=samples/docapx1/js/pages/about.gsp
       title=jandcode/core/samples/docapx1/main/js/pages/about.gsp
       
Это простой шаблон gsp, который получает некоторые параметры и генерит html.

Теперь зарегистрируем action `about` в `module.cfx` для отображения этой страницы:

@@code file=samples/docapx1/module.cfx
       title=jandcode/core/samples/docapx1/main/module.cfx
       part=about
       
Теперь после перехода на [](http://localhost:8080/jc/about) мы должны увидеть
то, что нагенерили в `about.gsp`.


       
       
       
         

   
