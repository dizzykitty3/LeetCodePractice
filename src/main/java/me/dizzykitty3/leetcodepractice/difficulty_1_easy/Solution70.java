package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 70 Climbing Stairs
 */
public class Solution70 {
    public int climbStairs(int n) {
        // TODO
//        var k = n / 2;
//        if (isOddNumber(n)) {
//            // 1 + C(k + (k - 1 + 1), (k - (k - 1))) + ... + C((k + 2), (k - 1)) + C((k + 1), k)
//        } else {
//            // 1 + C((k + (k - 1)), (k - (k - 1))) + ... + C((k + 2), (k - 2)) + C((k + 1), (k - 1)) + 1
//        }
//        return _;
        return switch (n) {
            case 1 -> 1;
            case 2 -> 2;
            default -> climbStairs(n - 2) + climbStairs(n - 1);
        };
    }

    private boolean isOddNumber(int num) {
        return Math.abs(num) % 2 == 1;
    }

    @Test
    void testClimbStairs() {
        // 1
        assertEquals(1, climbStairs(1));
        // 11
        // 2
        assertEquals(2, climbStairs(2));
        // 111
        // 21, 12
        assertEquals(3, climbStairs(3));
        // 1111
        // 211, 121, 112
        // 22
        assertEquals(5, climbStairs(4));
        // 11111
        // 2111, 1211, 1121, 1112
        // 221, 212, 122
        assertEquals(8, climbStairs(5));
        // 111111
        // 21111, 12111, 11211, 11121, 11112
        // 2211, 2121, 2112, 1221, 1212, 1122
        // 222
        assertEquals(13, climbStairs(6));
        // 1111111
        // 211111, 121111, 112111, 111211, 111121, 111112
        // 22111, 21211, 21121, 21112, 12211, 12121, 12112, 11221, 11212, 11122
        // 2221, 2122, 2212, 1222
        assertEquals(21, climbStairs(7));
    }
}