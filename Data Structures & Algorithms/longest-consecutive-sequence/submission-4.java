class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res=0;
        for(int num : nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int maxCount=1;
                while(set.contains(num+ maxCount)){
                maxCount++;
            }
            res = Math.max(res,maxCount);
            }  
        }
        return res;
    }
}

