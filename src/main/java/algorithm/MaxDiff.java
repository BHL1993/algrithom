package algorithm;

/**
 * 最大差
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/8 6:31 下午
 */
public class MaxDiff {
    public static void main(String[] args) {
        int [] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxDiff(a));
    }

    public static int maxDiff(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price);
        }

        return max - min;
    }
}
