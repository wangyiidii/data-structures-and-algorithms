package cn.yiidii.study.leetcode;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author ed w
 * @since 1.0
 */
public class LeetCode0005 {

    public static void main(String[] args) {
        LeetCode0005 leetCode0005 = new LeetCode0005();
        String s = leetCode0005.longestPalindrome("cbbd");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 1; i < s.length() - 2; i++) {
            int j = i, k = i;
            do {
                j--;
                k++;
            } while (j >= 0 && k <= s.length() - 1 && s.charAt(j) == s.charAt(k));
            if (i != j) {
                String temp = s.substring(i - 1, k);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
        }
        return result;
    }
}
