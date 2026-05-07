class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product=1,zeroCount =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                product = product*nums[i];
            }else{
                zeroCount++;
            }
        }
        if(zeroCount>1){
            return new int[nums.length];
        }

        for (int i=0; i<res.length;i++){
            if(zeroCount>0){
                res[i]=(nums[i]==0)?product:0;
            }else{
                res[i] = product/nums[i];
            }
        }
        return res;
    }
}  
