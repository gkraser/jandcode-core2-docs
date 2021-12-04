package db._inc.dao;

import jandcode.core.dao.*;

public class DaoSimple1 extends BaseDao {

    public String meth1(String param1) throws Exception {
        return "meth1 PARAM1=" + param1;
    }

    public String meth2(String param1) throws Exception {
        return "meth2 PARAM1=" + param1;
    }

    // это метод для внутреннего использования внутри dao
    protected void utilsMethod1() {
    }
    
}
