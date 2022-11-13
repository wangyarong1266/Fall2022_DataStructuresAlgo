package edu.northeastern.midterm.question5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 5, 5, 5, 8, 9, 10, 11};
        int[] values = {1, 4, 5, 10};

        int[] ans = getStartOfEachValues(arr, values);

        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 12, 17]

    /**
     * The time complexity is O(N). N is the length of input array arr.
     */
    private static int[] getStartOfEachValues(int[] arr, int[] values) {
        int[] indexes = new int[values.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], i);
        }

        for (int i = 0; i < values.length; i++) {
            indexes[i] = map.getOrDefault(values[i], -1);
        }

        return indexes;
    }
}
