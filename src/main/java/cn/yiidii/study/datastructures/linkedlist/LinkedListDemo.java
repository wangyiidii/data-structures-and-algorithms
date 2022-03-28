package cn.yiidii.study.datastructures.linkedlist;

import java.util.Stack;

/**
 * 单向链表队列
 *
 * @author ed w
 * @since 1.0
 */
public class LinkedListDemo {

    public static void main(String[] args) {

        Node node1 = new Node(1, "一");
        Node node2 = new Node(2, "二");
        Node node3 = new Node(3, "三");
        Node node4 = new Node(4, "四");

        LinkedList linkedList = new LinkedList();
        // 添加
//        nodeDemo.add(node1);
//        nodeDemo.add(node2);
//        nodeDemo.add(node3);
//        nodeDemo.add(node4);

        // 测试顺序添加
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);

        // 测试修改
//        Node node2New = new Node(6, "2new");
//        nodeDemo.update(node2New);

        // 删除节点
//        nodeDemo.del(node2);
//        nodeDemo.del(node3);

        System.out.println("链表有效长度: " + linkedList.length());

        // 获取指点下标的节点
//        System.out.println(nodeDemo.get(1));

//        nodeDemo.reverse();

        System.out.println("====");
        linkedList.reversePrint();
        System.out.println("====");

        // 打印
        linkedList.list();

    }
}

class LinkedList {

    private Node head = new Node(0, "");

    public Node getHeadNode() {
        return this.head;
    }

    public void add(Node node) {
        Node temp = this.head;

        while (true) {
            if (temp.next == null) {
                // 到链表末尾了
                break;
            }
            // 往后移动
            temp = temp.next;
        }
        // 退出while循环时，temp为链表最后
        temp.next = node;
    }

    public void addByOrder(Node node) {
        Node temp = this.head;
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
            temp.next = node;
        }
    }

    /**
     * 更新节点
     *
     * @param node
     */
    public void update(Node node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.err.println("空链表");
            return;
        }
        Node temp = this.head;
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
//            this.add(node);
        }
    }

    /**
     * 删除节点
     *
     * @param node
     */
    public void del(Node node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.err.println("空链表");
            return;
        }
        Node temp = this.head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;

        } else {
            System.err.println("无此node");
        }
    }

    /**
     * 查找链表找中导树第k个节点
     */
    public Node get(int index) {
        int length = this.length();
        if (length == 0) {
            return null;
        }

        if (index < 0 || index > length) {
            return null;
        }
        Node curr = head.next;
        for (int i = 0; i < length - index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 链表反转
     */
    public void reverse() {
        Node reverseHeadNode = new Node(0, "");
        Node curr = this.head.next;
        Node next;
        while (curr != null) {
            // 暂时保存下一个节点
            next = curr.next;
            curr.next = reverseHeadNode.next;
            reverseHeadNode.next = curr;
            curr = next;
        }
        head.next = reverseHeadNode.next;
    }

    /**
     * 逆序打印链表
     */
    public void reversePrint() {
        if (length() == 0) {
            System.out.println("链表为空");
            return;
        }
        Node curr = this.head.next;
        Stack<Node> nodes = new Stack<>();
        while (curr != null) {
            nodes.push(curr);
            curr = curr.next;
        }

        while (nodes.size() > 0) {
            Node pop = nodes.pop();
            System.err.println(pop);
        }
    }

    /**
     * 合并两个有序的单向链表，合并之后链表依然有序
     */
    public void test () {

    }

    /**
     * 获取链表长度
     */
    public int length() {
        if (head.next == null) {
            return 0;
        }

        int length = 0;
        Node curr = head.next;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node temp = this.head.next;
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


class Node {

    public int no;
    public String name;
    public Node next;

    public Node(int no, String name) {
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

