package core._inc.launcher

import jandcode.core.jc.*
import jandcode.jc.*

class AddRunConfig1 extends ProjectScript {

    protected void onInclude() throws Exception {
        include(AppRunBat).with {
            // добавляем конфигурацию с именем 'app-run serve'
            // и параметрами
            addRunConfig("app-run serve", "serve -log -p:8080 -c:/jc")

            // еще вариант
            addRunConfig("serve2", "serve -p:9000")
        }
    }
}
