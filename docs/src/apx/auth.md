
auth - аутентификация
=====================

@@code-info module=jandcode.core.apx
pak=jandcode.core.apx.auth

Описание
--------

В состав `apx` входит базовая реализация слоя аутентификаци. 

web-фильтры:

* `jandcode.core.apx.auth.AuthFilter` - устанавливает текущего пользователя
  для сервиса аутентификации `jandcode.core.auth.AuthService`, информацию берет из 
  сессии
* `jandcode.core.apx.auth.AuthAutoLoginFilter` - устанавливает режим autologon,
  автоматический login пользователя при первом обращении к серверу. Используется
  и подключается только в режиме разработки

web-action:

* `jandcode.core.apx.auth.AuthAction` базовая реализация login/logout

ClientCfgProvider:

* `jandcode.core.apx.auth.AuthClientCfgProvider` - провайдер конфигурации для 
  клиентского приложения, предоставляет основную информацию о пользователе

