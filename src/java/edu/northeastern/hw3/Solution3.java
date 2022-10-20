package java.edu.northeastern.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
 */
public class Solution3 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> digit_to_letters = new HashMap<>();
        digit_to_letters.put('2', "abc");
        digit_to_letters.put('3', "def");
        digit_to_letters.put('4', "ghi");
        digit_to_letters.put('5', "jkl");
        digit_to_letters.put('6', "mno");
        digit_to_letters.put('7', "pqrs");
        digit_to_letters.put('8', "tuv");
        digit_to_letters.put('9', "wxyz");
        List<String> results = new ArrayList<>();
        String result = "";
        dfs(digit_to_letters, digits, 0, result, results);
        return results;
    }

    private void dfs(Map<Character, String> digit_to_letters, String number, int index, String combination, List<String> combinations) {
        if (index == number.length()) {
            combinations.add(combination);
            return;
        }
        String letters = digit_to_letters.get(number.charAt(index));
        int number_of_letters = letters.length();
        for (int i = 0; i < number_of_letters; i++) {
            Character letter = letters.charAt(i);
            dfs(digit_to_letters, number, index + 1, combination + letter, combinations);
        }
    }
}
