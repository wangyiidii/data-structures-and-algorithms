package cn.yiidii.study.datastructures.stack;

import java.util.Scanner;

/**
 * 数组实现栈
 *
 * @author ed w
 * @since 1.0
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        boolean loop = true;
        Scanner s = new Scanner(System.in);
        while (loop) {
            String next = s.next();
            switch (next) {
                case "push": {
                    System.out.println("请输入一个数字:");
                    int i = s.nextInt();
                    arrayStack.push(i);
                    break;
                }
                case "pop": {
                    try {
                        int pop = arrayStack.pop();
                        System.out.println("弹出: " + pop);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                }
                case "ls": {
                    arrayStack.list();
                    break;
                }
                case "exit": {
                    loop = false;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}

class ArrayStack {

    /**
     * 栈大小
     */
    private int size;

    /**
     * 数据
     */
    private int[] arr;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStack(int size) {
        this.size = size;
        this.arr = new int[this.size];

    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int value) {
        if (isFull()) {
            System.err.println("栈满了");
            return;
        }
        arr[++top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("无数据");
        }
        return arr[top--];
    }

    /**
     * 打印
     */
    public void list() {
        if (isEmpty()) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("%d: %d\n", i, arr[i]);
        }
    }

}
