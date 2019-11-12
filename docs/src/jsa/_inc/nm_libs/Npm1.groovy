package jsa._inc.nm_libs

import jandcode.jc.*

class Npm1 extends ProjectScript {

    protected void onInclude() throws Exception {

        //= part1
        include(JsaProject).with {
            // зависимости, попадающие в package.json,
            // включая инструменты для разработки и библиотеки
            // для клиенского приложения
            nodeDepends(
                    // инструменты
                    "@babel/cli": "7.2.3",
                    "cross-env": "5.2.0",
                    // для клиентского приложения
                    "axios": "0.18.0",
            )

            // формируем в списке globs маски файлов из node_modules, которые
            // будут использоватся в клиентском приложении
            def globs = []
            globs.addAll(
                    // включающая маска
                    "axios/package.json",  // нужен обязательно!
                    "axios/dist/**/*",
                    // исключающая маска
                    "!axios/**/*.map",
            )

            // регистрация команды gulp, которая скопирует выбранные
            // файлы для использвания в клиенском приложении
            gulpTask(name: "nm", globs: globs)
        }
        //=

        //= part2
        // module 1
        include(JsaProject).with {
            nodeDepends(
                    "cross-env": "5.2.0",
                    "axios": "0.18.0",
            )
        }

        // module 2
        include(JsaProject).with {
            nodeDepends(
                    "@babel/cli": "7.2.3",
                    "axios": "0.17.0",
            )
        }

        /* Итоговый список в приложении:
                 [
                    "cross-env": "5.2.0",
                    "@babel/cli": "7.2.3",
                    "axios": "0.17.0",
                 ]
         */
        //=


    }
}