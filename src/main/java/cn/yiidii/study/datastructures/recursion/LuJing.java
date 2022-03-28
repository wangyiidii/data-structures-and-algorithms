package cn.yiidii.study.datastructures.recursion;

/**
 * 不同路径
 * <p>
 * leetcode 62 https://leetcode-cn.com/problems/unique-paths
 *
 * <p>一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 *
 * @author ed w
 * @since 1.0
 */
public class LuJing {

    public static void main(String[] args) {
        int i = uniquePaths(1, 1, 3, 2);
        System.out.println(i);
    }

    public static int uniquePaths(int i, int j, int m, int n) {
        if (i == m && j == n) {
            return 1;
        }
        if (i > m || j > n) {
            return 0;

        }
        return uniquePaths(i + 1, j, m, n) + uniquePaths(i, j + 1, m, n);
    }
}
