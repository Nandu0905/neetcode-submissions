class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,current,res);
        return res;
    }
    private void backTrack(int index,int[] nums,List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            backTrack(i+1,nums,current,result);
            current.remove(current.size()-1);
        }
    }
}
