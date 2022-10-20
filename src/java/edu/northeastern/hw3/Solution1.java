package java.edu.northeastern.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum (https://leetcode.com/problems/combination-sum/)
 */
public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        dfs(candidates, target, 0, result, results);
        return results;
    }

    private void dfs(int[] integer_array, int target_sum, int start,
                     List<Integer> combination, List<List<Integer>> combinations) {
        if (target_sum == 0) {
            List<Integer> combination_copy = new ArrayList<>();
            combination_copy.addAll(combination);
            combinations.add(combination_copy);
            return;
        }
        for (int i = start; i < integer_array.length; i++) {
            if (target_sum < integer_array[i]) {
                return;
            }
            combination.add(integer_array[i]);
            dfs(integer_array, target_sum - integer_array[i], i, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}
