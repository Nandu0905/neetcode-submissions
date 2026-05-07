class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)-> b.getValue() - a.getValue());
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(list.get(i).getKey());
        }
        int[] result = new int[res.size()];
        for(int i=0;i<result.length;i++){
            result[i] = res.get(i);
        }
        return result;
       
    }
}
