package jandcode.samples.dbm1.main;

import jandcode.core.apx.test.*;
import jandcode.core.dbm.ddl.*;
import org.junit.jupiter.api.*;

public class DbStruct_Test extends Apx_Test {

    /**
     * Получение полного скрипта для создания базы данных с нуля.
     */
    @Test
    public void generate_create_sql() throws Exception {
        DDLService svc = getModel().bean(DDLService.class);
        DDLScript script = svc.grabScript();
        String text = script.getSqlScript();
        System.out.println(text);
    }


}
