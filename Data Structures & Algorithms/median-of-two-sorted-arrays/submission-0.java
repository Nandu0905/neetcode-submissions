class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int noOfElementsOnleft;
        if((nums1.length+nums2.length)%2==0){
            noOfElementsOnleft = (nums1.length+nums2.length)/2;
        }else{
            noOfElementsOnleft = (nums1.length+nums2.length+1)/2;
        }
        //now i know how many elements each side needs left and right now calculate the mid for shorter length array
        int low =0; 
        int high = nums1.length;
        double median=0;
        while(low<=high){
            int mid1 = low +(high-low)/2;
            //so choose mid1 elements from first array on left
            int mid2 = noOfElementsOnleft-mid1;
            //so mid2 elements from second array on left
            int l1,l2,r1,r2;
            l1 =(mid1==0) ? Integer.MIN_VALUE : nums1[mid1-1];
            r1 =(mid1==nums1.length) ? Integer.MAX_VALUE : nums1[mid1];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            r2 = (mid2 == nums2.length) ? Integer.MAX_VALUE : nums2[mid2];
            if(l1<=r2 && l2<=r1){
                // odd length
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(l1, l2);
                }
                // even length
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low=mid1+1;
            }

        }
        return median;
    }
}
