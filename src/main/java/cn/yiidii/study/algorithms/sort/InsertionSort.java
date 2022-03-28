package cn.yiidii.study.algorithms.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author ed w
 * @since 1.0
 */
public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
//        sortProcess(arr);
        insertionSort(arr);
    }

    public static void sortProcess(int[] arr) {
        // 第1轮
        // 待插入的数
        int insertValue = arr[0 + 1];
        // 待插入数的索引
        int insertIndex = 1 - 1;

        /*
            给insertValue找到插入的位置
            insertIndex > 0: 保证找插入数据不越界
            insertValue< arr[insertIndex]: 还没有找到要插入的位置
         */
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            // 后移
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while循环，说明插入的位置找到， insertIndex + 1
        arr[insertIndex + 1] = insertValue;
        System.out.println("第1轮:" + Arrays.toString(arr));

        // 第2轮
        insertValue = arr[1 + 1];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第2轮:" + Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环，说明插入的位置找到， insertIndex + 1
            arr[insertIndex + 1] = insertValue;
            System.out.println("第" + (i + 1) + "轮:" + Arrays.toString(arr));

        }
    }
}
