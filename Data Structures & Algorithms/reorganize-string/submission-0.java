class Solution {

    public String reorganizeString(String s) {

        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int prev = -1;
        while (sb.length() < s.length()) {
            int maxFreq = 0;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (j != prev && arr[j] > maxFreq) {
                    maxFreq = arr[j];
                    index = j;
                }
            }
            if (index == -1) {
                return "";
            }
            char c = (char) (index + 'a');
            sb.append(c);
            arr[index]--;
            prev = index;
        }
        return sb.toString();
    }
}