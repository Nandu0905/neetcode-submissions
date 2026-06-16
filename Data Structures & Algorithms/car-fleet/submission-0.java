class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Stack<Double> st = new Stack<>();
        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        for(int i=arr.length-1;i>=0;i--){
            double time = (double) (target - arr[i][0]) / arr[i][1];
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        }
        return st.size();
    }
}
