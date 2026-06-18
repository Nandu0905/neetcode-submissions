class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=']'){
                st.push(String.valueOf(s.charAt(i)));
            }else{
                StringBuilder str = new StringBuilder();
                while(!st.isEmpty() && !st.peek().equals("[")){
                    str.insert(0,st.pop());
                }
                st.pop();
                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    num.insert(0,st.pop());
                }
                StringBuilder expanded = new StringBuilder();
                int digit = Integer.parseInt(num.toString());
                for(int j=0;j<digit;j++){
                    expanded.append(str);
                }
                st.push(expanded.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}