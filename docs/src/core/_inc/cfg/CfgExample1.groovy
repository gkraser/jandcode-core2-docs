package core._inc.cfg

import jandcode.commons.conf.*
import jandcode.core.*
import jandcode.core.std.*

class CfgExample1 extends BaseComp {

    void example1() {
        // получаем сервис cfg
        CfgService cfgSvc = getApp().bean(CfgService.class)
        // получаем конфигурацию
        Conf cfgConf = cfgSvc.getConf()
        // пользуемся
        String param1 = cfgConf.getString("section1/param1")
        String param3 = cfgConf.getString("section2/section3/param3")
    }

    void subst1() {
        CfgService cfgSvc = getApp().bean(CfgService.class)
        String param3 = cfgSvc.getConf().getString("section2/section3/param3")
        // param3="3-2-1"
    }

    void useMyCfg1() {
        MyCfg myCfg = getApp().bean(MyCfg.class)
        String baseUrl = myCfg.getBaseUrl()
    }

}


