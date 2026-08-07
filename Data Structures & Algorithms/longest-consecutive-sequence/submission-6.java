class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int maxLength=1;
                while(set.contains(num+maxLength)){
                    maxLength++;
                }
                res=Math.max(res,maxLength);
            }
        }
        return res;
    }
}
