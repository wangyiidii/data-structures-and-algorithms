package cn.yiidii.study.algorithms.sort;

import java.util.Arrays;

/**
 * ShellSort
 *
 * @author ed w
 * @since 1.0
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        sortProcess(arr);
//        shellSort(arr);
        shellSortV2(arr);
    }

    public static void sortProcess(int[] arr) {
        // 第1轮
        // 第1轮，将10个数据分为5组
        int temp;
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中的所有元素（共5组，每组有2个元素），步长为5
            for (int j = i - 5; j >= 0; j -= 5) {
                // 如果当前元素
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第1轮结果: " + Arrays.toString(arr));

        // 第2轮
        // 第2轮，将10个数据分为5/2=2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中的所有元素（共5组，每组有2个元素），步长为5
            for (int j = i - 2; j >= 0; j -= 2) {
                // 如果当前元素
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第2轮结果: " + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中的所有元素（共gap组，每组有个元素），步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + (++count) + "轮: " + Arrays.toString(arr));
        }
    }

    /**
     * 位移法
     *
     * @param arr
     * @return void
     * @author ed w
     * @date 2022/3/28
     */
    public static void shellSortV2(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出while循环之后，就给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("移位法，第" + (++count) + "轮: " + Arrays.toString(arr));

        }
    }
}
