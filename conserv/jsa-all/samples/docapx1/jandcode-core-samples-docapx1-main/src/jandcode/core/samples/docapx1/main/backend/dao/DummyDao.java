package jandcode.core.samples.docapx1.main.backend.dao;

import jandcode.commons.*;
import jandcode.commons.datetime.*;
import jandcode.core.dao.*;

/**
 * Данные-заглушки.
 * Просто что бы продемонстрировать, что dao работает.
 */
public class DummyDao extends BaseDao {

    /**
     * Текущее время на сервере. С задержкой.
     *
     * @param delayMsec задержка в msec
     */
    @DaoMethod
    public XDateTime curTime(long delayMsec) throws Exception {
        if (delayMsec > 0) {
            Thread.sleep(delayMsec);
        }
        return UtDateTime.now();
    }

}
