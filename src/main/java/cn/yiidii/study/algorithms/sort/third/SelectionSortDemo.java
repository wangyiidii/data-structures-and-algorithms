package cn.yiidii.study.algorithms.sort.third;

/**
 * 选择排序
 *
 * @author ed w
 * @since 1.0
 */
public class SelectionSortDemo {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    // 修改最小值索引
                    index = j;
                }
            }

            if (index != i) {
                // 如果匹配到了，就交换
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }

        // 打印
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
