package cn.yiidii.study.algorithms.sort.exec;

import java.util.Arrays;

/**
 * exercise
 *
 * @author ed w
 * @since 1.0
 */
public class SortExercise {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 1};
//        selectSort(arr);
//        bubbleSort(arr);
//        bubbleSortV2(arr);
//        insertionSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        // i < arr.length - 1 的原因是最后一个不用比较
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 升序排序，发现比arr[index]小的，重置index
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {

        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void bubbleSortV2(int[] arr) {

        int temp;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (flag) {
                // 有序了，就break
                break;
            }
        }
    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insert = arr[i];
            int index = i - 1;
            while (index >= 0 && insert < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            // 退出循环，找到，插入
            arr[index + 1] = insert;
        }
    }

    public static void quickSort(int[] arr) {
        doQuickSort(arr, 0, arr.length - 1);
    }

    private static void doQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = arr[left];
        int i = left, j = right;
        while (i != j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        doQuickSort(arr, left, i - 1);
        doQuickSort(arr, i + 1, right);
    }

}
