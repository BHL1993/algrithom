package microsoft;

import listnode.ListNode;

/**
 * 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/11 2:51 下午
 */
public class Partition {
    /**
     * 在迭代遍历链表的过程中，分别找到 第一个比x小的节点 以及 第一个大于等于x的节点，分别记作两个头，smallerHead、biggerHeader
     *
     * 如果某个节点的值小于x
     *      1、smallerHead不存在，则该节点记作smallerHead
     *      2、smallerHead存在，则将该节点追加至smallerHead为头的链表末尾
     * 如果某个节点的值大于等于x
     *      1、biggerHeader不存在，则该节点记作biggerHeader
     *      2、biggerHeader存在，则将该节点追加至biggerHeader为头的链表末尾
     * 遍历结束后，
     *      smallerHeader如果为空，代表原链表中所有节点的值均大于等于x，直接返回biggerHeader
     *      biggerHeader如果为空，代表原链表中所有节点的值均小于x，直接返回smallerHeader
     *      如果biggerHeader和smallerHeader都不为空，则将biggerHeader追加至smallerHeader末尾
     *      Tips：biggerHeader尾节点需要将next置为null，以防形成循环链表
     *
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallerHead = null;
        ListNode smallerTmp = null;

        ListNode biggerHead = null;
        ListNode biggerTmp = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                if (smallerHead == null) {
                    smallerHead = cur;
                } else {
                    smallerTmp.next = cur;
                }
                smallerTmp = cur;
            } else {
                if (biggerHead == null) {
                    biggerHead = cur;
                } else {
                    biggerTmp.next = cur;
                }
                biggerTmp = cur;
            }
            cur = cur.next;
        }

        if (smallerHead == null) {
            return biggerHead;
        }

        if (biggerHead == null) {
            return smallerHead;
        }

        biggerTmp.next = null;
        smallerTmp.next = biggerHead;
        return smallerHead;
    }
}
