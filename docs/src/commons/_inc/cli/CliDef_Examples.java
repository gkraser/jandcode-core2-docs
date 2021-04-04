package commons._inc.cli;

import jandcode.commons.*;
import jandcode.commons.cli.*;

import java.util.*;

public class CliDef_Examples {

    void simpleParse() {
        // допустим имеем такую командную строку
        String[] args = new String[]{"-a", "-m", "arg-value"};
        // создаем экземпляр CliDef
        CliDef cli = UtCli.createCliDef();
        // настраиваем опции
        cli.opt("optWithArg").names("-m,--my").arg(true)
                .desc("Это опция с аргументом");
        cli.opt("noArgOpt").names("-a")
                .desc("Это опция без аргумента");
        // создаем парзер
        CliParser parser = UtCli.createCliParser(args);
        // забираем значения из командной строки
        Map<String, Object> values = parser.extractOpts(cli);
        // получаем: values = [optWithArg: arg-value, noArgOpt: true]
    }

}
