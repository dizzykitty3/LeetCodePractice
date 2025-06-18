package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 1. Two Sum
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        final var length = nums.length;

        for (var i = 0; i < length; i++) {
            final var gap = target - nums[i]; // avoid doing extensive addition operations
            for (var j = i + 1; j < length; j++) { // j starts with i + 1
                if (nums[j] == gap) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1}; // return [-1, -1] if there is no answer
    }

    @Test
    void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{-1, -1}, twoSum(new int[]{3, 4}, 6));
        assertArrayEquals(new int[]{2, 3}, twoSum(new int[]{1, 2, 3, 4}, 7));
    }
}