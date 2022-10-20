package java.edu.northeastern.hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers With Same Consecutive Differences (https://leetcode.com/problems/numbers-with-same-consecutive-differences/)
 */
public class Solution5 {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();
        if(N==0)
            return new int[0];
        if(N==1)
            list.add(0);
        dfs(N, K, list, 0);
        return list.stream().mapToInt(i->i).toArray();
    }

    private void dfs(int N, int K, List<Integer> list, int number){
        if(N == 0){
            list.add(number);
            return ;
        }
        for(int i=0; i<10; ++i){
            if(i==0 && number ==0)
                continue;
            else if(number == 0 && i!=0){
                dfs(N-1, K, list, i);
            }
            else{
                if(Math.abs((number%10) - i )==K){
                    dfs(N-1, K, list, number*10+i);
                }
            }
        }
    }
}
