package edu.northeastern.finalexam.question1;

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        Anagram sol = new Anagram();
        List<String> strs = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> ans = sol.groupAnagrams(strs);

        for (List<String> ana : ans) {
            for (String i : ana) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /* The time complexity is O(N) and the N is the length of the input array. */
    public List<List<String>> groupAnagrams(List<String> strings) {
        Map<String, List<String>> map = new HashMap<>();

        if (strings == null || strings.size() == 0) {
            return new ArrayList<>();
        }

        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
