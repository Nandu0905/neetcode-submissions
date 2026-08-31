class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Map.Entry<Integer, Character>> pq =
            new PriorityQueue<>((d, e) -> Integer.compare(e.getKey(), d.getKey()));
        if (a > 0)
            pq.offer(new AbstractMap.SimpleEntry(a, 'a'));
        if (b > 0)
            pq.offer(new AbstractMap.SimpleEntry(b, 'b'));
        if (c > 0)
            pq.offer(new AbstractMap.SimpleEntry(c, 'c'));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            if (sb.length() >= 2) {
                char first = sb.charAt(sb.length() - 1);
                char second = sb.charAt(sb.length() - 2);
                if (!(first == second && pq.peek().getValue() == first)) {
                    Map.Entry<Integer, Character> p = pq.poll();
                    sb.append(p.getValue());
                    int count = p.getKey();
                    if ((count - 1) > 0) {
                        pq.offer(new AbstractMap.SimpleEntry(count - 1, p.getValue()));
                    }
                } else if (pq.size() >= 2) {
                    Map.Entry<Integer, Character> p = pq.poll();
                    Map.Entry<Integer, Character> q = pq.poll();
                    sb.append(q.getValue());
                    int count = q.getKey();
                    if ((count - 1) > 0) {
                        pq.offer(new AbstractMap.SimpleEntry(count - 1, q.getValue()));
                    }
                    pq.offer(p);

                } else {
                    return sb.toString();
                }
            } else {
                Map.Entry<Integer, Character> p = pq.poll();
                sb.append(p.getValue());
                int count = p.getKey();
                if ((count - 1) > 0) {
                    pq.offer(new AbstractMap.SimpleEntry(count - 1, p.getValue()));
                }
            }
        }
        return sb.toString();
    }
}