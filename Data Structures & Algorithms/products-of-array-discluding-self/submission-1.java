class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product =1;
        int zeroCount=0;
        for(int num:nums){
            if(num!=0){
                product=product*num;
            }else{
                zeroCount++;
            }
        }
        int[] res = new int[nums.length];
        if(zeroCount>1){
            return res;
        }
        for(int i=0;i<res.length;i++){
            if(zeroCount>0){
                res[i] = (nums[i]==0) ? product: 0;
            }else{
                res[i] = product/nums[i];
            }
        }
       return res;
    }
}  
