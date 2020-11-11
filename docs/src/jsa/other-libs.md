
Библиотеки без node_modules
===========================

Когда внешняя библиотека не представлена в пакетах `npm`
или имеется там, но ее формат поставки не устраивает,
можно просто поместить файлы js/css себе в модуль.

Соглашения:

* Файлы внешних библиотек js/css помещаются в папку `jc-data/webroot/jslib`,
  которая должны находится внутри каталога с проектом модуля.
* Для каждой библиотеки создается отдельный каталог по имени библиотеки, в него
  кладутся файлы.
* Импорт библиотеки из других файлов js: `import 'jslib/LIBNAME/LIBFILE.js''`
* Файлы библиотек должны быть готовы к использованию на клиенте без дополнительной
  обработки. Например они не должны быть в формате ES6.
  
Файлы из каталога `jc-data` будут доступны как при разработке, так и в итоговом jar-файле.   
  
Пример:

@@tree-fs file=project-dir1.cfx

!!! note
    После того как создадите `jc-data/webroot`, сделайте `jc gen-idea`,
    что бы idea знала про ваши файлы
    
    
  