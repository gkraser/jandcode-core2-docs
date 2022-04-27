Инструменты для GSP
===================

JsIndexGspContext {#JsIndexGspContext}
-----------------

Класс `jandcode.core.web.std.gsp.JsIndexGspContext`.

Сервисные методы для использования в index.gsp и аналогичных файлах, которые формируют
стартовый html-файл для js-приложения.

Пример использования:

```gsp
<%@ page import="jandcode.commons.*; jandcode.core.web.*; jandcode.core.web.gsp.*;jandcode.core.web.std.gsp.*;" %>
<!doctype html>
<%
  BaseGsp th = this
  // запрещаем кеширование этой страницы
  th.request.disableCache()
  // берем экземпляр JsIndexGspContext
  def ctx = th.inst(JsIndexGspContext)
  // заголовок
  ctx.title = "NTBD"
  // добавляем ссылки на js/css 
  ctx.addLink("my/css/style.css")
  ctx.addLink("my/js/scipt.js")
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>${ctx.title}</title>   %{-- выводим заголовок--}%
  <link rel="icon" href="data:,">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<div id="jc-app"></div>
<% ctx.outLinks() %>            %{-- выводим ссылки и конфигурацию--}%
</body>
</html>
```

Метод `outLinks`, кроме явно добавленных ссылок, выводит также конфигурацию, собранную
сервисом `jandcode.core.web.cfg.ClientCfgService`. А также дополнительную конфигурацию,
жизненно необходимую для корректной работы js-приложений.

Пример вывода метода `outLinks`:

```html
<script>
window.Jc_cfg={
  "baseUrl": "/jc/",
  "envDev": true,
  "envSource": true,
  "userInfo": {
    "guest": true
  }
}
</script>
<link rel="stylesheet" href="/jc/my/css/style.css"/>
<script src="/jc/my/js/scipt.js"></script>
```

