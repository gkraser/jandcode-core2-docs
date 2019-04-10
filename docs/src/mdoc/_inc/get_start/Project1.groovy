package mdoc._inc.get_start

import jandcode.jc.*
import jandcode.mdoc.jc.*

// (1) import для mdoc

class Project1 extends ProjectScript {

    static beforeLoad = {
        // ...

        // (2) mdoc помещаем в classpath для проекта
        classpath("jandcode-mdoc-jc")
    }

    void onInclude() {
        // ...

        // (3) Настраиваем проект для mdoc
        include(MDocProject).with {
            // runtime-зависимости для запуска mdoc
            depends.prod.add(
            )
            // каталоги с исходниками документации
            addSrc('doc')

            // свойства документации

            // содержание
            props['toc'] = 'toc.xml'
            // заголовок документации
            props['title'] = project.name
        }
    }

}