class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int res=nums.length;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                res = mid;
                high =mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}