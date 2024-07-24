package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 20. Valid Parentheses
public class Solution20 {
    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.length() % 2 != 0) return false;

        final var stack = new Stack<Character>();
        for (var i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(currentChar);
            } else {
                final Character topChar = stack.peek();
                if (matching(currentChar, topChar)) {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean matching(char currentChar, char topChar) {
        return (currentChar == ')' && Objects.equals(topChar, '('))
                || (currentChar == ']' && Objects.equals(topChar, '['))
                || (currentChar == '}' && Objects.equals(topChar, '{'));
    }

    @Test
    void testIsValid() {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertTrue(isValid("[]"));
        assertTrue(isValid("{}"));
        assertTrue(isValid("{[()]}"));
        assertFalse(isValid("{[(()]}"));
    }
}
