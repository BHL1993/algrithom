package log;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/31 2:48 下午
 */

public class Log {

    private static final String s = "";

    public static void main(String[] args) {
        List<String> ist = new ArrayList<>();
        ist.add("2");
        ist.add("4");
        ist.add("3");
        List<String> ist1 = new ArrayList<>();
        ist1.add("3");
        ist1.add("4");
        ist.removeAll(ist1);
        System.out.println(ist);
    }
}
