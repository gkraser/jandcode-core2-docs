package core._inc.launcher;

import jandcode.commons.cli.*;
import jandcode.core.*;
import jandcode.core.launcher.*;

public class MyCmd1 extends BaseLauncherCmd {

    // в этом методе описываем команду и ее опции
    public void help(HelpBuilder h) throws Exception {
        h.desc("Описание команды cmd1");
        h.opt("q", "Опция без аргументов");
        h.opt("w", "Опция с аргументом", "ARG");
        h.opt("e", "Опция с аргументом и указанием значения по умолчанию", "ARG", "123");
    }

    // в этом методе реализуем код команды
    public void exec() throws Exception {
        // аргументы командной строки
        CliArgs args = getArgs();

        // читаем опции
        boolean q = args.getBoolean("q");
        // или так
        q = args.containsKey("q");

        // опции с аргументами
        String w = args.getString("w");
        String e = args.getString("e", "123");

        // доступно приложение
        App app = getApp();
    }

}
