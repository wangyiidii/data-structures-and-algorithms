package cn.yiidii.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author ed w
 * @since 1.0
 */
public class LeetCode0003 {

    public static void main(String[] args) {
        LeetCode0003 leetCode0003 = new LeetCode0003();

        int len = leetCode0003.lengthOfLongestSubstring("abba");
        System.out.println(len);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        // max: 返回最大长度
        int max = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                /*
                    包含了，设置左窗口为 map.get(s.charAt(right)) + 1
                    这里用Math.max(left, map.get(s.charAt(right)) + 1)的原因是：避免这种abcdae ,当遍历到第2个a的时候，回把left重置为0的情况
                 */
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            // 取最大值防止区间左端点回退情况
            // 长度为窗口的宽度
            max = Math.max(max, right - left + 1);
            // 注意，更新字符对应的下标。
            map.put(s.charAt(right), right);
        }
        return max;
    }

}
