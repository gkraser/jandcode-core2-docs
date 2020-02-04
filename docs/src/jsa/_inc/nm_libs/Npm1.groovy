package jsa._inc.nm_libs

import jandcode.jc.*

class Npm1 extends ProjectScript {

    protected void onInclude() throws Exception {

        //= part1
        include(JsaJavaProject).with {
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

            // формируем список файлов из node_modules, которые
            // будут использоваться в клиентском приложении
            nodeDependsClient(
                    /* ключ - каталог в node_modules
                       может быть вложенным, например '@babel/cli' */
                    "axios": [
                            // значение - список масок, относительно каталога-ключа

                            // включающая маска
                            "dist/**/*",

                            // исключающая маска
                            "!**/*.map"
                    ],

                    /* ключ может быть пустым,
                       тогда маски задаются относительно корня node_modules */
                    "": [
                            "cross-env/**/*.css"
                    ]
            )

            // маппинг модулей в node_modules
            nodeModuleMapping(
                    /* ключ - как модуль импортируется
                       значение - что на самом деле будет импортироваться.
                       В этом случае: require('vue') -> require('vue/dist/vue')
                     */
                    "vue": "vue/dist/vue",
            )

            // указываем файлы из клиенского набора node_modules,
            // которые не нуждаются в процедуре извлечения вызовов require()
            nodeExtractRequire(
                    /* только исключающие маски, т.к. по умолчанию
                       require() извлекается из всех файлов js
                     */
                    "!mocha/**/*.js",
            )

        }
        //=

        //= part2
        // module 1
        include(JsaJavaProject).with {
            nodeDepends(
                    "cross-env": "5.2.0",
                    "axios": "0.18.0",
            )
        }

        // module 2
        include(JsaJavaProject).with {
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