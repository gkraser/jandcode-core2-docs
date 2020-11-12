package jandcode.core.samples.docapx1.main.backend

import jandcode.core.samples.docapx1.main.backend.dao.*
import org.junit.jupiter.api.*

class FramesDao_Test extends CustomDao_Test {

    @Test
    public void routes() throws Exception {
        def dao = createDao(FramesDao)
        def z = dao.routes()
        //
        println z
    }


}
