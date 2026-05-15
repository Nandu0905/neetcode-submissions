class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int start =nums[0];
        int j=0;
        for(int i=0;i<nums.length;i=j){
            int count =0;
            while(j<nums.length && nums[j]==start){
                count++;
                j++;
            }
            if(count>nums.length/2){
                return start;
            }
            if(j<nums.length){
                start = nums[j];
            }
        }   
        return -1;    
    }
}