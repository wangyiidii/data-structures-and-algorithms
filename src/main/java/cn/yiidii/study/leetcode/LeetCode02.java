package cn.yiidii.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * @author ed w
 * @since 1.0
 */
public class LeetCode02 {

    public static void main(String[] args) {
        LeetCode02 leetCode02 = new LeetCode02();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = leetCode02.addTwoNumbers(l1, l2);
        System.out.println(result);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 头节点，啥也没有，最后输出root.next
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        // 进位
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int sum = l1Value + l2Value + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            cursor.next = temp;
            cursor = temp;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return root.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            List<Integer> result = new ArrayList<>();
            ListNode cursor = this;
            while (cursor != null && cursor != null) {
                result.add(cursor.val);
                cursor = cursor.next;
            }
            return result.toString();
        }
    }
}
