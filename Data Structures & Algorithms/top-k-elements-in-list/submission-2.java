class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        int[] res = new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]= result.get(i);
        }
        return res;
        
    }
}
