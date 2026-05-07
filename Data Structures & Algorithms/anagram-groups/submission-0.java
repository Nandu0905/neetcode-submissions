class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] asc =strs[i].toCharArray();
            Arrays.sort(asc);
            String combinedAsc = new String(asc);
            if(map.containsKey(combinedAsc)){
                map.get(combinedAsc).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(combinedAsc,list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String str:map.keySet()){
             List<String> values = map.get(str);
             res.add(values); 
        }
        return res;
        
    }
}
