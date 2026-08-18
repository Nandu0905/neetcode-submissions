class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int sum=0;
            int temp=n;
            while(temp>0){
            int remainder = temp%10;
            sum = sum+remainder*remainder;
            temp=temp/10;
            }
            n=sum;
        }
        return true;
    }
}
