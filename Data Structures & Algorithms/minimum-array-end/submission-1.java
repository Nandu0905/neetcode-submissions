class Solution {
    public long minEnd(int n, int x) {
        long res =x;
        int extra = n-1;
        int bit=0;
        while(extra>0){
            if((x&(1L<<bit))==0){
                if((extra&1)==1){
                    res = res|(1L<<bit);
                }
                extra=extra>>1;
            }
            bit++;
        }
        return res;
    }
}