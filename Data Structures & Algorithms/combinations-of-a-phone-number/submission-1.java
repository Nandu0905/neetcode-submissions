class Solution {
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder current = new StringBuilder();
        List<String> result = new ArrayList<>();
        int index = 0;
        if (digits.isEmpty()) {
            return result;
        }

        backTrack(index, digits, current, result);
        return result;
    }
    private void backTrack(int index, String digits, StringBuilder current, List<String> result) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }
        String curr = map.get(digits.charAt(index));
        for (int i = 0; i < curr.length(); i++) {
            current.append(curr.charAt(i));
            backTrack(index + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
