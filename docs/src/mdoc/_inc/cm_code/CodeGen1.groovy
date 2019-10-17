package mdoc._inc.cm_code

import jandcode.commons.variant.*
import jandcode.mdoc.builder.*
import jandcode.mdoc.cm.*

/**
 * Пример генератора файлов для команды @@code
 */
class CodeGen1 extends BaseCodeGen {

    /**
     * Метод генерации.
     * Должен вернуть строку с содержимым виртуального файла.
     */
    void gen1() {
        // Доступно:

        // Атрибуты, переданные в команде @@code (IVariantMap с расширениями).
        // Из списка атрибутов исключены file, part, lang, title (они обрабатываются
        // командой @@code).
        Attrs attrs = getAttrs()    // class: jandcode.mdoc.cm.BaseCodeGen.Attrs

        // Установить расширение генерируемого файла.
        // По умолчанию - txt
        setExt("txt")

        // В контексте какого OutBuilder выполняется.
        OutBuilder builder = getOutBuilder()
        // class: jandcode.mdoc.builder.OutBuilder

        // В контексте какого OutFile выполняется.
        OutFile outFile = getOutFile() // class: jandcode.mdoc.builder.OutFile

        // Общий кеш, который существует все время работы outBuilder.
        IVariantMap cache = getCache()

        // Кеш для текущего класса, который существует все время работы outBuilder.
        IVariantMap cacheThis = getCacheThis()

        // возвращаем текст для вставки в @@code
        outText("generated text for attrs: ${attrs}")
    }

    /**
     * Еще один метод генерации.
     */
    void gen2() {
        outText("generated 2 text for attrs: ${attrs}")
    }

}
