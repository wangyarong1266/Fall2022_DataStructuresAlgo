package edu.northeastern.hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses (https://leetcode.com/problems/generate-parentheses/)
 */
public class Solution7 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        process("", n, n, result);
        return result;
    }

    private void process(String prefix, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(prefix);
            return;
        }
        if (left > 0) {
            process(prefix + '(', left - 1, right, result);
        }
        if (left < right) {
            process(prefix + ')', left, right - 1, result);
        }
    }
}
