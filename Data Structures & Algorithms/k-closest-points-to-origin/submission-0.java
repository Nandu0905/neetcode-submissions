class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Long,int[]>> pq = new PriorityQueue<>((a,b)->Long.compare(b.getKey(),a.getKey()));
        for(int[] num:points){
            long result=(long)(num[0]*num[0] )+ (long)(num[1]*num[1]);
            pq.offer(new AbstractMap.SimpleEntry<>(result,num));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll().getValue();
        }
        return res;    
    }
}
