class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0,nums,current,result);
        return result;
    }
    private void backTrack(int index,int[] nums,List<Integer> current, List<List<Integer>> res){
        if(index==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backTrack(index+1,nums,current,res);
        current.remove(current.size()-1);
        backTrack(index+1,nums,current,res);
    }
}
