class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int num : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() &&
                   num < 0 &&
                   st.peek() > 0) {
                int top = st.peek();
                if (top > Math.abs(num)) {
                    destroyed = true;
                    break;
                } else if (top == Math.abs(num)) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    st.pop();
                }
            }

            if (!destroyed) {
                st.push(num);
            }
        }

        int[] res = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}