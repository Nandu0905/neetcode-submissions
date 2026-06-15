class Solution {
    public int calPoints(String[] operations) {
        int totalSum=0;
        Stack<Integer> s = new Stack<>();
        for(String str:operations){
            if(str.equals("+") && s.size()>=2){
                int sum=0;
                int first=s.get(s.size()-1);
                int second =s.get(s.size()-2);
                sum = first+second;
                totalSum =totalSum + s.push(sum);
            }else if(str.equals("D")){
                int previous = s.get(s.size()-1);
                totalSum = totalSum + s.push(previous*2);
            }else if(str.equals("C")){
                totalSum = totalSum-s.pop();
            }else{
                totalSum = totalSum +s.push(Integer.parseInt(str));
            }
        }
      
        return totalSum;
    }
}