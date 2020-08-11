package web._inc.action

import jandcode.core.web.action.*

import java.lang.reflect.*

class ActionExecutor1 extends BaseAction {

    static class Executor1 implements ActionMethodExecutor {

        String data

        void execActionMethod(BaseAction action, Method method) throws Exception {
            // вызываем оригинальный метод и передаем себя в качестве параметра
            method.invoke(action, this)

            // пользуемся результатами
            Map m = new HashMap()
            m.put("data", data)

            // рендерим результат
            action.getReq().render(m)
        }

        void setData(String data) {
            this.data = data
        }

    }

    //////

    void m1(Executor1 ex) {
        ex.setData("hello")
    }

}
