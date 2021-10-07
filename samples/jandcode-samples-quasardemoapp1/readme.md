jandcode-samples-quasardemoapp1
===============================

Пример использования самостоятельного quasar приложения в рамках проекта jandcode.

Проект на основе стандартного web-app. Создан командой:

```
jc create -t:web-app -o:jandcode-samples-quasardemoapp1
```
    
`frontend` создан командой:

```
quasar create quasar-demoapp1
```

Папка `quasar-demoapp1` переименована в `frontend`.

Запуск:

```
jc build
app-run serve
```

Сборка продукта (в каталог `_jc/product`):

```
jc product
```

Изменные файлы:

* `project.jc` - настройка для подключения frontend приложения

