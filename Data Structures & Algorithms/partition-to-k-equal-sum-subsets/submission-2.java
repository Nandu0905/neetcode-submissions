class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] bucket = new int[k];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        int required = sum / k;
        return backTrack(nums, bucket, 0, required, k);
    }
    private boolean backTrack(int[] nums, int[] bucket, int index, int required, int k) {
        if (index == nums.length) {
            for (int i = 0; i < k; i++) {
                if (bucket[i] != required) {
                    return false;
                }
            }
            return true;
        }
        int stick = nums[index];
        for (int i = 0; i < k; i++) {
            if (bucket[i] + stick > required) {
                continue;
            }
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }
            bucket[i] += nums[index];
            if (backTrack(nums, bucket, index + 1, required, k)) {
                return true;
            }
            bucket[i] -= stick;
        }
        return false;
    }
}