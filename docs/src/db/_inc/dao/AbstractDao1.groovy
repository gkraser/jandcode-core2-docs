package db._inc.dao

import jandcode.core.dao.*

/**
 * Это некий интерфейс для сбора и описания dao-методов
 */
interface IMyDao {
    String method1()
}

/**
 * Это реализатор интерфейса IMyDao
 */
class MyDao_impl implements IMyDao {
    String tag

    MyDao_impl(String tag) {
        this.tag = tag
    }

    String method1() {
        return "m1:${this.tag}"
    }
}

/**
 * Это dao. Этот класс будет использоватся как сборник и dao-методов,
 * но вызов его абстрактных методов будет делегироватся объекту,
 * который вернет метод impl().
 */
abstract class MyDao_dao extends BaseDao implements IMyDao {

    /**
     * Предоставление реализатора методов dao
     */
    public MyDao_impl impl() {
        return new MyDao_impl("t1")
    }

}
