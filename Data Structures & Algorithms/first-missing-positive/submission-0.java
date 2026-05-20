class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(num>=0) set.add(num);
        }
        int current = 1;
         while(set.contains(current)){
            current++;
        }
        return current;

        
    }
}