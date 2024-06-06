package me.dizzykitty3.leetcodepractice.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// Easy
// #Array #HashTable
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;

        for (int i = 0; i < length; i++) {
            final int gap = target - nums[i]; // avoid doing extensive addition operations
            for (int j = i + 1; j < length; j++) { // j starts with i + 1
                if (nums[j] == gap) return new int[]{i, j}; // return the answer
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
