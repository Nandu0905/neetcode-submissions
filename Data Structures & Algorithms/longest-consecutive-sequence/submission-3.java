class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res=0;
        for(int num : nums){
            set.add(num);
        }
        for(int num:set){
            int maxCount=0;int current=num;
            while(set.contains(current)){
                maxCount++;
                current++;
            }
            res = Math.max(res,maxCount);
        }
    return res;

    }
}

