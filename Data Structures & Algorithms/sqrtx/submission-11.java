class Solution {
    public int mySqrt(int x) {
        int low=1;
        int high=x/2;
        int res=0;
        if(x==1 || x==0) return x;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==x/mid){
                return mid;
            }
            if(mid<x/mid){
                res=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }
}