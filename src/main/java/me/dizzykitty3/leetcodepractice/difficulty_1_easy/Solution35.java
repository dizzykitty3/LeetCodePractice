package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 35. Search Insert Position
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        final var length = nums.length;
        if (length == 0) return 0;

        for (var i = 0; i < length; i++) {
            final var num = nums[i];
            if (target > num && i == length - 1) {
                return length;
            } else if (target == num || target < num) {
                return i;
            }
        }
        return -1; // no cases maybe
    }

    @Test
    void testSearchInsert() {
        assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(0, searchInsert(new int[]{}, 7));
        assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}