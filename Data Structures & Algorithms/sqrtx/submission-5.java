class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high=x/2;
        int res=x;
        if(x==1) return 1;
        while(low<=high){
            int mid=low+(high-low)/2;
            long sqrt = (long) mid*mid;
            if(sqrt==x){
                return mid;
            }
            if(sqrt<x){
                res=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }
}