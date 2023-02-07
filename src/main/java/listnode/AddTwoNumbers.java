package listnode;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/9/27 6:30 下午
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4, new ListNode(9));

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6, new ListNode(4, new ListNode(9)));

        ListNode ret = addTwoNumbers(l1, l2);

        System.out.println("11");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;

        int t = 0;

        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }

            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t = t / 10;
        }

        return dummyHead.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int curry = 0;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(0, l1);
        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + curry;
            if (tmp >= 10) {
                curry = 1;
                l1.val = tmp - 10;
            } else {
                curry = 0;
                l1.val = tmp;
            }
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            pre.next = l2;
            l1 = l2;
        }

        while (l1 != null) {
            int tmp = l1.val + curry;
            if (tmp >= 10) {
                curry = 1;
                l1.val = tmp - 10;
            } else {
                curry = 0;
                l1.val = tmp;
            }
            pre = l1;
            l1 = l1.next;
        }

        if (curry == 1) {
            pre.next = new ListNode(1);
        }

        return dummyHead.next;

    }
}
