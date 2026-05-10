class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int zeroCount=0;
        int[] res = new int[nums.length];
        for(int num:nums){
            if(num!=0){
                product = product*num;
            }else{
                zeroCount++;
            }
        }
        if(zeroCount>1){
            return new int[nums.length];
        }
        for(int i=0;i<nums.length;i++){
            if(zeroCount>0){
                res[i]= (nums[i]!=0 ? 0:product);
        }else{
            res[i]= product/nums[i];
        }

        }
       return res; 
    }
}  
