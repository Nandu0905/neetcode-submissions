class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0, result =0;
        for(int num : nums){
            if(result ==0){
                candidate = num;
            }
            if(num == candidate){
                result++;
            }else{
                result--;
            }
        }
        return candidate;
        
    }
}