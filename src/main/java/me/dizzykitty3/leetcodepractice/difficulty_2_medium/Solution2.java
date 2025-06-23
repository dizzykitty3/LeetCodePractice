package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import me.dizzykitty3.leetcodepractice.ListNode;
import org.junit.jupiter.api.Test;

import static me.dizzykitty3.leetcodepractice.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 2 Add Two Numbers
 * <li>Linked List</li>
 * <li>Math</li>
 * <li>Recursion</li>
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        var needPlusOne = false;
        if (l1.val + l2.val >= 10) {
            result = new ListNode(l1.val + l2.val - 10);
            needPlusOne = true;
        } else {
            result = new ListNode(l1.val + l2.val);
        }
        var temp = result;

        while (l1.next != null || l2.next != null) {
            if (l1.next != null && l2.next == null) {
                if (l1.next.val == 9 && needPlusOne) {
                    temp.next = new ListNode(0);
                } else if (needPlusOne) {
                    temp.next = new ListNode(l1.next.val + 1);
                    needPlusOne = false;
                } else {
                    temp.next = new ListNode(l1.next.val);
                }
                l1 = l1.next;
            } else if (l1.next == null) {
                if (l2.next.val == 9 && needPlusOne) {
                    temp.next = new ListNode(0);
                } else if (needPlusOne) {
                    temp.next = new ListNode(l2.next.val + 1);
                    needPlusOne = false;
                } else {
                    temp.next = new ListNode(l2.next.val);
                }
                l2 = l2.next;
            } else {
                if (l1.next.val + l2.next.val >= 9 && needPlusOne) {
                    temp.next = new ListNode(l1.next.val + l2.next.val + 1 - 10);
                } else if (l1.next.val + l2.next.val >= 10) {
                    temp.next = new ListNode(l1.next.val + l2.next.val - 10);
                    needPlusOne = true;
                } else if (needPlusOne) {
                    temp.next = new ListNode(l1.next.val + l2.next.val + 1);
                    needPlusOne = false;
                } else {
                    temp.next = new ListNode(l1.next.val + l2.next.val);
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (needPlusOne) {
            temp.next = new ListNode(1);
        }
        return result;
    }

    @Test
    void testToArray() {
        assertArrayEquals(new Object[]{1, 2, 3}, toArray(new ListNode(new int[]{1, 2, 3})));
        assertArrayEquals(new Object[]{4, 5, 6}, toArray(new ListNode(new int[]{4, 5, 6})));
        assertArrayEquals(new Object[]{4, 5, 6, 7}, toArray(new ListNode(new int[]{4, 5, 6, 7})));
        assertArrayEquals(new Object[]{0}, toArray(new ListNode(new int[]{0})));
    }

    @Test
    void testAddTwoNumbers() {
        assertArrayEquals(toArray(new ListNode(new int[]{7, 9, 7})), toArray(addTwoNumbers(new ListNode(new int[]{2, 3, 3}), new ListNode(new int[]{5, 6, 4}))));
        assertArrayEquals(toArray(new ListNode(new int[]{7, 0, 8})), toArray(addTwoNumbers(new ListNode(new int[]{2, 3, 3}), new ListNode(new int[]{5, 7, 4}))));
        assertArrayEquals(toArray(new ListNode(new int[]{7, 0, 8})), toArray(addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4}))));
        assertArrayEquals(toArray(new ListNode(new int[]{0})), toArray(addTwoNumbers(new ListNode(new int[]{0}), new ListNode(new int[]{0}))));
        assertArrayEquals(toArray(new ListNode(new int[]{0, 1})), toArray(addTwoNumbers(new ListNode(new int[]{4}), new ListNode(new int[]{6}))));
        assertArrayEquals(toArray(new ListNode(new int[]{0, 1, 0, 1})), toArray(addTwoNumbers(new ListNode(new int[]{1, 0, 1}), new ListNode(new int[]{9, 0, 9}))));
        assertArrayEquals(toArray(new ListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1})), toArray(addTwoNumbers(new ListNode(new int[]{9, 9, 9, 9, 9, 9, 9}), new ListNode(new int[]{9, 9, 9, 9}))));
        assertArrayEquals(toArray(new ListNode(new int[]{0, 1})), toArray(addTwoNumbers(new ListNode(new int[]{2}), new ListNode(new int[]{8}))));
        assertArrayEquals(toArray(new ListNode(new int[]{4, 5, 5, 1})), toArray(addTwoNumbers(new ListNode(new int[]{6, 6, 6}), new ListNode(new int[]{8, 8, 8}))));
    }
}