package me.dizzykitty3.leetcodepractice.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// TODO
// Hard
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int length1 = nums1.length;
        final int length2 = nums2.length;
        if (length1 == 0) return findMedianSortedArray(nums2);
        if (length2 == 0) return findMedianSortedArray(nums1);
        if (length1 == 1 && length2 == 1) return (nums1[0] + nums2[0]) * 0.5D;

        final int totalLength = length1 + length2;
        final boolean isOdd = isOddNumber(totalLength);
        final int resultIndex = totalLength / 2 + 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length1; i++) {
            // TODO
        }
        return 0D; // TODO
    }

    private boolean isOddNumber(int num) {
        return Math.abs(num) % 2 == 1;
    }

    private double findMedianSortedArray(int[] nums) {
        final int length = nums.length;
        if (length == 0) return 0D;
        if (length == 1) return nums[0];
        final int resultIndex = length / 2 + 1;
        return isOddNumber(length) ? nums[resultIndex] : (nums[resultIndex - 1] + nums[resultIndex]) * 0.5D;
    }

    @Test
    void testFindMedianSortedArrays() {
        assertEquals(findMedianSortedArrays(new int[]{1}, new int[]{1}), 1D);
        assertEquals(findMedianSortedArrays(new int[]{0}, new int[]{0}), 0D);
        assertEquals(findMedianSortedArrays(new int[]{-1}, new int[]{-1}), -1D);
        assertEquals(findMedianSortedArrays(new int[]{-1}, new int[]{1}), 0D);
        assertEquals(findMedianSortedArrays(new int[]{1}, new int[]{3}), 2D);
        assertEquals(findMedianSortedArrays(new int[]{1}, new int[]{2}), 1.5D);
        assertEquals(findMedianSortedArrays(new int[]{}, new int[]{2}), 2D);
        assertEquals(findMedianSortedArrays(new int[]{}, new int[]{-1}), -1D);
        assertEquals(findMedianSortedArrays(new int[]{2}, new int[]{}), 2D);
        assertEquals(findMedianSortedArrays(new int[]{-1}, new int[]{}), -1D);
    }

    @Test
    void testIsOddNumber() {
        assertTrue(isOddNumber(1));
        assertTrue(isOddNumber(3));
        assertTrue(isOddNumber(-1));
        assertTrue(isOddNumber(5));
        assertFalse(isOddNumber(2));
        assertFalse(isOddNumber(4));
        assertFalse(isOddNumber(0));
        assertFalse(isOddNumber(-2));
        assertFalse(isOddNumber(200_000));
        assertFalse(isOddNumber(123_456));
    }
}
