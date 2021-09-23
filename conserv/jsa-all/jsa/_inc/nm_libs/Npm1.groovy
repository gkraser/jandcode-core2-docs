package jsa._inc.nm_libs

import jandcode.jc.*

class Npm1 extends ProjectScript {

    protected void onInclude() throws Exception {

        //= part1
        include(JsaJavaProject).with {
            // зависимости, попадающие в package.json,
            // включая инструменты для разработки и библиотеки
            // для клиенского приложения
            nodeJsDepends(
                    // инструменты
                    "@babel/cli",
                    "cross-env",
                    // для клиентского приложения
                    "axios",
            )
        }
        //=

    }
}