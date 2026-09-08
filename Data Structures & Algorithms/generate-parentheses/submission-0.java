class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open=0;
        int close=0;
        StringBuilder sb = new StringBuilder();
        backTrack(open,close,n,sb,result);
        return result;
    }
    private void backTrack(int open,int close,int n, StringBuilder sb,List<String> result){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            backTrack(open+1,close,n,sb,result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sb.append(")");
            backTrack(open,close+1,n,sb,result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
