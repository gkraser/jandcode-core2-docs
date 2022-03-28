package jandcode.samples.dbm1.main;

import jandcode.commons.named.*;
import jandcode.core.apx.test.*;
import jandcode.core.dbm.domain.*;
import org.junit.jupiter.api.*;

public class Domain_Test extends Apx_Test {

    /**
     * Список всех доменов и их полей
     */
    @Test
    public void domain_list() throws Exception {
        DomainService domainSvc = getModel().bean(DomainService.class);
        NamedList<Domain> domains = domainSvc.getDomains();
        for (Domain domain : domains) {
            System.out.println("" + domain.getName());
            for (Field field : domain.getFields()) {
                System.out.println("  " + field.getName() + ": " + field.getDbDataType().getName());
            }
        }
    }


}
