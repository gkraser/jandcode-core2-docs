package commons._inc.ansifer

import jandcode.commons.ansifer.*
import jandcode.commons.ansifer.impl.*
import jandcode.mdoc.cm.*

class DefaultAnsiferStyles extends BaseCodeGen {

    private String makeStyleTable(Ansifer a) {
        List<String> lstNames = new ArrayList<>(a.getStyleNames());
        lstNames.sort(null);
        int maxLen = 0;
        for (String nm : lstNames) {
            maxLen = Math.max(maxLen, nm.length());
        }
        StringBuilder b = new StringBuilder();
        for (String nm : lstNames) {
            String s = nm + " ";
            AnsiferStyle st = a.getStyle(nm)

            b.append(a.color(st, String.format("%-" + (maxLen + 1) + "s", s) + " = " +
                    st.getColor().toString() + "/" +
                    st.getBackground().toString()));
            b.append("\n");
        }
        return b.toString();
    }

    void m1() {
        Ansifer a = new AnsiferImpl()
        String s = makeStyleTable(a)
        outText(s)
    }

}
