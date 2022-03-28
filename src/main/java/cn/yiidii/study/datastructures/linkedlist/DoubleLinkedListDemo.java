package cn.yiidii.study.datastructures.linkedlist;

/**
 * 双向链表
 *
 * @author ed w
 * @since 1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        Node2 node1 = new Node2(1, "一");
        Node2 node2 = new Node2(2, "二");
        Node2 node3 = new Node2(3, "三");
        Node2 node4 = new Node2(4, "四");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);

        // 打印
        System.out.println("打印");
        doubleLinkedList.list();
        System.out.println();

        // 修改
        System.out.println("修改");
        Node2 node2New = new Node2(2, "二new");
        doubleLinkedList.update(node2New);
        doubleLinkedList.list();
        System.out.println();

        // 删除
        System.out.println("删除");
        doubleLinkedList.del(node2);
        doubleLinkedList.list();
        System.out.println();

        // 有序插入
        System.out.println("有序插入");
        doubleLinkedList.addByOrder(node2New);
        doubleLinkedList.list();
        System.out.println();
    }

}

class DoubleLinkedList {

    private Node2 head = new Node2(0, "");

    public void add(Node2 node) {
        Node2 temp = this.head;

        while (true) {
            if (temp.next == null) {
                // 到链表末尾了
                break;
            }
            // 往后移动
            temp = temp.next;
        }
        // 添加节点
        temp.next = node;
        node.pre = temp;
    }

    public void addByOrder(Node2 node) {
        // TODO
        Node2 temp = this.head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                // 找到了
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.err.println("该节点已存在");
        } else {
            node.next = temp.next;
            node.pre = temp;

            temp.next.pre = node;
            temp.next = node;
        }
    }

    /**
     * 更新节点（同单向链表一样）
     *
     * @param node
     */
    public void update(Node2 node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.err.println("空链表");
            return;
        }
        Node2 temp = this.head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
        } else {
            System.err.println("无此node");
        }
    }

    /**
     * 删除节点
     *
     * @param node
     */
    public void del(Node2 node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.err.println("空链表");
            return;
        }
        Node2 temp = this.head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                // 如果节点不是最后一个
                temp.next.pre = temp.pre;
            }
        } else {
            System.err.println("无此node");
        }
    }

    /**
     * 遍历
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node2 temp = this.head.next;
        while (true) {
            if (temp == null) {
                // 到链表末尾了
                break;
            }
            System.out.println(temp);
            // 后移
            temp = temp.next;
        }
    }
}

class Node2 {

    public int no;
    public String name;
    public Node2 pre;
    public Node2 next;

    public Node2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}