class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='[' || c=='(' || c=='{'){
                st.push(c);
            }
            if(c==']' || c==')' || c=='}'){
                if(!st.isEmpty()){
                    char top = st.pop();
                    if(c==']' && top!='[' || 
                    c==')' && top!= '('||
                     c=='}' && top!='{'){
                        return false;
                     }
                }else if(st.isEmpty()){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
