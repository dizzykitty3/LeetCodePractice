package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 9. Palindrome Number
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int temp = x;
        int reversed = 0;

        while (temp > 9) {
            reversed = (reversed + (temp % 10)) * 10;
            temp = temp / 10;
        }
        reversed += temp;
        return reversed == x;
    }

    @Test
    void testIsPalindrome() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(10));
        assertTrue(isPalindrome(12321));
        assertTrue(isPalindrome(969));
        assertFalse(isPalindrome(123));
        assertFalse(isPalindrome(12334));
        assertFalse(isPalindrome(331));
        assertTrue(isPalindrome(666));
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(123454321));
        assertFalse(isPalindrome(1234543210));
    }
}
