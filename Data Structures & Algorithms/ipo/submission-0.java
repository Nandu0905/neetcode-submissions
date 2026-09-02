class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for (int i = 0; i < capital.length; i++) {
            pq.offer(new AbstractMap.SimpleEntry(i, capital[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!pq.isEmpty() && pq.peek().getValue() <= w) {
                int index = pq.poll().getKey();
                int profit = profits[index];
                maxHeap.offer(profit);
            }
            if (!maxHeap.isEmpty()) {
                w = w + maxHeap.poll();
            }
        }
        return w;
    }
}