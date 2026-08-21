class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high =x;
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long res =(long) mid*mid;
            if(res== x){
                return mid;
            }else if(res<x){
                result = (int)mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }
}