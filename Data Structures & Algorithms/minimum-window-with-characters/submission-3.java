class Solution {
    public String minWindow(String s, String t) {
        int[] res = {-1,-1};
        Map<Character,Integer> tmap = new HashMap<>();
        for(char c:t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> smap = new HashMap<>();
        int match =tmap.size();
        int matchCount=0;
        int resLen =Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            smap.put(c,smap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))){
                matchCount++;
            }
            while(matchCount==match){
                if(right-left+1<resLen){
                    resLen = right-left+1;
                    res[0]=left;
                    res[1]=right;
                }
                char leftChar = s.charAt(left);
                smap.put(leftChar,smap.get(leftChar)-1);
                if(tmap.containsKey(leftChar) && smap.get(leftChar)<tmap.get(leftChar)){
                    matchCount--;
                }
                left++;
            }
        
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
