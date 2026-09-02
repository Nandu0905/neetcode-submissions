class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new AbstractMap.SimpleEntry((char) (i + 'a'), freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1)==(pq.peek().getKey())) {
                if (pq.size() > 1) {
                    Map.Entry<Character, Integer> entry = pq.poll();
                    Map.Entry<Character, Integer> entry2 =pq.poll();
                    char ch = entry2.getKey();
                    int count = entry2.getValue() - 1;
                    sb.append(ch);
                    if (count > 0) {
                        pq.offer(new AbstractMap.SimpleEntry(ch, count));
                    }
                    pq.offer(entry);
                } else {
                    return "";
                }
            } else {
                Map.Entry<Character, Integer> entry =pq.poll();
                char ch = entry.getKey();
                int count = entry.getValue() - 1;
                sb.append(ch);
                if (count > 0) {
                    pq.offer(new AbstractMap.SimpleEntry(ch, count));
                }
            }
        }
        return sb.toString();
    }
}