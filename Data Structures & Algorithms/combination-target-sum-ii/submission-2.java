class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int remaining = target;
        backTrack(0, remaining, target, candidates, current, result);
        return result;
    }
    private void backTrack(int index, int remaining, int target, int[] candidates,
        List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > remaining) {
                break;
            }
            current.add(candidates[i]);
            backTrack(i + 1, remaining - candidates[i], target, candidates, current, result);
            current.remove(current.size() - 1);
        }
    }
}
