/**
 * @author ：BaiHailong
 * @date ：Created in 2021/9/27 5:56 下午
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder();

        char[] longArr = num1.toCharArray();
        char[] shortArr = num2.toCharArray();

        if (num1.length() < num2.length()) {
            longArr = num2.toCharArray();
            shortArr = num1.toCharArray();
        }


        int over = 0;
        int index = 1;

        int longLen = longArr.length;
        int shortLen = shortArr.length;

        while (index <= shortLen) {
            char c1 = longArr[longLen - index];
            char c2 = shortArr[shortLen - index];

            int sum = (c1 - '0') + (c2 - '0') + over;
            if (sum >= 10) {
                over = 1;
                sum = sum - 10;
            } else {
                over = 0;
            }

            ret.append(sum);
            index++;
        }

        while (index <= longLen) {
            char c = longArr[longLen - index];
            int sum = (c - '0') + over;
            if (sum >= 10) {
                over = 1;
                sum = sum - 10;
            } else {
                over = 0;
            }

            ret.append(sum);
            index++;
        }

        if (over == 1) {
            ret.append("1");
        }

        return ret.reverse().toString();
    }
}
