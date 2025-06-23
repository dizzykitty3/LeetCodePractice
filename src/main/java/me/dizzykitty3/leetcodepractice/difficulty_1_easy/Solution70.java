package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 70 Climbing Stairs
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        var k = n / 2;
        int result;
        if (isOddNumber(n)) {
            // 3 -> k = 1
            //      111
            //      21, 12
            // 5 -> k = 2
            //      11111
            //      2111, 1211, 1121, 1112
            //      221, 212, 122
            // 7 -> k = 3
            //      1111111
            //      211111, 121111, 112111, 111211, 111121, 111112
            //      22111, 21211, 21121, 21112, 12211, 12121, 12112, 11221, 11212, 11122
            //      2221, 2122, 2212, 1222

            // 1 + C(k + (k - 1) + 1, k - (k - 1)) + ... + C(k + 1 + 1, k - 1) + C(k + 1, k)
            // 1 + for (int i = k - 1; i >= 0; i--) { C(k + i + 1, k - i) }

            result = 1;
            for (var i = k - 1; i >= 0; i--) {
                result += combination(k + i + 1, k - i);
            }
        } else {
            // 4 -> k = 2
            //      1111
            //      211, 121, 112
            //      22
            // 6 -> k = 3
            //      111111
            //      21111, 12111, 11211, 11121, 11112
            //      2211, 2121, 2112, 1221, 1212, 1122
            //      222

            // 1 + C(k + (k - 1), k - (k - 1)) + ... + C(k + 2, k - 2) + C(k + 1, k - 1) + 1
            // 2 + for (int i = k - 1; i >= 1; i--) { C(k + i, k - i) }

            result = 2;
            for (var i = k - 1; i >= 1; i--) {
                result += combination(k + i, k - i);
            }
        }
        return result;
    }

    private boolean isOddNumber(int num) {
        return Math.abs(num) % 2 == 1;
    }

    private int factorial(int num) {
        var result = 1;
        for (var i = 2; i < num + 1; i++) {
            result *= i;
        }
        return result;
    }

    private int combination(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    @Test
    void testFactorial() {
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
        assertEquals(720, factorial(6));
    }

    @Test
    void testCombination() {
        assertEquals(6, combination(4, 2));
        assertEquals(10, combination(5, 2));
        assertEquals(1, combination(1, 1));
        assertEquals(2, combination(2, 1));
        assertEquals(1, combination(2, 2));
        assertEquals(10, combination(5, 3));
        assertEquals(15, combination(6, 2));
    }

    @Test
    void testClimbStairs() {
        assertEquals(1, climbStairs(1));
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