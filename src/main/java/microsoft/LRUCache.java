package microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LRU 缓存
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

    private Map<Integer, DoubleLinkedNode> map = new HashMap<>();
    DoubleLinkedNode dummyHead;
    DoubleLinkedNode dummyTail;
    private int capacity;
    private int size;

    /**
     * 哈希表+双向链表
     *
     * 哈希表实现O(1)的查找
     * 双向链表实现O(1)的插入
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new DoubleLinkedNode();
        dummyTail = new DoubleLinkedNode();

        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        DoubleLinkedNode node = this.map.get(key);
        if (node == null) {
            return -1;
        } else {
            //将当前node移动至最前位置
            removeToHead(node);
            return node.value;
        }
    }


    public void put(int key, int value) {
        DoubleLinkedNode node = this.map.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            this.map.put(key, newNode);
            //将node添加至最前位置
            addToHead(newNode);
            size++;
            if (size > capacity) {
                this.map.remove(deleteTail().key);
                size--;
            }
        } else {
            node.value = value;
            removeToHead(node);
        }
    }

    private DoubleLinkedNode deleteTail() {
        DoubleLinkedNode tail = dummyTail.pre;
        DoubleLinkedNode pre = tail.pre;

        pre.next = dummyTail;
        dummyTail.pre = pre;

        return tail;
    }

    private void addToHead(DoubleLinkedNode node) {
        DoubleLinkedNode head = dummyHead.next;
        node.next = head;
        node.pre = dummyHead;
        head.pre = node;
        dummyHead.next = node;
    }

    private void removeToHead(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;

        addToHead(node);
    }

    private static class DoubleLinkedNode {
        public DoubleLinkedNode pre;
        public DoubleLinkedNode next;

        public Integer key;
        public Integer value;

        public DoubleLinkedNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public DoubleLinkedNode() {
        }
    }
}
