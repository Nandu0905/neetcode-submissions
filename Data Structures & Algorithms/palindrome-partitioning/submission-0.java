class Solution {
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        backTrack(0,s,current,result);
        return result;
    }
    private void backTrack(int start,String s,List<String> current, List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            String part = s.substring(start,i+1);
            StringBuilder sb = new StringBuilder(part);
            sb.reverse();
            if(sb.toString().equals(part)){
                current.add(part);
                backTrack(i+1,s,current,result);
                current.remove(current.size() - 1);
            }
        }
    }
}
