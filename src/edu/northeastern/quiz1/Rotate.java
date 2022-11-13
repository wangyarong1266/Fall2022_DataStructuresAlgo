package edu.northeastern.quiz1;

class Rotate {
    public static void main(String[] args) {
        
        Rotate h = new Rotate();
        int[] result = h.rotate(new int[]{1, 3, 4, 8}, 10);
        
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
    
    public int[] rotate(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        n = n % nums.length;
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < n; i++) {
            result[i] = nums[nums.length - n + i];
        }
        
        for (int i = n; i < nums.length; i++) {
            result[i] = nums[i - n];
        }
        
        return result;
    }
}
