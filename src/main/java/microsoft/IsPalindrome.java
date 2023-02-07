package microsoft;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/11 5:22 下午
 */
public class IsPalindrome {
    public static int cnt;

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int left = x;
        int first, last;
        while (left >= 10) {
            first = getFirst(x);
            last = x % 10;

            if (first != last) {
                return false;
            }

            left = (int) (x - first * Math.pow(10, cnt)) / 10;
        }

        return true;

    }

    public static int getFirst(int n) {
        while (n > 0) {
            if (n / 10 == 0) {
                return n;
            }
            n = n / 10;
            cnt++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(Integer.MIN_VALUE));
    }
}
