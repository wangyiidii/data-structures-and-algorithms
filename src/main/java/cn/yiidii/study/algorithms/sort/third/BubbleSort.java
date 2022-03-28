package cn.yiidii.study.algorithms.sort.third;

/**
 * 冒泡排序
 *
 * @author ed w
 * @since 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        // 外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        // 打印
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
