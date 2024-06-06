package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 20. Valid Parentheses
// Easy
// #String #Stack
public class Solution20 {
    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.length() % 2 != 0) return false;

        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(currentChar);
            } else {
                final Character topChar = stack.peek();
                if ((currentChar == ')' && Objects.equals(topChar, '('))
                        || (currentChar == ']' && Objects.equals(topChar, '['))
                        || (currentChar == '}' && Objects.equals(topChar, '{'))) {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }
        return stack.isEmpty();
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
