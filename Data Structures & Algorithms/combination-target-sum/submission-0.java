class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int remaining = target;
        backTrack(remaining, target, 0, nums, current, result);
        return result;
    }
    private void backTrack(int remaining, int target, int index, int[] nums, List<Integer> current,
        List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0 || index == nums.length) {
            return;
        }
        current.add(nums[index]);
        backTrack(remaining-nums[index],target,index,nums,current,result);
        current.remove(current.size() - 1);
        backTrack(remaining,target,index+1,nums,current,result);
    }
}
