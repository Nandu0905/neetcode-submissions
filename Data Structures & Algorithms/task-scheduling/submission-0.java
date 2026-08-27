class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq  =new PriorityQueue<>((a,b)-> Integer.compare(b.getValue(),a.getValue()));
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(entry);
        }
        int max=pq.poll().getValue();
        int maxFreq=1;
        while(!pq.isEmpty() && pq.peek().getValue()==max){
            pq.poll();
            maxFreq++;
        }
        int res = (max-1)*(n+1)+maxFreq;
        return Math.max(tasks.length,res);
    }
}
