package cn.yiidii.study.datastructures.queue;

import java.util.Scanner;

/**
 * 数组实现队列
 *
 * @author ed w
 * @since 1.0
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        // 创建一个队列
        CircleArray circleArray = new CircleArray(4);

        // 接收用户的输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        // 输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(add)：从队列里取出数据");
            System.out.println("h(head)：查看队列头部数据");
            System.out.println("e(exit)：退出程序");

            // 接收一个字符
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数字：");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headPeek();
                        System.out.printf("头部数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("运行异常，程序已退出，请重新启动程序");
                    loop = false;
                    break;
            }
        }
        System.out.println("程序结束");
    }
}


/**
 * 使用数组模拟队列 - 编写一个CircleArray类
 * <p>
 * 尾部插入，头部取出
 */
class CircleArray {

    /**
     * 数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头部指针 - 初始为0
     * <p>
     * 指向第一个数据
     */
    private int front;

    /**
     * 队列尾部指针 - 初始为0
     * <p>
     * 指向最后一个数据的后一个位置
     */
    private int rear;

    /**
     * 队列数据
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     *
     * @param arrMaxSize 队列的最大容量
     */
    public CircleArray(int arrMaxSize) {
        // 给尾部指针留一个约定空间
        maxSize = arrMaxSize + 1;

        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否满了
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n) {
        // 判断队列是否满了
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }

        // 添加数据到当前位置
        arr[rear] = n;

        // 尾部指针后移
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出数据
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        // 取出数据
        int value = arr[front];

        // 头部指针后移
        front = (front + 1) % maxSize;

        // 返回结果
        return value;
    }

    /**
     * <p>显示队列所有数据
     * <p>思路：
     * <p>正常遍历，是从第一个位置到结束的位置，那么我们一般是从0开始，遍历有效数据数量就可以了。
     * <p>首先我们就要先获得有效数据的个数，那么他的公式为：(尾部指针 + 队列最大容量 - 头部指针) % 队列最大容量
     * <p>我们从头部指针开始遍历，那么只要有效数据个数 + 上我们的头部指针本身的数值，那么也就意味着，我们抹平了一些中间动态变化的未知数，让它等同于从0开始到最大值结束
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 当前队列的有效数据个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头部数据
     */
    public int headPeek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        return arr[front];
    }
}