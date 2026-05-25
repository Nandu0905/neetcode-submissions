class Solution {
    public int[] reverse(int[] nums,int left, int right){
            while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        return nums;
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int start=0;
        int end = nums.length-1;
        reverse(nums,start,end);
        reverse(nums,start,k-1);
        reverse(nums,k,end);
    }
}