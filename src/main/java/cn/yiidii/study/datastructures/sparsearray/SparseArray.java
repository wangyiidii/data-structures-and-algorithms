package cn.yiidii.study.datastructures.sparsearray;

/**
 * 稀疏数组
 *
 * @author ed w
 * @since 1.0
 */
public class SparseArray {

    public static void main(String[] args) {
        // 定义
        int[][] chessarr1 = new int[11][11];
        chessarr1[1][2] = 1;
        chessarr1[2][3] = 2;
        for (int[] row : chessarr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int count = 0;
        for (int[] row : chessarr1) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }
        }

        int[][] statistic = new int[count + 1][3];
        statistic[0][0] = 11;
        int pointer = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessarr1[i][j] != 0) {
                    pointer++;
                    statistic[pointer][0] = i;
                    statistic[pointer][1] = j;
                    statistic[pointer][2] = chessarr1[i][j];
                }
            }
        }

        for (int[] row : statistic) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }


}
