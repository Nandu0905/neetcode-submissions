class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int ans = max;
        int low=1,high=max;
        while(low<=high){
            int mid = low+(high-low)/2;
            int maxHours =0;
            for(int i=0;i<piles.length;i++){
                int remainder = piles[i]%mid;
                maxHours=maxHours+piles[i]/mid;
                if(remainder>0){
                    maxHours = maxHours+1;
                }
            }
            if(maxHours<=h){
                ans =mid;
                high = mid-1;
            }else if(maxHours>h){
                low =mid+1;
            }
        }
        return ans;
    }
}
