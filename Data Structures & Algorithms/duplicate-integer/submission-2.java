class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean flag=false;
        for(int num:nums){
            if(!set.add(num)){
                flag= true;
            }
        } 
        return flag;
    }
}