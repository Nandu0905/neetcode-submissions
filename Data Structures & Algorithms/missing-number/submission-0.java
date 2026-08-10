class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum1=0;
        int sum=0;
        for(int i=0;i<=length;i++){
            sum^=i;
        }
        for(int num:nums){
            sum1^=num;
        }
        int result = sum^sum1;
        return result;
        
    }
}
