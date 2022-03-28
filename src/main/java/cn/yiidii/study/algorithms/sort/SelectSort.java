package cn.yiidii.study.algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author ed w
 * @since 1.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
//        sortProcess(arr);
        selectSort(arr);
    }

    /**
     * 过程
     *
     * @param arr
     */
    public static void sortProcess(int[] arr) {
        int minIndex = 0;
        int min = arr[0];

        // 第1轮
        for (int i = 0 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        // 交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第1轮: " + Arrays.toString(arr));

        // 第2轮
        minIndex = 1;
        min = arr[1];
        for (int i = 1 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        // 交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第2轮: " + Arrays.toString(arr));
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];

            // 第1轮
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮: " + Arrays.toString(arr));
        }
    }
}
