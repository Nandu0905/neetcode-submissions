class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] array = new int[26];
        for(char ch:tasks){
            array[ch-'A']++;
        }
        Arrays.sort(array);
        int maxF = array[25];
        int idle = (maxF-1)*n;
        for(int i=24;i>=0;i--){
            idle-=Math.min((maxF-1),array[i]);
        }
        return Math.max(0,idle)+tasks.length;
        
    }
}
