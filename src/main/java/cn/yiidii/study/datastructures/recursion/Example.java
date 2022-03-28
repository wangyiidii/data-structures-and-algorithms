package cn.yiidii.study.datastructures.recursion;

/**
 * 例子
 *
 * @author ed w
 * @since 1.0
 */
public class Example {

    public static void main(String[] args) {
        print(3);

        System.out.println("----------");

        System.out.println(factorial(3));
    }

    /**
     * 递归打印
     *
     * @param n
     */
    public static void print(int n) {
        System.out.println(n);
        if (--n > 0) {
            print(n);
        }
    }

    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
