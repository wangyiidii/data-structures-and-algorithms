package cn.yiidii.study.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序 O(n^2)
 *
 * @author ed w
 * @since 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
//        sortProcess(arr);
//        bubbleSort(arr);
        bubbleSortV2(arr);
    }

    /**
     * 过程
     *
     * @param arr
     */
    public static void sortProcess(int[] arr) {

        // 第一趟排序，最大的放再最后
        // 临时变量
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第一趟结果：");
        System.out.println(Arrays.toString(arr));

        // 第二趟排序，倒数第二大的放再最后
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二趟结果：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 冒泡排序的时间复杂度为 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序（优化）
     *
     * @param arr
     */
    public static void bubbleSortV2(int[] arr) {
        // 冒泡排序的时间复杂度为 O(n^2)
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.printf("第%d趟排序后的数组: %s\n", i + 1, Arrays.toString(arr));

            if (!flag) {
                // 在一趟排序中，一次排序都没有发生过
                break;
            } else {
                // 重置flag
                flag = false;
            }
        }
    }
}
