package jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/10/25 2:18 下午
 */
public class HashExample {
    static MarkWord markWord;

    public static void main(String[] args) {
        MarkWord markWord = new MarkWord();

        System.out.println("before hash");
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());

        System.out.println("binary hash----" + Integer.toBinaryString(markWord.hashCode()));
        System.out.println("hex hash----" + Integer.toHexString(markWord.hashCode()));
        System.out.println("hash----" + markWord.hashCode());

        System.out.println("after hash");
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
    }
}
