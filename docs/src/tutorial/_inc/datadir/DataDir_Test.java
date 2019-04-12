package tutorial._inc.datadir;

import jandcode.core.std.DataDirService;
import jandcode.core.test.App_Test;
import org.junit.jupiter.api.Test;

public class DataDir_Test extends App_Test {

    @Test
    public void name() {
        //= part1
        //
        String s_myRoot = app.bean(DataDirService.class).getPath("my-root");
        System.out.println("my-root = " + s_myRoot);
        //
        String s_temp = app.bean(DataDirService.class).getPath("temp");
        System.out.println("temp = " + s_temp);
        //= part2
        String s_myTempFile = app.bean(DataDirService.class).getPath("temp", "internal-dir/file1.txt");
        System.out.println("my-temp-file = " + s_myTempFile);
        //=
        String s_files1 = app.bean(DataDirService.class).getPath("my-files1");
        System.out.println("my-files1 = " + s_files1);
        //=
    }

}
