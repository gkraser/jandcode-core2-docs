package commons._inc.ansifer;

import jandcode.commons.*;
import jandcode.commons.ansifer.*;

public class AnsiferExamples {

    public void example1() {
        // включаем ans-консоль
        UtAnsifer.ansiOn();

        // выводим строку Hello желтым на синем
        System.out.println(UtAnsifer.color("yellow_h", "blue", "Hello"));
        // или так
        System.out.println(UtAnsifer.color(AnsiferColor.yellow_h, AnsiferColor.blue, "Hello"));

        // регистрируем стиль my-warn
        UtAnsifer.registerStyle("my-warn", AnsiferColor.red_h, AnsiferColor.cyan);

        // выводим строку Hello зарегистрированным стилем
        System.out.println(UtAnsifer.color("my-warn", "Hello"));

        // вылючаем ans-консоль
        UtAnsifer.ansiOff();
    }

}
