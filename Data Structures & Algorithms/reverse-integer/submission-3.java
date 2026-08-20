class Solution {
    public int reverse(int x) {
        int min =Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int rev=0;
        while(x!=0){
            int remainder = x%10;
            x=x/10;
            if(rev<min/10 || rev>max/10){
                return 0;
            }
            if(rev==min/10 && remainder<-8){
                return 0;
            }
            if(rev==max/10 && remainder>7){
                return 0;
            }
            rev=rev*10+remainder;
        }
        return rev;
    }
}
