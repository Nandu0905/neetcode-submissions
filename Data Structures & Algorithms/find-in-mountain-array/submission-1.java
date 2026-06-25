class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();
        // Step 1: Find Peak Index
        int low = 0;
        int high = mountainArr.length() - 2; // because we access mid+1
        int res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        int peak= res;
        // Step 2: Search in ascending part
        int left = binarySearchAscending(
                mountainArr, 0, peak, target);
        if (left != -1) {
            return left;
        }
        // Step 3: Search in descending part
        return binarySearchDescending(
                mountainArr, peak + 1, n - 1, target);
    }

    private int binarySearchAscending(
            MountainArray mountainArr,
            int low,
            int high,
            int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            }
            if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binarySearchDescending(
            MountainArray mountainArr,
            int low,
            int high,
            int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            }
            if (value < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}