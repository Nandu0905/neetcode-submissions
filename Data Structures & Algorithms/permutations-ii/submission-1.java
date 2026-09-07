class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(0,nums,used,current,result);
        return new ArrayList<>(result);
    }
    private void backTrack(int index,int[] nums,boolean[] used,List<Integer> current,List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 &&(nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            if(used[i]){
                continue;
            }
            used[i]=true;
            current.add(nums[i]);
            backTrack(index,nums,used,current,result);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
}