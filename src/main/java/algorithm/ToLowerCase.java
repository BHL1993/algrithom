package algorithm;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/12 10:12 上午
 */
public class ToLowerCase {
    public String toLowerCase(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (isBigLitter(c[i])){
                c[i] = (char)(c[i] -('A' - 'a'));
            }
        }
        return String.copyValueOf(c);
    }

    public boolean isBigLitter(char c) {
        return 'A' <= c && c <= 'Z';
    }
}
