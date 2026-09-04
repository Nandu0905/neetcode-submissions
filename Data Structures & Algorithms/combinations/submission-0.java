class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] nums =new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        backTrack(0,nums,k,current,result);
        return result;
    }
    private void backTrack(int index,int[] nums,int k,List<Integer> current,List<List<Integer>> result){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backTrack(i+1,nums,k,current,result);
            current.remove(current.size()-1);
        }

    }
}