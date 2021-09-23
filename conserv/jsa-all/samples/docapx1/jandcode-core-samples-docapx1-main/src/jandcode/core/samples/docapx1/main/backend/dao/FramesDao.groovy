package jandcode.core.samples.docapx1.main.backend.dao

import jandcode.commons.*
import jandcode.commons.io.*
import jandcode.core.dao.*
import jandcode.core.web.*
import jandcode.core.web.virtfile.*

/**
 * Фреймы
 */
class FramesDao extends BaseDao {

    /**
     * Возвращает настройку routes для фреймов.
     * Что бы описывать их вручную.
     */
    @DaoMethod
    public List routes() throws Exception {
        List res = []
        String rootPath = "jandcode/core/samples/docapx1/main/js/frames"
        WebService webSvc = app.bean(WebService)
        //
        DirScanner<VirtFile> sc = webSvc.createDirScanner(rootPath)
        sc.include("**/*.vue")    // все vue-файлы
        sc.exclude("**/_*")       // исключаем то, что начинается с '_'
        sc.exclude("*.vue")       // исключаем все в корне frame
        List<VirtFile> lst = sc.load()
        //
        for (f in lst) {
            // убираем из пути rootPath
            String path = f.path.substring(rootPath.length())
            // имя файла: без расширения и с маленькой буквы
            String name = UtString.uncapFirst(UtFile.removeExt(UtFile.filename(path)))
            // формируем окончательный route-path
            path = "/" + UtVDir.join(UtFile.path(path), name)
            //
            Map item = [path: path, frame: f.path]
            res.add(item)
        }
        //
        return res
    }


}
