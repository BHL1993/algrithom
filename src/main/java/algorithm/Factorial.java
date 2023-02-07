package algorithm;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/9 11:20 上午
 */
public class Factorial {
    public int factorial(int i) {
        if (i <= 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static int factorial(int start, int currentRet) {
        if (start <= 1) {
            return currentRet;
        } else {
            return factorial(start - 1, start * currentRet);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5,1));
    }
}
