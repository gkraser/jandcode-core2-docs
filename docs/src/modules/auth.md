
auth - аутентификация и авторизация
===================================

@@code-info
    module=jandcode.core.auth
    class=jandcode.core.auth.AuthService

**Аутентификация** — процедура проверки подлинности, например проверка подлинности 
пользователя путем сравнения введенного им пароля с паролем, сохраненным в базе данных.

**Авторизация** - предоставление определённому лицу или группе лиц прав на 
выполнение определённых действий.
    
Пример
------

@@code file=AuthExample.java part=example1
      
        
Текущий пользователь
--------------------

Метод `AuthService#getCurrentUser()` возвращает пользователя, который привязан к текущему
потоку. Если пользователь не привязан, т.е. не был вызван метод 
`AuthService#setCurrentUser()`, метод все равно возвращает экземпляр пользователя,
но у него установлено в true свойство `isGuest()`, т.е. пользователь является "гостем".
          
Реализация аутентификации
-------------------------

Для реализации аутентификации необходимо создать реализацию интерфейса
процессора аутентификации `jandcode.core.auth.AuthProcessor`.

Необходимо реализовать методы:
* `isSupportedAuthToken` - проверить, что переданный токен можут быть обработан 
  этм процессором
* `login` - для переданного токена аутентификации вернуть пользователя, который ему
  соответсвует или сгенерировать ошибку аутенстификации `jandcode.core.auth.XErrorAuth`
  
В качестве базового простейшего примера можно посмотреть на код
`jandcode.core.auth.std.DummyAuthProcessor`:

```java
/**
 * Заглушка для {@link AuthProcessor}.
 * <p>
 * Может аутентифицировать пользователей по имени/паролю:
 * admin/111, user1/111.
 */
public class DummyAuthProcessor extends BaseComp implements AuthProcessor {

    public boolean isSupportedAuthToken(AuthToken authToken) {
        return authToken instanceof UserPasswdAuthToken;
    }

    public AuthUser login(AuthToken authToken) throws Exception {
        UserPasswdAuthToken token = (UserPasswdAuthToken) authToken;

        if ("admin".equals(token.getUsername()) && "111".equals(token.getPasswd())) {
            return createUser(token.getUsername(), 1);

        } else if ("user1".equals(token.getUsername()) && "111".equals(token.getPasswd())) {
            return createUser(token.getUsername(), 101);

        } else {
            throw new XErrorAuth(XErrorAuth.msg_invalid_user_passwd);
        }

    }

    protected AuthUser createUser(String username, long id) {
        Map<String, Object> attrs = new LinkedHashMap<>();
        attrs.put("id", id);
        attrs.put("username", username);
        return new DefaultAuthUser(attrs);
    }

}
```
  
Реализованный процессор необходимо зарегистрировать в `module.cfx` 
как процессор по умолчанию:

```xml
<root>
    <bean name="jandcode.core.auth.AuthService">
        <auth-processor name="default"
                        class="jandcode.core.auth.std.DummyAuthProcessor"/>
    </bean>
</root>
```

После этого вызов метода `AuthService#login` будет транслироваться этому процессору.

Процессор можут быть сколь угодно сложным, например делегировать выполнение некоему 
другому процессору или вызывать цепочку процессоров. Главное, что бы он после выполнения
либо вернул пользователя, либо сгенерировал ошибку.


Пользователь
------------

Информация о пользователе представляется интерфейсом `jandcode.core.auth.AuthUser`.

Этот интерфейс является набором произвольных атрибутов,
которыми характеризируется пользователь. Состав атрибутов и их значения формирует
процессор аутентификации при создании пользователя.


Токен аутентификации
--------------------

Информация для аутентификации пользователя представляется интерфейсом
`jandcode.core.auth.AuthToken`. Это интерфейс-метка. Конкретные токены 
могут быть любыми, какие пожелаете. Например имеется стандартный токен 
для имени пользователя и пароля `jandcode.core.auth.UserPasswdAuthToken`.

Токены используются процессорами аутентификации и должны быть совместимыми с ними.
Т.е. если некий процессор умеет принимать токен `jandcode.core.auth.UserPasswdAuthToken`,
то ему и нужно давать его для аутентификации.

