class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window = new HashMap<>();
        int left =0;
        int resLen=Integer.MAX_VALUE;
        int have=0, need = tmap.size();
        int[] res = {-1,-1};
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && window.get(c).equals(tmap.get(c))){
                have++;
            }
            while(have==need){
                if((right-left+1)<resLen){
                    resLen = right-left+1;
                    res[0]=left;
                    res[1]=right;

                }
                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(tmap.containsKey(leftChar) && window.get(leftChar)<tmap.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ?"" : s.substring(res[0],res[1]+1);
    }
}
