class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int sum=0;
        for(String str:tokens){
            if(str.equals("+") && st.size()>=2){
                int first = st.pop();
                int second = st.pop();
                st.push(first+second);
            }else if(str.equals("-")&& st.size()>=2){
                int first=st.pop();
                int second=st.pop();
                st.push(second-first);
            }else if(str.equals("*")&& st.size()>=2){
                int first = st.pop();
                int second=st.pop();
                st.push(second*first);
            }else if(str.equals("/")&& st.size()>=2){
                int first=st.pop();
                int second=st.pop();
                st.push(second/first);
            }else{
                st.push(Integer.parseInt(str));
            }
            
        }
        while(!st.isEmpty()){
            sum=sum+st.pop();
        }
        return sum;
    }
}
