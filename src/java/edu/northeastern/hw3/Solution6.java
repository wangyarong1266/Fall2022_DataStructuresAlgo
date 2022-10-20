package java.edu.northeastern.hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets (https://leetcode.com/problems/subsets/)
 */
public class Solution6 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(nums, 0, subset, subsets);
        return subsets;
    }

    private void dfs(int[] integer_array, int start,
                     List<Integer> combination, List<List<Integer>> combinations) {
        List<Integer> combination_copy = new ArrayList<>();
        combination_copy.addAll(combination);
        combinations.add(combination_copy);

        for (int i = start; i < integer_array.length; i++) {
            combination.add(integer_array[i]);
            dfs(integer_array, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}
