package microsoft;

/**
 * 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/7 1:21 下午
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int cur = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + cur;
            digits[i] = tmp % 10;
            cur = tmp / 10;
        }

        if (cur > 0) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = cur;
            for (int i = 0; i < digits.length; i++) {
                newArr[i + 1] = digits[i];
            }
            return newArr;
        } else {
            return digits;
        }
    }
}
