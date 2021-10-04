package modules._inc.auth;

import jandcode.commons.variant.*;
import jandcode.core.*;
import jandcode.core.auth.*;
import jandcode.core.auth.std.*;

public class AuthExample extends BaseComp {

    public void example1() throws Exception {
        // получаем сервис auth
        AuthService authSvc = getApp().bean(AuthService.class);

        // формируем токен авторизации
        AuthToken authToken = new DefaultUserPasswdAuthToken("user1", "passwd1");

        // делаем login и получаем пользователя или ошибку авторизации
        AuthUser user = authSvc.login(authToken);

        // делаем пользователя текущим для потока
        authSvc.setCurrentUser(user);

        // получаем текущего пользователя (для текущего потока)
        user = authSvc.getCurrentUser();

        // атрибуты пользователя, будут заполнены при логине
        IVariantMap userAttrs = user.getAttrs();

        // а не гость ли это (гость не авторизован)?
        if (user.isGuest()) {
            System.out.println("Гость!");
        }
    }


}
