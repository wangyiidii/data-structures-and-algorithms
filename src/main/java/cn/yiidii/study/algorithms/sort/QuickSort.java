package cn.yiidii.study.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author ed w
 * @since 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * https://blog.csdn.net/shujuelin/article/details/82423852
     *
     * @param array
     * @param left
     * @param right
     * @return void
     * @author ed w
     * @date 2022/3/28
     */
    public static void quickSort(int[] array, int left, int right) {

        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i >= j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                break;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

//    public static void quickSort(int[] arr, int left, int right) {
//        int l = left;
//        int r = right;
//        // 临时变量，交换时使用
//        int temp = 0;
//        // pivot 中轴值
//        int pivot = arr[(left + right) / 2];
//        // while循环的目的是，让pivot值小的放再左边，反之放右边
//        while (l < r) {
//            // 在pivot的左边一直找，找到大于等于pivot的值，才退出
//            while (arr[l] < pivot) {
//                l += 1;
//            }
//            // 在pivot的右边边一直找，找到大于等于pivot的值，才退出
//            while (arr[r] > pivot) {
//                r -= 1;
//            }
//
//            /*
//             * 如果l >= r，说明pivot的左右两边的值已经按照
//             * 左边全部小于pivot值，右边全都大于pivot的值
//             */
//            if (l >= r) {
//                break;
//            }
//            // 交换
//            temp = arr[l];
//            arr[l] = arr[r];
//            arr[r] = temp;
//
//            // 如果交换完成之后，发现arr[l] == pivot的值相等，r--，前移
//            if (arr[l] == pivot) {
//                r -= 1;
//            }
//
//            // 如果交换完成之后，发现arr[r] == pivot的值相等，l++，后移
//            if (arr[r] == pivot) {
//                l += 1;
//            }
//            // 如果l == r, 比如l++, r--, 否则栈溢出
//            if (l == r) {
//                l += 1;
//                r -= 1;
//            }
//            // 向左递归
//            if (left < r) {
//                quickSort(arr, left, r);
//            }
//
//            // 向右递归
//            if (right > l) {
//                quickSort(arr, l, right);
//            }
//
//        }
//    }

}
