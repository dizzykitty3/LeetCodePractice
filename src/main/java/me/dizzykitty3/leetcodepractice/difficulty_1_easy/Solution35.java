package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 35. Search Insert Position
// Easy
// #Array #BinarySearch
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        final int length = nums.length;
        if (length == 0) return 0;

        for (int i = 0; i < length; i++) {
            final int num = nums[i];
            if (target > num && i == length - 1) {
                return length;
            } else if (target == num) {
                return i;
            } else if (target < num) {
                return i;
            }
        }
        return -1; // no cases maybe
    }

    @Test
    void testSearchInsert() {
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 2), 1);
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 5), 2);
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 7), 4);
        assertEquals(searchInsert(new int[]{}, 7), 0);
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 0), 0);
    }
}
