package mdoc._inc.sourcefiles

import jandcode.jc.*
import jandcode.mdoc.jc.*

class Project1 extends ProjectScript {

    void src1() {
        //= src
        include(MDocProject).with {
            addSrc('src')
            addSrc('src2')
        }
        //= mount-to
        include(MDocProject).with {
            addSrc('src')
            addSrc('src2', prefix: 'dir1/mount1')
        }
        //= mount-theme1
        include(MDocProject).with {
            addSrc('src')
            addSrc('theme', prefix: '_theme')
        }
        //= srcfull
        include(MDocProject).with {
            addSrc('src', prefix: "", resources: false, includes: [], excludes: [])
        }
        //=
    }

}