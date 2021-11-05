package web._inc.nodejs

import jandcode.core.nodejs.jc.*
import jandcode.jc.*

class Project1 extends ProjectScript {

    static beforeLoad = {
        // ...
        // подключаем инструментарий nodejs
        classpath("jandcode-core-nodejs-jc")
    }

    void onInclude() {
        // ...
        // подключаем поддержку nodejs
        include(NodeJsRootProject).with {
            // добавляем модули
            modules(
                    // как каталог, который содержит package.json
                    "./frontend",
                    // как маску для файлов package.json
                    "./js-modules/*/package.json",
            )

            /* указываем в каком каталоге располагается главный модуль,
               результаты сборки которого будут подключены как ресурсы в приложение */
            mainModule = "./frontend"
        }

    }
}
