class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=nums[left]){
                left=left+1;
                nums[left]=nums[right];
            }
        }
        return left+1;
    }
}