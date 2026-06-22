class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            sum = sum+weights[i];
            if(weights[i]>max){
                max=weights[i];
            }
        }
        int low = max;
        int high = sum;
        int ans=sum;
        while(low<=high){
            int mid = low+(high-low)/2;
            int currentWeight=0;
            int requiredDays=1;
            for(int i=0;i<weights.length;i++){
                if(currentWeight + weights[i]<=mid){
                    currentWeight+=weights[i];
                }else{
                    requiredDays++;
                    currentWeight =weights[i];
                }
            }
            if(requiredDays<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}