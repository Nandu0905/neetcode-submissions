class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                int count =map.get(c)-1;
                if(count==0){
                    map.remove(c);
                }else{
                    map.put(c, map.getOrDefault(c,0)-1);
                }  
            }
        }
        if(map.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
