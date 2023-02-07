/**
 * 16进制转换
 */
public class ToHex {
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        String hex = "0123456789abcdef";
        while(num != 0){
            sb.append(hex.charAt(num & 0xf));
            num = num >>4;
        }
        return sb.reverse().toString();
    }

    public static String toH(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int t = n / 16;
            if (t == 0) {
                if (n < 10) {
                    sb.append(n);
                } else {
                    sb.append((char) ('a' + n - 10));
                }
                n = 0;
            } else {
                if (t < 10) {
                    sb.append(t);
                } else {
                    sb.append((char) ('a' + t - 10));
                }
                n = n % 16;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((char) ('a' + 1));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE ^ 1));
        System.out.println(toHex(-1));
    }
}
