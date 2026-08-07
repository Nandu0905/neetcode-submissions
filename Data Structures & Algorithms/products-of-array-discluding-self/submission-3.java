class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lp = new int[nums.length];
        int[] rp = new int[nums.length];
        int[] res = new int[nums.length];
        lp[0] =1;
        for(int i=1;i<lp.length;i++){
            lp[i]=lp[i-1]*nums[i-1];
        }
        rp[rp.length-1]=1;
        for(int i=rp.length-2;i>=0;i--){
            rp[i] =rp[i+1]*nums[i+1];
        }
        for(int i=0;i<res.length;i++){
            res[i]=lp[i]*rp[i];
        }
        return res;
    }
}  
