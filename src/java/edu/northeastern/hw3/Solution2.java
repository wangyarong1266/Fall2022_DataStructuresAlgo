package java.edu.northeastern.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations (https://leetcode.com/problems/permutations/)
 */
public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        Boolean[] visited = new Boolean[nums.length];
        Arrays.fill(visited, Boolean.FALSE);
        dfs(nums, visited, result, results);
        return results;
    }

    private void dfs(int[] integer_array, Boolean[] visited,
                     List<Integer> permutation, List<List<Integer>> permutations) {
        if (integer_array.length == permutation.size()) {
            List<Integer> permutation_copy = new ArrayList<>();
            permutation_copy.addAll(permutation);
            permutations.add(permutation_copy);
            return;
        }
        for (int i = 0; i < integer_array.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            permutation.add(integer_array[i]);
            dfs(integer_array, visited, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
