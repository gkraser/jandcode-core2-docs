package core._inc.cfg

import jandcode.core.std.*

/**
 * Моя конфигурация
 */
interface MyCfg extends Cfg {

    /**
     * Базовый url
     */
    String getBaseUrl();

}

class MyCfgImpl extends BaseCfg implements MyCfg {

    String getBaseUrl() {
        return getConf().getString("url/base", "http://host:8080")
    }

}

