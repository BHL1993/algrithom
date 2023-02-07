package listnode;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/9/27 6:29 下午
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
