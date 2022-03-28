package cn.yiidii.study.datastructures.linkedlist.application;

/**
 * 约瑟夫问题
 *
 * <p>约瑟夫环问题的起源来自犹太历史学家约瑟夫和他的朋友以及39其余的犹太人，总共41人为了躲避敌人，藏在一个山洞中，
 * <p>39个犹太人决定宁愿死也不被敌人抓到，于是决定自杀，所有人排成一个圈，由第一个人开始报数，每当数到3，就自杀。
 * <p>这个游戏接着从自杀的位置开始，还是从1数到3。依次类推，约瑟夫将朋友和自己安排在了16和31的位置，最后顺利逃过了 自杀这一劫，因为最后就剩他一个人了。
 *
 * @author ed w
 * @since 1.0
 */
public class Josephus {

    public static void main(String[] args) {
        josephus(5, 3);
        josephus(41, 3);
    }

    /**
     * head -> 1   ->    2
     *         |         |
     *         v         v
     *         5 <- 4 <- 3
     */
    public static void josephus(int size, int num) {
        System.out.println(String.format("队列长度：%d，报数：%d", size, num));
        // 头节点不储存数据
        Node head = new Node(-1);
        Node curr = head;
        for (int i = 1; i <= size; i++) {
            Node node = new Node(i);
            curr.setNext(node);
            curr = node;
        }
        // 链表首尾相连成环，不包含头节点
        curr.setNext(head.getNext());

        // 统计开始
        Node temp = head;
        do {
            for (int i = 0; i < num - 1; i++) {
                temp = temp.getNext();
            }
            System.out.print(temp.getNext().getNo() + " -> ");
            temp.setNext(temp.getNext().getNext());
        } while (temp.getNext() != temp);

        System.out.println("(left:" + temp.getNo() + ")\n");
    }
}

class Node {

    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
