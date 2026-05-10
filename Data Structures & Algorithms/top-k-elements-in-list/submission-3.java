class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length<k){
            return new int[]{0};
        }
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i).getKey();
        }
        return res;
    }
}
