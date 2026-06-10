class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum =0;
        int left=0;
        int minLength=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum = sum+nums[right];
            while(sum>=target){
                minLength=Math.min((right-left+1),minLength);
                sum = sum-nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ?0:minLength;
    }
}