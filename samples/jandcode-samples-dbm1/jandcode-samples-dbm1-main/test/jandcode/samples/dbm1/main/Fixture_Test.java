package jandcode.samples.dbm1.main;

import jandcode.core.apx.test.*;
import org.junit.jupiter.api.*;

public class Fixture_Test extends Apx_Test {

    @Test
    public void updateFixtureSuite() throws Exception {
        dbm.updateFixtureSuite("testdata");
    }


}
