class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int num:stones){
            pq.offer(num);
        }
        while(pq.size()>1){
            int firstHighest = pq.poll();
            int secondHighest = pq.poll();
            if(secondHighest<=firstHighest){
                pq.offer(firstHighest-secondHighest);
        }
    }
    return pq.poll();
}
}
