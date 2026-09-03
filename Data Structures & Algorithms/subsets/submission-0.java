class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int mask=0;mask<(1<<n);mask++){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((mask&(1<<i))!=0){
                    list.add(nums[i]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
