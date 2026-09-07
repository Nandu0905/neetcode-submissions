class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList();
        backTrack(0,nums,used,current,res);
        return res;
    }
    private void backTrack(int index,int[] nums,boolean[] used,List<Integer> current,List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true){
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
