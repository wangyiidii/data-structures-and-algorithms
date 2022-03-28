package cn.yiidii.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 例： 输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4 解释: 9 出现在 nums 中并且下标为 4
 *
 * @author ed w
 * @since 1.0
 */
public class LeetCode01 {

    public static void main(String[] args) {
        LeetCode01 leetCode01 = new LeetCode01();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = leetCode01.search(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
