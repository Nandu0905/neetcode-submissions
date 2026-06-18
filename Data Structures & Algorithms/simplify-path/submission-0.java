class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        StringBuilder sb=new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals(".") && !arr[i].equals("") && !arr[i].equals("..")){
                st.push(arr[i]);
            }
            if(!st.isEmpty() && arr[i].equals("..")){
                st.pop();
            }
        }
        if(!st.isEmpty()){
            for(int i=0;i<st.size();i++){
                sb.append("/").append(st.get(i));
            }
        }else{
            sb.append("/");
        }
        return sb.toString();
    }
}