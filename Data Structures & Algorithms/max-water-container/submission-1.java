class Solution {
    public int maxArea(int[] heights) {
        int left=0,right=heights.length-1;
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int area = (right-left)*Math.min(heights[left],heights[right]);
            maxArea = Math.max(area,maxArea);
            if(heights[left]<=heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
        
    }
}
