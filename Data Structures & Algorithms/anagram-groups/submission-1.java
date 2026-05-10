class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
        } 
        for(Map.Entry<String,List<String>> e:map.entrySet()){
            res.add(map.get(e.getKey()));
        } 
        return res; 
    }
}
