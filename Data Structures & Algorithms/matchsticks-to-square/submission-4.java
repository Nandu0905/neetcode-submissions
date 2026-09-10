class Solution {
    public boolean makesquare(int[] matchsticks) {
        int[] bucket = new int[4];
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int required = sum/4;
        return backTrack(matchsticks,bucket,0,required);
    }
    private boolean backTrack(int[] matchsticks, int[] bucket,int index,int required) {
        if(index==matchsticks.length){
            return bucket[0]==required && bucket[1]==required && bucket[2]==required && bucket[3]==required;
        }
        int stick = matchsticks[index];
        for(int i=0;i<4;i++){
            if(bucket[i]+stick>required){
                continue;
            }
            bucket[i]+=matchsticks[index];
            if(backTrack(matchsticks,bucket,index+1,required)){
                return true;
            }
            bucket[i] -= stick;
        }
        return false;
    }
}