class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        for (int[] trip : trips) {
            pq.offer(trip);
        }
        PriorityQueue<int[]> p = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        int currentPassengers = 0;
        while (!pq.isEmpty()) {
            int[] topElement = pq.poll();
            while (!p.isEmpty() && p.peek()[2] <= topElement[1]) {
                currentPassengers -= p.poll()[0];
            }
            currentPassengers += topElement[0];
            if (currentPassengers > capacity) {
                return false;
            }
            p.offer(topElement);
        }

        return true;
    }
}