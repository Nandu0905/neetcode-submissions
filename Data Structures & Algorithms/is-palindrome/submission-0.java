class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(!Character.isLetterOrDigit(arr[left])){
                left++;
            }else if (!Character.isLetterOrDigit(arr[right])){
                right--;
            }else if(arr[left]==arr[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
