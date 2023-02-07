package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流的第 K 大数值
 * 
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 
 * 请实现 KthLargest类：
 * 
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 8:09 下午
 */
public class KthLargest {

    PriorityQueue<Integer> queue;
    public int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.k = k;
        for (int i : nums) {
            queue.offer(i);
        }
    }

    public int add(int val) {
        queue.offer(val);

        if(queue.size() > this.k){
            queue.poll();
        }

        return queue.peek();
    }
}
