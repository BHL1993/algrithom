package microsoft;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/12 9:36 下午
 */
public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        int[] n = new int[]{1, 5, 10, 50, 100, 500, 1000};

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 0);
        map.put('V', 1);
        map.put('X', 2);
        map.put('L', 3);
        map.put('C', 4);
        map.put('D', 5);
        map.put('M', 6);

        int res = n[map.get(s.charAt(0))];
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (pre == 'I') {
                if (s.charAt(i) == 'V') {
                    res += 3;
                } else if (s.charAt(i) == 'X') {
                    res += 8;
                } else {
                    res += n[map.get(s.charAt(i))];
                }
            } else if (pre == 'X') {
                if (s.charAt(i) == 'L') {
                    res += 30;
                } else if (s.charAt(i) == 'C') {
                    res += 80;
                } else {
                    res += n[map.get(s.charAt(i))];
                }
            } else if (pre == 'C') {
                if (s.charAt(i) == 'D') {
                    res += 300;
                } else if (s.charAt(i) == 'M') {
                    res += 800;
                } else {
                    res += n[map.get(s.charAt(i))];
                }
            } else {
                res += n[map.get(s.charAt(i))];
            }

            pre = s.charAt(i);
        }

        return res;
    }
}
