
less
====

Для компиляции css-стилей используется препроцессор [Less](http://lesscss.org/).

Расширения
----------

При компиляции less-файлов используются некоторые расширения.

### import по маске

Импортирование файлов по маске.

Маска может быть задана в формате:

* `[*]/MASK` - файлы по маске ищутся в корневых каталогах всех модулей
* `MASK` - файлы по маске ищутся относительно каталога, в котором находится
  файл с директивой
  
Пример:

```less
@import "[*]/css/std-module.less";
```  

Найдутся файлы вида `MODULE-PATH1/css/std-module.less`.

```less
@import "../js/comp/*/index.less";
```  

Если использовано в файле в каталоге `css` модуля, то будут импортированы 
все стили всех компонентов.


 
 




