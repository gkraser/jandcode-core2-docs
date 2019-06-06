package commons._inc.ansifer;

import jandcode.commons.*;
import jandcode.commons.ansifer.*;

public class AnsiferExamples {

    public void example1() {
        // включаем ansi-консоль
        UtAnsifer.ansiOn();

        // выводим строку Hello желтым на синем
        System.out.println(UtAnsifer.color("yellow_h", "blue", "Hello"));
        // или так
        System.out.println(UtAnsifer.color(AnsiferColor.yellow_h, AnsiferColor.blue, "Hello"));

        // регистрируем стиль my-warn
        UtAnsifer.registerStyle("my-warn", AnsiferColor.red_h, AnsiferColor.cyan);

        // выводим строку Hello зарегистрированным стилем
        System.out.println(UtAnsifer.color("my-warn", "Hello"));

        // вылючаем ansi-консоль
        UtAnsifer.ansiOff();
    }

    public void reg1() {
        // регистрируем стиль
        UtAnsifer.registerStyle("my-style1", AnsiferColor.red_h, AnsiferColor.cyan);

        // регистрируем стиль по умолчанию, если он еще не зарегистрирован
        UtAnsifer.registerStyle("my-style2", AnsiferColor.red_h, AnsiferColor.cyan, true);

        // null указываем в случае, если хотим использовать цвет в консоле по умолчанию.
        // например здесь будет цвет желтый на черном, если консоль по умолчанию черная
        UtAnsifer.registerStyle("my-style3", AnsiferColor.yellow, null);

        // регистрируем стиль, но не задаем цвета, будут использованы цвета
        // консоли по умолчанию
        UtAnsifer.registerStyle("my-style4", null, null);
    }

}
