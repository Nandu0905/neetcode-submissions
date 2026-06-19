class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high=x;
        int res=0;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if((long)mid*mid==x){
                return mid;
            }
            if((long)mid*mid<x){
                low=mid+1;
                res=mid;
            }else{
                high=mid-1;
            }
        }
        return res;
    }
}