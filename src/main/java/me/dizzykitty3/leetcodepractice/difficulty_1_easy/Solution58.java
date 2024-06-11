package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 58. Length of Last Word
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if ("".equals(s)) return 0;

        final String trimmedString = s.trim();
        if (!trimmedString.contains(" ")) return trimmedString.length();

        final int lastIndex = trimmedString.lastIndexOf(" ");
        final String lastWord = trimmedString.substring(lastIndex + 1);
        return lastWord.length();
    }

    @Test
    void testLengthOfLastWord() {
        assertEquals(lengthOfLastWord("Hello World"), 5);
        assertEquals(lengthOfLastWord("   fly me   to   the moon  "), 4);
        assertEquals(lengthOfLastWord("luffy is still joyboy"), 6);
        assertEquals(lengthOfLastWord(""), 0);
        assertEquals(lengthOfLastWord("leetcode practice"), 8);
        assertEquals(lengthOfLastWord("solution test java"), 4);
        assertEquals(lengthOfLastWord(" java"), 4);
        assertEquals(lengthOfLastWord("                         java"), 4);
        assertEquals(lengthOfLastWord("                         java          "), 4);
    }
}
