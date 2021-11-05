package web._inc.ext_resource

import jandcode.core.web.jc.*
import jandcode.jc.*

class Project1 extends ProjectScript {

    void onInclude() {

        // .....

        include(WebRootProject).with {
            // подключаем каталог ./frontend/_gen к проекту
            // в виртуальную папку "app", т.е. все в каталоге ./frontend/_gen
            // будет доступно в приложении по адресу http://HOST/app
            addResourceWebroot("./frontend/_gen", "app")

            // подключаем каталог ./frontend/public к проекту
            // в корневую виртуальную папку, т.е. все в каталоге ./frontend/public
            // будет доступно в приложении по адресу http://HOST/
            addResourceWebroot("./frontend/public")
        }

    }
}
