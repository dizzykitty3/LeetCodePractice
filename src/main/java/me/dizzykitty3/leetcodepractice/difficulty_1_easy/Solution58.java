package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 58 Length of Last Word
 * <li>String</li>
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if ("".equals(s)) return 0;

        final var trimmedString = s.trim();
        if (!trimmedString.contains(" ")) return trimmedString.length();

        final var lastIndex = trimmedString.lastIndexOf(" ");
        final var lastWord = trimmedString.substring(lastIndex + 1);
        return lastWord.length();
    }

    @Test
    void testLengthOfLastWord() {
        assertEquals(5, lengthOfLastWord("Hello World"));
        assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
        assertEquals(0, lengthOfLastWord(""));
        assertEquals(8, lengthOfLastWord("leetcode practice"));
        assertEquals(4, lengthOfLastWord("solution test java"));
        assertEquals(4, lengthOfLastWord(" java"));
        assertEquals(4, lengthOfLastWord("                         java"));
        assertEquals(4, lengthOfLastWord("                         java          "));
    }
}