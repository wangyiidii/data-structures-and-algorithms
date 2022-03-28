package cn.yiidii.study.datastructures.recursion;

/**
 * 八皇后问题
 *
 * @author ed w
 * @since 1.0
 */
public class Queen8 {

    int max = 8;
    int[] array = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共%d种解法\n\n", queen8.count);
    }

    /**
     * 放置弟n个皇后
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) {
            // 8个皇后已经放好了
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前皇后放到该行的第一列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                // 不冲突
                check(n + 1);
            }
            // 冲突就往后的列放
        }
    }

    /**
     * 判断是否冲突
     *
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            /*
                array[i] == array[n]        说明在同一列
                Math.abs(n - i) == Math.abs(array[n] - array[i]    是否在同一斜线
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     */
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        count++;
    }
}
