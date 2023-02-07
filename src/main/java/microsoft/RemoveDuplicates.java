package microsoft;

/**
 * 删除有序数组中的重复项
 * 
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 9:47 上午
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int res = 1;
        int pre = nums[0];

        int fast = 0;
        int slow = 1;

        while (fast < nums.length) {
            if (nums[fast] > pre) {
                nums[slow++] = nums[fast];
                pre = nums[fast];
                res++;
            }

            fast++;
        }

        return res;
    }
}
