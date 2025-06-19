package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 2294 Partition Array Such That Maximum Difference Is K
 */
public class Solution2294 {
    public int partitionArray(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().toList();
        var result = 1;
        var tmp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - tmp > k) {
                result++;
                tmp = list.get(i);
            }
        }
        return result;
    }

    @Test
    void testPartitionArray() {
        assertEquals(2, partitionArray(new int[]{3, 6, 1, 2, 5}, 2));
        assertEquals(2, partitionArray(new int[]{1, 2, 3}, 1));
        assertEquals(3, partitionArray(new int[]{2, 2, 4, 5}, 0));
    }
}
