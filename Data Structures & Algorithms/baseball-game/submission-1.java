class Solution {
    public int calPoints(String[] operations) {
        int totalSum=0;
        Stack<Integer> s = new Stack<>();
        for(String str:operations){
            if(str.equals("+") && !s.isEmpty()){
                int sum=0;
                int first=s.pop();
                int second =s.pop();
                sum = first+second;
                s.push(second);
                s.push(first);
                s.push(sum);
            }else if(str.equals("D")){
                int previous = s.pop();
                s.push(previous);
                s.push(previous*2);
            }else if(str.equals("C")){
                s.pop();
            }else{
                s.push(Integer.parseInt(str));
            }
        }
        while(!s.isEmpty()){
            totalSum=totalSum+s.pop();
        }
        return totalSum;
    }
}