class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            int length = Math.min(prefix.length(),strs[i].length());
            int j=0;
            while(j<length && strs[i].charAt(j)==prefix.charAt(j)){
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}