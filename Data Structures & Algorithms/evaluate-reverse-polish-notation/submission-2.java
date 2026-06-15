class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") ||
                str.equals("*") || str.equals("/")) {
                if (st.size() < 2) {
                    throw new IllegalArgumentException("Invalid RPN expression");
                }
                int first = st.pop();
                int second = st.pop();
                switch (str) {
                    case "+":
                        st.push(second + first);
                        break;
                    case "-":
                        st.push(second - first);
                        break;
                    case "*":
                        st.push(second * first);
                        break;
                    case "/":
                        st.push(second / first);
                        break;
                }

            } else {
                try {
                    st.push(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                        "Invalid token: " + str
                    );
                }
            }
        }

        if (st.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }

        return st.pop();
    }
}